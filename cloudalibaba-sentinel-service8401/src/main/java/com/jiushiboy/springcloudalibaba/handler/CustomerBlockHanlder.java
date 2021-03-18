package com.jiushiboy.springcloudalibaba.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.jiushiboy.springcloud.entities.CommonResult;

/**
 * @Author sh
 * @Date 2021/3/15 17:54
 */
public class CustomerBlockHanlder {

    public static CommonResult handlerException(BlockException exception){
        return new CommonResult(6666,"用户自定义Global HandlerException----1");
    }

    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(6666,"用户自定义Global HandlerException----2");
    }
}
