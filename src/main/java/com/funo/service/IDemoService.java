package com.funo.service;


import com.funo.vo.AlertInfo;
import com.funo.vo.BaseYBP;

public interface IDemoService {

    /**
     * 从redis获取仪表盘数据并组装
     * 描述
     *
     * @param redisKey
     * @return
     * @author linkun
     * @created 2019年9月27日 下午3:14:24
     */
    public BaseYBP ybp(String redisKey);

    /**
     * 从redis获取告警数据并组装
     * 描述
     *
     * @return
     * @author linkun
     * @created 2019年9月27日 下午3:15:06
     */
    public AlertInfo getAlertInfo();

    /**
     * 参数配置接口
     * 是否启用基线
     * 描述
     *
     * @param configKey
     * @param configValue
     * @author linkun
     * @created 2019年9月27日 下午3:15:44
     */
    public void config(String configKey, String configValue);
}
