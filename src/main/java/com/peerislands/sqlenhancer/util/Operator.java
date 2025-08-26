package com.peerislands.sqlenhancer.util;

public enum Operator{
	
	IN("IN"), 
	NOT_IN("NOT IN"),
	LIKE("LIKE"),
	GREATER_THAN(">"),
	LESS_THAN("<"),
	GREATER_THAN_EQUALS(">="),
	LESS_THAN_EQUALS("<="),
	EQUALS_TO("="),
	NOT_EQUALS_TO("!="),
	IS_NULL("IS NULL"),
	IS_NOT_NULL("IS NOT NULL"),
	BETWEEN("between");

    String operator;

    Operator(String operator) {
        this.operator = operator;
    }

	public String getOperator() {
		return operator;
	}

	
    

}
