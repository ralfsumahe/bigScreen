package com.funo.constant;

public interface DemoContants {

	/**
	 * 资源分配率：CPU，磁盘，内存
	 */
	public final String REDIS_KEY_RESOURCE_ALLOCATION_RATE="resource_allocation_rate";

	/**
	 * 物理机，虚拟机数量
	 */
	public final  String REDIS_KEY__VISUAL_MACHINE_ALOCAT="visual_machine_alocat";

	/**
	 * 节点健康度
	 */
	public final String REDIS_KEY_NODESHEALTH = "nodesHealth";
	/**
	 * 容器健康度
	 */
	public final String REDIS_KEY_CONTAINERSHEALTH = "containersHealth";
	/**
	 * 微服务健康度
	 */
	String REDIS_KEY_MICRO_SERIVCES_HEALTH = "micro_services_health";
	/**
	 * 渠道处理量
	 */
	public final String REDIS_KEY_APPSSTATICS = "appsStatics";
	
	/**
	 * cpu平均使用率仪表盘
	 */
	public final String REDIS_KEY_YBP_AVGCPU = "ybp_avg_cpu";
	/**
	 * cpu平均使用率折线图
	 */
	public final String REDIS_KEY_ZXT_AVGCPU = "zxt_avg_cpu";
	/**
	 * cpu使用率分布柱状图
	 */
	public final String REDIS_KEY_ZZT_AVGCPU = "zzt_avg_cpu";
	
	/**
	 * 硬盘平均使用率仪表盘
	 */
	public final String REDIS_KEY_YBP_AVGDISK = "ybp_avg_disk";
	/**
	 * 硬盘平均使用率折线图
	 */
	public final String REDIS_KEY_ZXT_AVGDISK = "zxt_avg_disk";
	/**
	 * 硬盘使用率分布柱状图
	 */
	public final String REDIS_KEY_ZZT_AVGDISK = "zzt_avg_disk";
	
	/**
	 * 内存平均使用率仪表盘
	 */
	public final String REDIS_KEY_YBP_AVGMEMORY = "ybp_avg_memory";
	/**
	 * 内存平均使用率折线图
	 */
	public final String REDIS_KEY_ZXT_AVGMEMORY = "zxt_avg_memory";
	/**
	 * 内存使用率分布柱状图
	 */
	public final String REDIS_KEY_ZZT_AVGMEMORY = "zzt_avg_memory";
	
	/**
	 * 虚拟内存平均使用率仪表盘
	 */
	public final String REDIS_KEY_YBP_AVGVISUALMEMORY = "ybp_avg_visual_memory";
	/**
	 * 虚拟内存平均使用率折线图
	 */
	public final String REDIS_KEY_ZXT_AVGVISUALMEMORY = "zxt_avg_visual_memory";
	/**
	 * 虚拟内存使用率分布柱状图
	 */
	public final String REDIS_KEY_ZZT_AVGVISUALMEMORY = "zzt_avg_visual_memory";
	
	/**
	 * 系统吞吐量折线图
	 */
	public final String REDIS_KEY_ZXT_SLA_ALL_REQ = "zxt_sla_all_req";
	/**
	 * 用户中心吞吐量折线图
	 */
	public final String REDIS_KEY_ZXT_SLA_USER_REQ = "zxt_sla_user_req";
	/**
	 * 产商品中心吞吐量折线图
	 */
	public final String REDIS_KEY_ZXT_SLA_PRODUCE_REQ = "zxt_sla_produce_req";
	/**
	 * 互联网中心吞吐量折线图
	 */
	public final String REDIS_KEY_ZXT_SLA_INTEL_REQ = "zxt_sla_intel_req";
	
