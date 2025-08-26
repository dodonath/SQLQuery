package com.peerislands.sqlenhancer.engine.action;

import org.springframework.stereotype.Component;

import com.peerislands.sqlenhancer.util.Operator;
import com.peerislands.sqlenhancer.util.SqlConstant;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LessThanStrategy implements ActionStrategy{

	@Override
	public String execute(String subExpresssion) {
		
		log.info("Evaluating LessThanStrategy with subExpresssion={}",subExpresssion);
		StringBuilder expression = new StringBuilder();
		expression.append(Operator.LESS_THAN.getOperator());
		expression.append(SqlConstant.WHITE_SPACE);
		expression.append(subExpresssion);
		return expression.toString();
	}
	
	
	

}
