package com.peerislands.sqlenhancer.engine.action;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DefaultStrategy implements ActionStrategy{

	@Override
	public String execute(String subExpresssion) {
		log.info("Evaluating DefaultStrategy with subExpresssion={}",subExpresssion);
		return subExpresssion;
	}
	
	
	

}
