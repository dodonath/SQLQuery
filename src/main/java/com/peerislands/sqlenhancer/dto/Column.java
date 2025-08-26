package com.peerislands.sqlenhancer.dto;

import java.util.List;

import com.peerislands.sqlenhancer.engine.SqlComponentVisitor;
import com.peerislands.sqlenhancer.util.ColumnType;
import com.peerislands.sqlenhancer.util.OrderByType;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
public class Column extends AbstractLeafComponent{
	
	private String entityName;
	private String name;
	private ColumnType columnType;
	private List<String> columnValues;
	private OrderByType orderBy;


	@Override
	protected String visit(SqlComponentVisitor visitor) {
		return visitor.visit(this);
	}
	
	
	
}
