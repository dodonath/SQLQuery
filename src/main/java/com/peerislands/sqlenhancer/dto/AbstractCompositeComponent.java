package com.peerislands.sqlenhancer.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.peerislands.sqlenhancer.engine.SqlComponentVisitor;

import lombok.Data;

@Data
public abstract class AbstractCompositeComponent implements SqlComponent{
	
	public static final String EMPTY = "";
	
	@JsonIgnore
	protected List<SqlComponent> components;
	
	@JsonIgnore
	protected String subExpresssion = "";
	
	@Override
	public String accept(SqlComponentVisitor visitor) {

		this.components = getComponents();
		StringBuilder expresssion  = new StringBuilder();
		for(SqlComponent component : components) {
			if(component!=null) {
				expresssion.append(component.accept(visitor));
				expresssion.append(performExtraOpertion());
			}
		}
		this.subExpresssion = expresssion.toString();
		return visit(visitor);
	}

	protected abstract String performExtraOpertion();

	protected abstract List<SqlComponent> getComponents();
	
	protected abstract String visit(SqlComponentVisitor visitor);

}
