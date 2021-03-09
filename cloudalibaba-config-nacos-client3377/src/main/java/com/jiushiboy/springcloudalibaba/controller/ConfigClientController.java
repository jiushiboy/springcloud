package com.jiushiboy.springcloudalibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author sh
 * @Date 2021/3/4 14:57
 */
@RestController
@RefreshScope //支持Nacos的动态刷新功能;
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo(){
        return this.configInfo;
    }

}
