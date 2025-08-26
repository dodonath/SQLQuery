package com.peerislands.sqlenhancer.dto;

import java.util.LinkedList;
import java.util.List;

import com.peerislands.sqlenhancer.engine.SqlComponentVisitor;
import com.peerislands.sqlenhancer.util.SqlConstant;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
public class SelectColumn extends AbstractCompositeComponent {
	
	private List<Column> columns; 
	

	@Override
	protected String performExtraOpertion() {
		return SqlConstant.COMMA;
	}

	@Override
	protected List<SqlComponent> getComponents() {
		List<SqlComponent> components = new LinkedList<SqlComponent>();
		components.addAll(this.columns);
		return components;
	}


	@Override
	protected String visit(SqlComponentVisitor visitor) {
		return visitor.visit(this);
	}



	

}
