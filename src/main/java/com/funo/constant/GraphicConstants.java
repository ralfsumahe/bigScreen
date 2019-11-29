package com.funo.constant;

/**
 * 图形参数
 * 对应
 * 1.仪表盘title(当前没有显示)
 * 2.折线图
 *   1）title(当前没有显示)
 *   2）图例名称
 *   3）横轴名称
 *   4)纵轴名称
 * 3.柱状图(资源分布)
 *   1)title(当前没有显示)
 *   2)图例名称
 *   3)横轴名称
 *   4)纵轴名称
 * 描述
 * @author linkun
 * @created 2019年9月3日 下午2:48:48
 */
public interface GraphicConstants {
	//cpu仪表盘只要title
	public static final String YBP_CPU_AVG_TITLE="cpu占用率";
	//磁盘仪表盘
	public static final String YBP_DISK_AVG_TITLE="硬盘占用率";
	//内存仪表盘
	public static final String YBP_MEM_AVG_TITLE="内存占用率";
	//虚拟内存仪表盘
	public static final String YBP_VIRMEM_AVG_TITLE="虚拟内存占用率";

	//cpu折线图title
	public static final String ZXT_CPU_AVG_TITLE = "cpu占用率";
	//磁盘折线图title
	public static final String ZXT_DISK_AVG_TITLE = "硬盘占用率";
	//内存折线图title
	public static final String ZXT_MEM_AVG_TITLE = "内存占用率";
	//虚拟内存折线图title
	public static final String ZXT_VIRMEM_AVG_TITLE = "虚拟内存占用率";

	//cpu折线图图例名称
	public static final String ZXT_CPU_AVG_DATATITLE = "cpu占用率";
	//硬盘折线图图例名称
	public static final String ZXT_DISK_AVG_DATATITLE = "硬盘占用率";
	//内存折线图图例名称
	public static final String ZXT_MEM_AVG_DATATITLE = "内存占用率";
	//虚拟内存折线图图例名称
	public static final String ZXT_VIRMEM_AVG_DATATITLE = "虚拟内存占用率";
		
	//cpu折线图横轴名称
	public static final String ZXT_RESOURCE_XTITLE = "时间";
	//cpu折线图纵轴名称
	public static final String ZXT_RESOURCE_YTITLE = "占用率(%)";
	
	
	
	//cpu柱状图title
	public static final String ZZT_CPU_AVG_TITLE = "cpu占用率";
	//cpu柱状图图例名称
	public static final String ZZT_CPU_AVG_DATATITLE = "cpu占用率分布";

	//磁盘柱状图title
	public static final String ZZT_DISK_AVG_TITLE = "磁盘占用率";
	//磁盘柱状图图例名称
	public static final String ZZT_DISK_AVG_DATATITLE = "磁盘占用率分布";
	//内存柱状图title
	public static final String ZZT_MEM_AVG_TITLE = "内存占用率";
	//内存柱状图图例名称
	public static final String ZZT_MEM_AVG_DATATITLE = "内存占用率分布";
	//虚拟内存柱状图title
	public static final String ZZT_VIRMEM_AVG_TITLE = "虚拟内存占用率";
	//虚拟内存柱状图图例名称
	public static final String ZZT_VIRMEM_AVG_DATATITLE = "虚拟内存占用率分布";
	
	//柱状图横轴名称
	public static final String ZZT_RESOURCE_XTITLE = "占用";
	//柱状图纵轴名称
	public static final String ZZT_RESOURCE_YTITLE = "分布(台)";
	

	//YBP 节点健康度
	public static final String YBP_NODE_HELTH = "节点健康度";
	//YBP 容器健康度
	public static final String YBP_CONRAIN_HELTH = "容器健康度";
	// YBP 微服务健康度
	String YBP_MICROSERVIERS_HEALTH = "微服务健康度";
	
}
