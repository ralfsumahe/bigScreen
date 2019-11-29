package com.funo.vo.front;
/**
 * 虚拟机分配情况
 * 描述
 * @author linkun
 * @created 2019年11月5日 下午2:49:00
 */
public class FrontVisualmachineAlocatInfo {

	/**
	 * 分区
	 */
	private String partition;
	/**
	 * 集群
	 */
	private String cluster;
	/**
	 * 物理机数量
	 */
	private Number machineNum;
	/**
	 * 虚拟机数量
	 */
	private Number visualNum;
	public String getPartition() {
		return partition;
	}
	public void setPartition(String partition) {
		this.partition = partition;
	}
	public String getCluster() {
		return cluster;
	}
	public void setCluster(String cluster) {
		this.cluster = cluster;
	}
	public Number getMachineNum() {
		return machineNum;
	}
	public void setMachineNum(Number machineNum) {
		this.machineNum = machineNum;
	}
	public Number getVisualNum() {
		return visualNum;
	}
	public void setVisualNum(Number visualNum) {
		this.visualNum = visualNum;
	}
	
	
}
