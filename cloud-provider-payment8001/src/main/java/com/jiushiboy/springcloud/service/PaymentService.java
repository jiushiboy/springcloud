package com.jiushiboy.springcloud.service;

import com.jiushiboy.springcloud.entities.Payment;

import java.util.List;

/**
 * @Author sh
 * @Date 2021/1/20 11:30
 */
@SuppressWarnings({"ALL", "AlibabaAbstractMethodOrInterfaceMethodMustUseJavadoc"})
public interface PaymentService {
    @SuppressWarnings("AlibabaAbstractMethodOrInterfaceMethodMustUseJavadoc")
    public int create(Payment payment);
    public Payment getPaymentById(Long id);
    public List<Payment> getAll();
}
