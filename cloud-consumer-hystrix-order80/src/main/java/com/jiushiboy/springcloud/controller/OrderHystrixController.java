package com.jiushiboy.springcloud.controller;

import com.jiushiboy.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author sh
 * @Date 2021/2/23 10:12
 */

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentGlobalFallBackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfo_OK(id);
        log.info(result);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")  //3秒钟以代表正常
//    })
    @HystrixCommand
    public String orderTimeOut(@PathVariable("id") Integer id){
        int x=10/0;
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        log.info(result);
        return result;
    }

    //兜底方法
    public String paxymentTimeOutFallbackMethod(@PathVariable("id") Integer id){
        return "我是消费者80，请10秒钟后再试或者自己运行出错请检查自己,(┬＿┬)";
    }

    //全局 兜底方法 Global fallback方法
    public String paymentGlobalFallBackMethod(){
        return "Global异常信息处理,请稍后再试!";
    }
}
