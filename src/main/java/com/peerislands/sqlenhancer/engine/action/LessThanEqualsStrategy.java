package com.peerislands.sqlenhancer.engine.action;

import org.springframework.stereotype.Component;

import com.peerislands.sqlenhancer.util.Operator;
import com.peerislands.sqlenhancer.util.SqlConstant;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LessThanEqualsStrategy implements ActionStrategy{

	@Override
	public String execute(String subExpresssion) {
		
		log.info("Evaluating LessThanEqualsStrategy with subExpresssion={}",subExpresssion);
		StringBuilder expression = new StringBuilder();
		expression.append(Operator.LESS_THAN_EQUALS.getOperator());
		expression.append(SqlConstant.WHITE_SPACE);
		expression.append(subExpresssion);
		return expression.toString();
	}
	
	
	

}
