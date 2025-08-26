package com.peerislands.sqlenhancer.engine;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.peerislands.sqlenhancer.dto.Column;
import com.peerislands.sqlenhancer.dto.Condition;
import com.peerislands.sqlenhancer.dto.Expression;
import com.peerislands.sqlenhancer.dto.FromTable;
import com.peerislands.sqlenhancer.dto.JoinTable;
import com.peerislands.sqlenhancer.dto.JoinTables;
import com.peerislands.sqlenhancer.dto.OrderByColumns;
import com.peerislands.sqlenhancer.dto.Select;
import com.peerislands.sqlenhancer.dto.SelectColumn;
import com.peerislands.sqlenhancer.dto.TableDetails;
import com.peerislands.sqlenhancer.dto.Where;
import com.peerislands.sqlenhancer.engine.action.ActionStrategyFactory;
import com.peerislands.sqlenhancer.util.Operator;
import com.peerislands.sqlenhancer.util.ResponseMessage;
import com.peerislands.sqlenhancer.util.SqlConstant;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SqlComponentVisitorImpl implements SqlComponentVisitor{
	
	@Autowired
	private ActionStrategyFactory actionStrategyFactory;
	
	public String visit(Select select) {

		try {
			if(Objects.isNull(select)) 
				throw new RuntimeException(ResponseMessage.SUBQUERY_MESSAGE_EMPTY);
			log.info("Evaluating select = {}",select);
			StringBuilder expression = new StringBuilder();
			expression.append(SqlConstant.SELECT);
			expression.append(select.getSubExpresssion());
			log.info("The select = {}", expression.toString());
			return expression.toString();
		}
		catch(Exception e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	@Override
	public String visit(FromTable from) {

		try {
			if(Objects.isNull(from)) 
				throw new RuntimeException(ResponseMessage.FROM_MESSAGE_EMPTY);

			log.info("Evaluating from = {}",from);
			StringBuilder expression = new StringBuilder();
			
			expression.append(SqlConstant.WHITE_SPACE);
			expression.append(SqlConstant.FROM);
			

			switch(from.getType()) {

			case NORMAL :
				expression.append(SqlConstant.WHITE_SPACE);
				expression.append(from.getSubExpresssion());
				break;

			case SUBQUERY : 
				expression.append(SqlConstant.WHITE_SPACE);
				expression.append(SqlConstant.OPEN_PARENTHESIS +from.getSubExpresssion()+ SqlConstant.CLOSE_PARENTHESIS);
				expression.append(SqlConstant.WHITE_SPACE);
				expression.append(from.getEntityName());
				break;

			default:
				break;

			}
			log.info("The from = {}", expression.toString());
			return expression.toString();

		}
		catch(Exception e) {
			log.error(e.getMessage(),e);
			throw new RuntimeException("Error in evaluateFrom {}"+e.getMessage(), e);
		}
	}
	
	@Override
	public String visit(JoinTables joins) {
		try {
			log.info("Evaluating joins = {}",joins);
			StringBuilder expression = new StringBuilder();
			expression.append(SqlConstant.WHITE_SPACE);
			expression.append(SqlConstant.COMMA);
			expression.append(joins.getSubExpresssion());
			log.info("The joins = {}", expression.toString());
			return StringUtils.chop(expression.toString());
		}
		catch(Exception e) {
			log.error(e.getMessage(),e);
			throw new RuntimeException("Error in evaluateJoin {}"+e.getMessage(), e);
		}
	
	}
	
	@Override
	public String visit(JoinTable joinTable) {

		try {
			if(Objects.isNull(joinTable)) 
				throw new RuntimeException(ResponseMessage.FROM_MESSAGE_EMPTY);

			log.info("Evaluating joinTable = {}",joinTable);
			StringBuilder expression = new StringBuilder();
			
			expression.append(SqlConstant.WHITE_SPACE);

			switch(joinTable.getType()) {

			case NORMAL :
				expression.append(SqlConstant.WHITE_SPACE);
				expression.append(joinTable.getSubExpresssion());
				break;

			case SUBQUERY : 
				expression.append(SqlConstant.WHITE_SPACE);
				expression.append(SqlConstant.OPEN_PARENTHESIS +joinTable.getSubExpresssion()+ SqlConstant.CLOSE_PARENTHESIS);
				expression.append(SqlConstant.WHITE_SPACE);
				expression.append(joinTable.getEntityName());
				break;

			default:
				break;

			}
			expression.append(SqlConstant.COMMA);
			log.info("The joinTable = {}", expression.toString());
			return expression.toString();

		}
		catch(Exception e) {
			log.error(e.getMessage(),e);
			throw new RuntimeException("Error in evaluateFrom {}"+e.getMessage(), e);
		}
	}

	@Override
	public String visit(TableDetails tableDetails) {
		log.info("Evaluating tableDetails = {}  for tableDetails",tableDetails);
		if(Objects.isNull(tableDetails)) 
			throw new RuntimeException(ResponseMessage.TABLE_MESSAGE_EMPTY);
		return StringUtils.isNotBlank(tableDetails.getEntityName()) ? tableDetails.getName() + SqlConstant.WHITE_SPACE +tableDetails.getEntityName() : tableDetails.getName();
	}
	
	

	@Override
	public String visit(SelectColumn selectColumn) {
		try {
			if(Objects.isNull(selectColumn) ) 
				throw new RuntimeException(ResponseMessage.FROM_MESSAGE_EMPTY);

			log.info("Evaluating from select columns = {}",selectColumn);
			StringBuilder expression = new StringBuilder();

			expression.append(SqlConstant.WHITE_SPACE);
			expression.append(StringUtils.chop(selectColumn.getSubExpresssion()));

			log.info("The from = {}", expression.toString());
			return expression.toString();

		}
		catch(Exception e) {
			log.error(e.getMessage(),e);
			throw new RuntimeException("Error in evaluateFrom {}"+e.getMessage(), e);
		}

	}

	@Override
	public String visit(Column column) {
		
		log.info("Evaluating column = {}  for columnName",column);
		if(Objects.isNull(column)) 
			throw new RuntimeException(ResponseMessage.COLUMN_MESSAGE_EMPTY);
		
		if(CollectionUtils.isNotEmpty(column.getColumnValues())) {
			return evaluateColumnValues(column);
		}
		
		if(Objects.nonNull(column.getOrderBy())) {
			return evaluateOrderBy(column);
		}
		return evaluateColumnName(column);
	}
	
	

	private String evaluateColumnName(Column column) {
		return StringUtils.isNotBlank(column.getEntityName()) ? column.getEntityName()+"."+column.getName() : column.getName();
	}

	private String evaluateOrderBy(Column column) {
		log.info("Evaluating orderByColumn = {}",column.getOrderBy());
		StringBuilder expression = new StringBuilder();
		expression.append(SqlConstant.WHITE_SPACE);
		expression.append(evaluateColumnName(column)+SqlConstant.WHITE_SPACE + column.getOrderBy().name());
		expression.append(SqlConstant.COMMA);
		log.info("The orderBy = {}", column.toString());
		return expression.toString();
	}

	private String evaluateColumnValues(Column column) {
		StringBuilder expression = new StringBuilder();
		
		List<String> columnValues = column.getColumnValues();
		switch(column.getColumnType()) {
		case STRING : 
			expression.append(StringUtils.join(columnValues.parallelStream().map(value -> "\'"+ value + "\' ").collect(Collectors.toList()),","));
			break;

		case NUMBER : 
			expression.append(StringUtils.join(columnValues,","));
			break;

		default:
			break;
		}
		return expression.toString();
	}

	

	@Override
	public String visit(Where where) {
		try {
			log.info("Evaluating where");
			StringBuilder expression = new StringBuilder();
			
			if(Objects.nonNull(where)) {
				expression.append(SqlConstant.WHITE_SPACE);
				expression.append(SqlConstant.WHERE);
				expression.append(where.getSubExpresssion());
			}
			log.info("The where = {}", expression.toString());
			return expression.toString();
		}
		catch(Exception e) {
			log.error(e.getMessage(),e);
			throw new RuntimeException("Error in evaluate where = {}"+e.getMessage(),e);
		}
	}

	@Override
	public String visit(Expression exp) {
		log.info("Evaluating individual Expression values = {}",exp);

		StringBuilder expression = new StringBuilder();
		switch(exp.getType()) {
		case SUBQUERY : 
			exp.setSubExpresssion(SqlConstant.OPEN_PARENTHESIS +exp.getSubExpresssion() + SqlConstant.CLOSE_PARENTHESIS);
			break;

		case NORMAL : 
		default:
			break;
		}
		
		expression.append(SqlConstant.WHITE_SPACE);
		if(exp.getOperator()!=null) {
			expression.append(evaluateOperation(exp.getOperator(),exp.getSubExpresssion()));
		}
		else {
			expression.append(exp.getSubExpresssion());
		}
		log.info("The individual Expression = {}", expression.toString());
		return expression.toString();
	}

	

	private String evaluateOperation(Operator operator, String subExpresssion) {
		return actionStrategyFactory.getAction(operator).execute(subExpresssion);
	}

	@Override
	public String visit(Condition condition) {

		log.info("Evaluating individual condition = {}",condition);
		StringBuilder expression = new StringBuilder();
		expression.append(SqlConstant.WHITE_SPACE)  ;
		expression.append(condition.getSubExpresssion());
		if(condition.getAppendWith()!=null) {
			expression.append(SqlConstant.WHITE_SPACE)  ;
			expression.append(condition.getAppendWith());
		}
		log.info("The individual condition = {}", expression.toString());
		return expression.toString();
	
	}

	@Override
	public String visit(OrderByColumns orderBys) {

		log.info("Evaluating orderBys = {}",orderBys);
		StringBuilder expression = new StringBuilder();
		if(CollectionUtils.isNotEmpty(orderBys.getOrderBys())) {
			expression.append(SqlConstant.WHITE_SPACE);
			expression.append(SqlConstant.ORDER_BY);
			expression.append(SqlConstant.WHITE_SPACE);
			expression.append(StringUtils.chop(orderBys.getSubExpresssion()));
		}
		log.info("The orderBys = {}", expression.toString());
		return expression.toString();
	}
	
	
	
	

}
