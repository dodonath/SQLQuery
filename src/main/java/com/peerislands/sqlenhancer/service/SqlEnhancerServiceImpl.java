package com.peerislands.sqlenhancer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peerislands.sqlenhancer.dto.Select;
import com.peerislands.sqlenhancer.engine.SqlComponentVisitor;

import lombok.extern.slf4j.Slf4j;

/**
 * This is the service class for the sql parser
 * 
 * @author Dodo
 *
 */
@Slf4j
@Service
public class SqlEnhancerServiceImpl implements SqlEnhancerService{
	
	
	@Autowired
	private SqlComponentVisitor visitor;
	
	
	/**
	 * This method serves as a gateway to the engine
	 * @param input
	 * @param header
	 * @return
	 */
	@Override
	public String getSqlString(Select input) {
		log.info("Processing input in the service layer");
		return input.accept(visitor);
	}

}
