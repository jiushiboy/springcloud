package com.jiushiboy.springcloud.controller;

import com.jiushiboy.springcloud.entities.CommonResult;
import com.jiushiboy.springcloud.entities.Payment;
import com.jiushiboy.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author sh
 * @Date 2021/2/22 14:43
 */

@RestController
@Slf4j
public class PaymentFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/comsumer/payment/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/comsumer/payment/feign/timeout")
    public String paymentFeignTimeOut(){
        //一般默认一秒钟就走完
        return paymentFeignService.paymentFeignTimeOut();
    }

}
