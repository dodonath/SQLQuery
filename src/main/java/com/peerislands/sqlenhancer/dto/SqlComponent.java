package com.peerislands.sqlenhancer.dto;

import com.peerislands.sqlenhancer.engine.SqlComponentVisitor;

public interface SqlComponent {
	
	String accept(SqlComponentVisitor visitor);

}
