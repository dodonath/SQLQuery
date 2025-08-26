package com.peerislands.sqlenhancer.dto;

import java.util.LinkedList;
import java.util.List;

import org.springframework.lang.Nullable;

import com.peerislands.sqlenhancer.engine.SqlComponentVisitor;
import com.peerislands.sqlenhancer.util.Operator;
import com.peerislands.sqlenhancer.util.QueryType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Expression extends AbstractCompositeComponent{
	
	private QueryType type;
	
	private Column column;
	
	private Select subquery;
	
	@Nullable
	private Operator operator;


	@Override
	protected String performExtraOpertion() {
		return EMPTY;
	}


	@Override
	protected List<SqlComponent> getComponents() {
		List<SqlComponent> components = new LinkedList<SqlComponent>();
		components.add(this.column);
		components.add(this.subquery);
		return components;
	}


	@Override
	protected String visit(SqlComponentVisitor visitor) {
		return visitor.visit(this);
	}
	
	
	
	
      
}
