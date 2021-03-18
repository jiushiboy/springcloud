package com.jiushiboy.springcloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.jiushiboy.springcloud.entities.CommonResult;
import com.jiushiboy.springcloud.entities.Payment;
import com.jiushiboy.springcloudalibaba.handler.CustomerBlockHanlder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author sh
 * @Date 2021/3/15 17:31
 */
@RestController
@Slf4j
public class RateLimitController {
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult byResource(){
        return new CommonResult(200,"按资源名限流测试~~~",new Payment(2021L,"serial1450495810"));
    }
    public CommonResult handleException(BlockException exception){
        return new CommonResult(500,exception.getClass().getCanonicalName()+"服务不可用,请稍后重试~");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl(){
        return new CommonResult(200,"按Url限流测试~~~",new Payment(2021L,"serial九世"));
    }

    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler"
            ,blockHandlerClass = CustomerBlockHanlder.class,blockHandler = "handlerException2")
    public CommonResult customerBlockHandler(){
        return new CommonResult(200,"自定义限流测试~~~",new Payment(2021L,"serial九世"));
    }

}
