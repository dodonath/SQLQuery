package com.peerislands.sqlenhancer.dto;

import java.util.LinkedList;
import java.util.List;

import org.springframework.lang.Nullable;

import com.peerislands.sqlenhancer.engine.SqlComponentVisitor;
import com.peerislands.sqlenhancer.util.AppendType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Condition extends AbstractCompositeComponent{
	
	private Expression lhs;
	private Expression rhs;
	
	@Nullable
	private AppendType appendWith;

	@Override
	protected String performExtraOpertion() {
		return EMPTY;
	}

	@Override
	protected List<SqlComponent> getComponents() {
		List<SqlComponent> components = new LinkedList<SqlComponent>();
		components.add(this.lhs);
		components.add(this.rhs);
		return components;
	}

	@Override
	protected String visit(SqlComponentVisitor visitor) {
		return visitor.visit(this);
	}
	
	
	
	

}
