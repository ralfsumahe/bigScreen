package com.funo.vo.back;

import javax.validation.constraints.NotNull;

/**
 * 中心其他信息
 * 描述
 *
 * @author linkun
 * @created 2019年11月11日 下午6:52:50
 */
public class CenterOtherInfo {

    /**
     * 中心名称
     */
    private String centerName;
    /**
     * 微服务数
     */
    private Integer microserviceNum;
    /**
     * 容器数
     */
    private Integer containerNum;
    /**
     * 虚机数
     */
    private Integer visualmachineNum;

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public Integer getMicroserviceNum() {
        return microserviceNum;
    }

    public void setMicroserviceNum(Integer microserviceNum) {
        this.microserviceNum = microserviceNum;
    }

    public Integer getContainerNum() {
        return containerNum;
    }

    public void setContainerNum(Integer containerNum) {
        this.containerNum = containerNum;
    }

    public Integer getVisualmachineNum() {
        return visualmachineNum;
    }

    public void setVisualmachineNum(Integer visualmachineNum) {
        this.visualmachineNum = visualmachineNum;
    }

    public CenterOtherInfo() {
    }

    public CenterOtherInfo(String centerName, Integer microserviceNum, Integer containerNum, Integer visualmachineNum) {
        this.centerName = centerName;
        this.microserviceNum = microserviceNum;
        this.containerNum = containerNum;
        this.visualmachineNum = visualmachineNum;
    }

    public CenterOtherInfo addMicroserviceNum(@NotNull Integer microserviceNum) {
        this.microserviceNum = this.microserviceNum == null ? 0 : this.microserviceNum + microserviceNum;
        return this;
    }

    public CenterOtherInfo addContainerNum(@NotNull Integer containerNum) {
        this.containerNum = this.containerNum == null ? 0 : this.containerNum + containerNum;
        return this;
    }
}
