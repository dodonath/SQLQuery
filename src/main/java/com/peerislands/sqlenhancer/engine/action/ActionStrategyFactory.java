package com.peerislands.sqlenhancer.engine.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.peerislands.sqlenhancer.util.Operator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ActionStrategyFactory {
	
	@Autowired
	private BetweenStrategy betweenStrategy;
	
	@Autowired
	private EqualsToStrategy equalsToStrategy;
	
	@Autowired
	private GreaterThanEqualsStrategy greaterThanEqualsStrategy;
	
	@Autowired
	private GreaterThanStrategy greaterThanStrategy;
	
	@Autowired
	private InStrategy inStrategy;
	
	@Autowired
	private IsNotNullStrategy isNotNullStrategy;
	
	@Autowired
	private IsNullStrategy isNullStrategy;
	
	@Autowired
	private LessThanEqualsStrategy lessThanEqualsStrategy;
	
	@Autowired
	private LessThanStrategy lessThanStrategy;
	
	@Autowired
	private LikeStrategy likeStrategy;
	
	@Autowired
	private NotEqualsToStrategy notEqualsToStrategy;
	
	@Autowired
	private NotInStrategy notInStrategy;
	
	@Autowired
	private DefaultStrategy defaultStrategy;
	
	
	public ActionStrategy getAction(Operator operator) {
		
		ActionStrategy strategy = defaultStrategy;
		
		log.info("Evaluating individual operation = {} ",operator);
		
		if(operator==null) {
			return strategy;
		}
		
		switch(operator) {

		case EQUALS_TO : 

			strategy = equalsToStrategy;
			break;

		case NOT_EQUALS_TO : 
			strategy = notEqualsToStrategy;
			break;

		case IS_NOT_NULL : 
			strategy = isNotNullStrategy;
			break;

		case IS_NULL : 
			strategy = isNullStrategy;
			break;

		case GREATER_THAN : 
			strategy = greaterThanStrategy;
			break;

		case GREATER_THAN_EQUALS : 
			strategy = greaterThanEqualsStrategy;
			break;

		case LESS_THAN : 
			strategy = lessThanStrategy;
			break;

		case LESS_THAN_EQUALS : 
			strategy = lessThanEqualsStrategy;
			break;

		case IN : 
			strategy = inStrategy;
			break;

		case NOT_IN : 
			strategy = notInStrategy;
			break;

		case BETWEEN : 
			strategy = betweenStrategy;
			break;

		case LIKE : 
			strategy = likeStrategy;
			break;

		default:
			break;

		}
		
		return strategy;
		
	}
	

}
