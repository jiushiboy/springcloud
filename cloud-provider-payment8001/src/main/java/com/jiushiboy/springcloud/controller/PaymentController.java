package com.jiushiboy.springcloud.controller;

import com.jiushiboy.springcloud.entities.CommonResult;
import com.jiushiboy.springcloud.entities.Payment;
import com.jiushiboy.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author sh
 * @Date 2021/1/20 15:05
 */

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment){
        int result = paymentService.create(payment);
        log.info("-------插入结果:"+result);
        if (result>0){
            return new CommonResult(200,"添加数据成功!",result);
        }else{
            return new CommonResult(444,"添加数据失败!",null);
        }

    }


    @GetMapping(value = "/payment/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("-------根据id查询单条数据:"+payment);
        if (null!=payment){
            return new CommonResult(200,"查询数据成功!",payment);
        }else{
            return new CommonResult(444,"指定查询记录不存在,查询ID:"+id,null);
        }

    }


    @GetMapping(value = "/payment/getAll")
    public CommonResult getAll(){
        List<Payment> paymentList = paymentService.getAll();
        log.info("-------根据查询全部数据:"+paymentList);
        if (null!=paymentList){
            return new CommonResult(200,"查询数据成功!",paymentList);
        }else{
            return new CommonResult(444,"没有任何记录",null);
        }

    }

}
