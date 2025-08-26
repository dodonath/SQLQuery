package com.peerislands.sqlenhancer.dto;

import java.util.LinkedList;
import java.util.List;

import com.peerislands.sqlenhancer.engine.SqlComponentVisitor;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Select extends AbstractCompositeComponent{
	
	private SelectColumn fromColumn;
	
	private FromTable from;
	
	private JoinTables join;
	
	private Where where;
	
	private OrderByColumns orderBy;
	
	
	@Override
	protected List<SqlComponent> getComponents() {
		List<SqlComponent> components = new LinkedList<>();
		components.add(this.fromColumn);
		components.add(this.from);
		components.add(this.join);
		components.add(this.where);
		components.add(this.orderBy);
		return components;
	}

	@Override
	protected String visit(SqlComponentVisitor visitor) {
		return visitor.visit(this);
	}

	@Override
	protected String performExtraOpertion() {
		return EMPTY;
	}
	
	
	
	
	
	
	

}
