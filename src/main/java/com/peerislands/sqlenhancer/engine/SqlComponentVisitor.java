package com.peerislands.sqlenhancer.engine;

import com.peerislands.sqlenhancer.dto.Column;
import com.peerislands.sqlenhancer.dto.Condition;
import com.peerislands.sqlenhancer.dto.Expression;
import com.peerislands.sqlenhancer.dto.FromTable;
import com.peerislands.sqlenhancer.dto.JoinTable;
import com.peerislands.sqlenhancer.dto.JoinTables;
import com.peerislands.sqlenhancer.dto.OrderByColumns;
import com.peerislands.sqlenhancer.dto.Select;
import com.peerislands.sqlenhancer.dto.SelectColumn;
import com.peerislands.sqlenhancer.dto.TableDetails;
import com.peerislands.sqlenhancer.dto.Where;

public interface SqlComponentVisitor {
	
	
	public String visit(Select select);

	public String visit(FromTable fromTable);

	public String visit(TableDetails tableDetails);

	public String visit(SelectColumn selectColumn);

	public String visit(Column column);

	public String visit(JoinTables joinTables);

	public String visit(JoinTable joinTable);

	public String visit(Where where);

	public String visit(Expression expression);

	public String visit(Condition condition);

	public String visit(OrderByColumns orderByColumns);

}
