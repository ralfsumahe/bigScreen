package com.funo.controller;

import com.funo.service.IDemoService;
import com.funo.vo.AlertInfo;
import com.funo.vo.BaseYBP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private IDemoService service;


    @RequestMapping("hello")
    public String hello() {
        return "hello";
    }

    /**
     * 根据redisKey获取仪表盘数据
     * 描述
     *
     * @param redisKey
     * @return
     * @author linkun
     * @created 2019年8月22日 下午9:40:48
     */
    @GetMapping("ybp/{redisKey}")
    public BaseYBP ybp(@PathVariable("redisKey") String redisKey) {
        return service.ybp(redisKey);
    }


    /**
     * 获取告警信息
     * 描述
     *
     * @return
     * @author linkun
     * @created 2019年8月20日 下午2:19:30
     */
    @GetMapping("getAlertInfo")
    public AlertInfo getAlertInfo() {
        return service.getAlertInfo();
    }

    /**
     * 配置修改
     * 描述
     *
     * @param configKey
     * @param configValue
     * @return
     * @author linkun
     * @created 2019年9月4日 下午3:22:47
     */
    @GetMapping("config/{configKey}/{configValue}")
    public String config(@PathVariable("configKey") String configKey, @PathVariable("configValue") String configValue) {
        service.config(configKey, configValue);
        return configKey + ":" + configValue;
    }


}
