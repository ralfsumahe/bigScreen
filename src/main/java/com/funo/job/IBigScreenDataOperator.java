package com.funo.job;

import java.util.Date;

public interface IBigScreenDataOperator {

	public void operate(Date now, String redisModuleKey);
}
