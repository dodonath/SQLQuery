package com.peerislands.sqlenhancer.dto;

import com.peerislands.sqlenhancer.engine.SqlComponentVisitor;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TableDetails extends AbstractLeafComponent{
	
	private String name;
	private String entityName;

	@Override
	protected String visit(SqlComponentVisitor visitor) {
		return visitor.visit(this);
	}

}
