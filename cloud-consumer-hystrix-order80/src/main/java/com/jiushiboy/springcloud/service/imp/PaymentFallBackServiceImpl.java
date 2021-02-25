package com.jiushiboy.springcloud.service.imp;

import com.jiushiboy.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Author sh
 * @Date 2021/2/23 17:39
 */

@Component
public class PaymentFallBackServiceImpl implements PaymentHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "---------PaymentFallBackServiceImpl fall back paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "---------PaymentFallBackServiceImpl fall back paymentInfo_TimeOut";
    }
}
