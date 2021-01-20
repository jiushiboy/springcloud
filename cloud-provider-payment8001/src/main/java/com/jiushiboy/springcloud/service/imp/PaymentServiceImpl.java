package com.jiushiboy.springcloud.service.imp;

import com.jiushiboy.springcloud.dao.PaymentDao;
import com.jiushiboy.springcloud.entities.Payment;
import com.jiushiboy.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author sh
 * @Date 2021/1/20 11:31
 */

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }

    @Override
    public List<Payment> getAll() {
        return paymentDao.getAll();
    }

}
