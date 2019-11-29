package com.funo.vo.back;

import lombok.NonNull;

/**
 * 微服务其他信息
 * 描述
 *
 * @author linkun
 * @created 2019年11月11日 下午6:52:26
 */
public class MicroserviceOtherInfo {

    /**
     * 微服务名称
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
     * 最大容器数(个)
     */
    private Integer maxContainerNum;
    /**
     * cpu(%)
     */
    private Double cpu;
    /**
     * 内存(%)
     */
    private Double memery;

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

    public Integer getMaxContainerNum() {
		return maxContainerNum;
	}

	public void setMaxContainerNum(Integer maxContainerNum) {
		this.maxContainerNum = maxContainerNum;
	}

	public MicroserviceOtherInfo() {
    }

    public MicroserviceOtherInfo(String name, Integer currentContainerNum, Integer initContainerNum, Integer errorContainerNum, Integer maxContainerNum) {
        this.name = name;
        this.currentContainerNum = currentContainerNum;
        this.initContainerNum = initContainerNum;
        this.errorContainerNum = errorContainerNum;
        this.maxContainerNum = maxContainerNum;
    }

    public MicroserviceOtherInfo(String microserviceName, Integer currentContainerNum, Integer initContainerNum, Integer errorContainerNum, Double cpu, Double memery) {
        this.name = microserviceName;
        this.currentContainerNum = currentContainerNum;
        this.initContainerNum = initContainerNum;
        this.errorContainerNum = errorContainerNum;
        this.cpu = cpu;
        this.memery = memery;
    }

    public MicroserviceOtherInfo addCurrentContainerNum(@NonNull Integer currentContainerNum) {
        this.currentContainerNum = (this.currentContainerNum == null ? 0 : this.currentContainerNum) + currentContainerNum;
        return this;
    }

    public MicroserviceOtherInfo addErrorContainerNum(@NonNull Integer errorContainerNum) {
        this.errorContainerNum = (this.errorContainerNum == null ? 0 : this.errorContainerNum) + errorContainerNum;
        return this;
    }
    
    public MicroserviceOtherInfo addMaxContainerNum(@NonNull Integer maxContainerNum) {
        this.maxContainerNum = (this.maxContainerNum == null ? 0 : this.maxContainerNum) + maxContainerNum;
        return this;
    }

    public MicroserviceOtherInfo addInitContainerNum(@NonNull Integer initContainerNum) {
        this.initContainerNum = (this.initContainerNum == null ? 0 : this.initContainerNum) + initContainerNum;
        return this;
    }
}
