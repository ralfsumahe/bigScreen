package com.funo.vo.back;

/**
 * 中心指标信息
 * 描述
 *
 * @author linkun
 * @created 2019年11月11日 下午6:52:37
 */
public class CenterBusinessInfo {

    /**
     * 吞吐量(次/分)
     */
    private Number req;
    /**
     * 成功率(%)
     */
    private Number success;
    /**
     * 平均时长(ms)
     */
    private Number avgrespontime;
    /**
     * 最大时长(ms)
     */
    private Number maxrespontime;

    public Number getReq() {
        return req;
    }

    public void setReq(Number req) {
        this.req = req;
    }

    public Number getSuccess() {
        return success;
    }

    public void setSuccess(Number success) {
        this.success = success;
    }

    public Number getAvgrespontime() {
        return avgrespontime;
    }

    public void setAvgrespontime(Number avgrespontime) {
        this.avgrespontime = avgrespontime;
    }

    public Number getMaxrespontime() {
        return maxrespontime;
    }

    public void setMaxrespontime(Number maxrespontime) {
        this.maxrespontime = maxrespontime;
    }

    public CenterBusinessInfo() {
    }

    public CenterBusinessInfo(Number req, Number success, Number avgrespontime) {
        this.req = req;
        this.success = success;
        this.avgrespontime = avgrespontime;
    }
}
