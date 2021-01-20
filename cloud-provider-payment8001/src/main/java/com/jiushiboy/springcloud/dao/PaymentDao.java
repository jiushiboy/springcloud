package com.jiushiboy.springcloud.dao;

import com.jiushiboy.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author sh
 * @Date 2021/1/20 10:37
 */

@Mapper
public interface PaymentDao {

    /**
     * 查询多条数据
     * @return
     */
    @Select("select * from payment")
    public List<Payment> getAll();


    /**
     * 添加单条数据
     * @param payment
     * @return
     */
    public int create(Payment payment);


    /**
     * 单条数据查询
     * @param id  主键
     * @return 返回结果
     */
    public Payment getPaymentById(@Param("id") Long id);

}
