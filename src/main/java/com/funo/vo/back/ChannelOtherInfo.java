package com.funo.vo.back;

/**
 * 通道其他信息
 * 描述
 *
 * @author linkun
 * @created 2019年11月11日 下午6:52:26
 */
public class ChannelOtherInfo {

    /**
     * 通道名称
     */
    private String name;
    /**
     * 当前容器数
     */
    private Integer currentContainerNum;
    /**
     * 初始化容器数(个)
     */
    private Integer initContainerNum;
    /**
     * 失败容器数(个)
     */
    private Integer errorContainerNum;
    /**
     * cpu(%)
     */
    private Double cpu;
    /**
     * 内存(%)
     */
    private Double memery;

    public ChannelOtherInfo() {
    }

    public ChannelOtherInfo(String name, Integer currentContainerNum, Double cpu, Double memery) {
		this.name = name;
		this.currentContainerNum = currentContainerNum;
		this.cpu = cpu;
		this.memery = memery;
	}

	public Integer getCurrentContainerNum() {
        return currentContainerNum;
    }

    public void setCurrentContainerNum(Integer currentContainerNum) {
        this.currentContainerNum = currentContainerNum;
    }

    public Integer getInitContainerNum() {
        return initContainerNum;
    }

    public void setInitContainerNum(Integer initContainerNum) {
        this.initContainerNum = initContainerNum;
    }

    public Integer getErrorContainerNum() {
        return errorContainerNum;
    }

    public void setErrorContainerNum(Integer errorContainerNum) {
        this.errorContainerNum = errorContainerNum;
    }

    public Double getCpu() {
        return cpu;
    }

    public void setCpu(Double cpu) {
        this.cpu = cpu;
    }

    public Double getMemery() {
        return memery;
    }

    public void setMemery(Double memery) {
        this.memery = memery;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
