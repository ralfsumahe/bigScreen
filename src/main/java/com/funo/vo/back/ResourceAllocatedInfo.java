package com.funo.vo.back;

/**
 * 资源分配率
 * 描述
 * @author linkun
 * @created 2019年11月5日 上午11:36:39
 */
public class ResourceAllocatedInfo {

	/**
	 * cpu分配率(%)
	 */
	private Number cpu;
	/**
	 * 内存分配率(%)
	 */
	private Number memery;
	/**
	 * 硬盘分配率(%)
	 */
	private Number disk;
	public Number getCpu() {
		return cpu;
	}
	public void setCpu(Number cpu) {
		this.cpu = cpu;
	}
	public Number getMemery() {
		return memery;
	}
	public void setMemery(Number memery) {
		this.memery = memery;
	}
	public Number getDisk() {
		return disk;
	}
	public void setDisk(Number disk) {
		this.disk = disk;
	}
	
	
}
