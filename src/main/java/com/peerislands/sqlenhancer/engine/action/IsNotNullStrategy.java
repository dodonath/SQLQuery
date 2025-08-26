package com.peerislands.sqlenhancer.engine.action;

import org.springframework.stereotype.Component;

import com.peerislands.sqlenhancer.util.Operator;
import com.peerislands.sqlenhancer.util.SqlConstant;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class IsNotNullStrategy implements ActionStrategy{

	@Override
	public String execute(String subExpresssion) {
		
		log.info("Evaluating IsNotNullStrategy with subExpresssion={}",subExpresssion);
		StringBuilder expression = new StringBuilder();
		expression.append(Operator.IS_NOT_NULL.getOperator());
		return expression.toString();
	}
	
	
	

}
