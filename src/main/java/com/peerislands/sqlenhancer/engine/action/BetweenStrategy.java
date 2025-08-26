package com.peerislands.sqlenhancer.engine.action;

import org.springframework.stereotype.Component;

import com.peerislands.sqlenhancer.util.AppendType;
import com.peerislands.sqlenhancer.util.Operator;
import com.peerislands.sqlenhancer.util.SqlConstant;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class BetweenStrategy implements ActionStrategy{

	@Override
	public String execute(String subExpresssion) {
		
		log.info("Evaluating BetweenStrategy with subExpresssion={}",subExpresssion);
		StringBuilder expression = new StringBuilder();
		String[] columnValues = subExpresssion.split(SqlConstant.COMMA);	
		expression.append(Operator.BETWEEN.getOperator());
		expression.append(SqlConstant.WHITE_SPACE);
		expression.append(columnValues[0]);
		expression.append(SqlConstant.WHITE_SPACE);
		expression.append(AppendType.AND.name() );
		expression.append(SqlConstant.WHITE_SPACE);
		expression.append(columnValues[1]);
		expression.append(SqlConstant.WHITE_SPACE);
		return expression.toString();
	}
	
	
	

}
