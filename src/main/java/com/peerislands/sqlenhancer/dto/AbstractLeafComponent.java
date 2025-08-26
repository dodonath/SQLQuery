package com.peerislands.sqlenhancer.dto;

import com.peerislands.sqlenhancer.engine.SqlComponentVisitor;

public abstract class AbstractLeafComponent implements SqlComponent{
	
	public static final String EMPTY = "";
	
		
	@Override
	public String accept(SqlComponentVisitor visitor) {
		return visit(visitor);
	}

	protected abstract String visit(SqlComponentVisitor visitor);

}
