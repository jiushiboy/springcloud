package com.jiushiboy.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Author sh
 * @Date 2021/2/22 17:23
 */

@Service
public class PaymentService {


    //服务降级 fallback

    public String paymentInfo_OK(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + "____paymentInfo_OK,id:" + id;
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")  //1秒钟以代表正常
    })
    public String paymentInfo_Timeout(Integer id) {
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "线程池:" + Thread.currentThread().getName() + "___paymentInfo_Timeout,id:" + id;
    }

    //兜底方法
    public String paymentInfo_TimeoutHandler(Integer id) {

        return "线程池:" + Thread.currentThread().getName() + "paymentInfo_TimeoutHandler,----系统繁忙-----,id:" + id + "\t" + "┭┮﹏┭┮";

    }


    //服务熔断 break --------------------------------------------------------------------

    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),   //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id < 0){
            throw new RuntimeException("*****id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功,流水号："+serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能负数，请稍候再试,(┬＿┬)/~~     id: " +id;
    }




}