	/**
	 * 系统成功率折线图
	 */
	public final String REDIS_KEY_ZXT_SLA_ALL_SUCCESS = "zxt_sla_all_success";
	/**
	 * 用户中心成功率折线图
	 */
	public final String REDIS_KEY_ZXT_SLA_USER_SUCCESS = "zxt_sla_user_success";
	/**
	 * 产商品中心成功率折线图
	 */
	public final String REDIS_KEY_ZXT_SLA_PRODUCE_SUCCESS = "zxt_sla_produce_success";
	/**
	 * 互联网中心成功率折线图
	 */
	public final String REDIS_KEY_ZXT_SLA_INTEL_SUCCESS = "zxt_sla_intel_success";
	
	/**
	 * 系统平均响应时长折线图
	 */
	public final String REDIS_KEY_ZXT_SLA_ALL_AVGRESPONTIME = "zxt_sla_all_avgrespontime";
	/**
	 * 用户中心平均响应时长折线图
	 */
	public final String REDIS_KEY_ZXT_SLA_USER_RESPONTIME = "zxt_sla_user_respontime";
	/**
	 * 产商品中心平均响应时长折线图
	 */
	public final String REDIS_KEY_ZXT_SLA_PRODUCE_RESPONTIME = "zxt_sla_produce_respontime";
	/**
	 * 互联网中心平均响应时长折线图
	 */
	public final String REDIS_KEY_ZXT_SLA_INTEL_RESPONTIME = "zxt_sla_intel_respontime";
	
	/**
	 * 系统最大响应时长折线图
	 */
	public final String REDIS_KEY_ZXT_SLA_ALL_MAXRESPONTIME = "zxt_sla_all_maxrespontime";
	
	/**
	 * 告警信息
	 */
	public final String REDIS_KEY_ALERTINFO = "alertinfo";

	public final String REDIS_KEY_ZXT_SLA = "zxt_sla";

	public final String REDIS_KEY_ZXT_SLA_ALL_REQ_BASE = "zxt_sla_all_req_base";
	public final String REDIS_KEY_ZXT_SLA_ALL_SUCCESS_BASE = "zxt_sla_all_success_base";
	public final String REDIS_KEY_ZXT_SLA_ALL_AVGRESPONTIME_BASE = "zxt_sla_all_avgrespontime_base";
	public final String REDIS_KEY_ZXT_SLA_ALL_MAXRESPONTIME_BASE = "zxt_sla_all_maxrespontime_base";

	public final String REDIS_KEY_ZXT_SLA_USER_REQ_BASE = "zxt_sla_user_req_base";
	public final String REDIS_KEY_ZXT_SLA_USER_SUCCESS_BASE = "zxt_sla_user_success_base";
	public final String REDIS_KEY_ZXT_SLA_USER_AVGRESPONTIME_BASE = "zxt_sla_user_avgrespontime_base";
	public final String REDIS_KEY_ZXT_SLA_USER_MAXRESPONTIME_BASE = "zxt_sla_user_maxrespontime_base";

	public final String REDIS_KEY_ZXT_SLA_PRODUCE_REQ_BASE = "zxt_sla_produce_req_base";
	public final String REDIS_KEY_ZXT_SLA_PRODUCE_SUCCESS_BASE = "zxt_sla_produce_success_base";
	public final String REDIS_KEY_ZXT_SLA_PRODUCE_AVGRESPONTIME_BASE = "zxt_sla_produce_avgrespontime_base";
	public final String REDIS_KEY_ZXT_SLA_PRODUCE_MAXRESPONTIME_BASE = "zxt_sla_produce_maxrespontime_base";

	public final String REDIS_KEY_ZXT_SLA_INTEL_REQ_BASE = "zxt_sla_intel_req_base";
	public final String REDIS_KEY_ZXT_SLA_INTEL_SUCCESS_BASE = "zxt_sla_intel_success_base";
	public final String REDIS_KEY_ZXT_SLA_INTEL_AVGRESPONTIME_BASE = "zxt_sla_intel_avgrespontime_base";
	public final String REDIS_KEY_ZXT_SLA_INTEL_MAXRESPONTIME_BASE = "zxt_sla_intel_maxrespontime_base";

	// 系统总吞吐量/成功率/平均时延
	String REDIS_KEY_SYS_PERFORMANCE_TOTAL = "sys_performance_total";
}
