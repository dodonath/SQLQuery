package com.peerislands.sqlenhancer.engine.action;

import org.springframework.stereotype.Component;

import com.peerislands.sqlenhancer.util.Operator;
import com.peerislands.sqlenhancer.util.SqlConstant;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class NotInStrategy implements ActionStrategy{

	@Override
	public String execute(String subExpresssion) {
		
		log.info("Evaluating NotInStrategy with subExpresssion={}",subExpresssion);
		StringBuilder expression = new StringBuilder();
		expression.append(Operator.NOT_IN.getOperator());
		expression.append(SqlConstant.WHITE_SPACE);
		expression.append(SqlConstant.OPEN_PARENTHESIS +subExpresssion+SqlConstant.CLOSE_PARENTHESIS);
		return expression.toString();
	}
	
	
	

}
