package com.peerislands.sqlenhancer.dto;

import java.util.LinkedList;
import java.util.List;

import com.peerislands.sqlenhancer.engine.SqlComponentVisitor;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
public class JoinTables extends AbstractCompositeComponent {
	
	List<JoinTable> joins;
	
	@Override
	protected String performExtraOpertion() {
		return EMPTY;
	}

	@Override
	protected List<SqlComponent> getComponents() {
		List<SqlComponent> components = new LinkedList<SqlComponent>();
		components.addAll(this.joins);
		return components;
	}

	@Override
	protected String visit(SqlComponentVisitor visitor) {
		return visitor.visit(this);
	}
	

}
