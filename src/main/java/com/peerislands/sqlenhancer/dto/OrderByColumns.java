package com.peerislands.sqlenhancer.dto;

import java.util.LinkedList;
import java.util.List;

import com.peerislands.sqlenhancer.engine.SqlComponentVisitor;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class OrderByColumns extends AbstractCompositeComponent{
	
	private List<Column> orderBys;

	@Override
	protected String performExtraOpertion() {
		return EMPTY;
	}

	@Override
	protected String visit(SqlComponentVisitor visitor) {
		return visitor.visit(this);
	}

	@Override
	protected List<SqlComponent> getComponents() {
		List<SqlComponent> components = new LinkedList<SqlComponent>();
		components.addAll(this.orderBys);
		return components;
	}



}
