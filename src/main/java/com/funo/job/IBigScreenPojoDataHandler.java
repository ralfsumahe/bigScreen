package com.funo.job;

import java.util.Date;
import java.util.List;

public interface IBigScreenPojoDataHandler {
	public static final Integer SIZE = 50;

	/**
	 * 根据时间获取描点的key
	 * 描述
	 * @author linkun
	 * @created 2019年9月23日 下午3:08:45
	 * @return
	 */
	public String getValueKey(Date now);
	/**
	 * 将某个时间的数据存入redis的列表数据
	 * 描述
	 * @author linkun
	 * @created 2019年9月16日 上午10:56:19
	 * @return
	 */
	public Boolean setDatas(String redisKey, Object data, Date time);
	/**
	 * 将多个时间的数据存入redis的列表数据
	 * 描述
	 * @author linkun
	 * @created 2019年9月16日 上午10:56:19
	 * @return
	 */
	public Boolean setDatas(String redisKey, List<InterfacePojoDataInfo> datas);
	/**
	 * 将最新的值存入redis的当前数据
	 * 描述
	 * @author linkun
	 * @created 2019年9月16日 上午11:30:17
	 * @param redisKey
	 * @param data
	 * @return
	 */
	public Boolean setData(String redisModuleKey, Object data);
	/**
	 * 将最新的值存入redis的当前数据
	 * 描述
	 * @author linkun
	 * @created 2019年9月23日 下午3:36:16
	 * @param redisModuleKey
	 * @param datas
	 */
	public Boolean setData(String redisKey, List<InterfacePojoDataInfo> datas);
}
