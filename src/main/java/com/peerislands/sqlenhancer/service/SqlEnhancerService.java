package com.peerislands.sqlenhancer.service;

import com.peerislands.sqlenhancer.dto.Select;

public interface SqlEnhancerService {

	public String getSqlString(Select input);

}
