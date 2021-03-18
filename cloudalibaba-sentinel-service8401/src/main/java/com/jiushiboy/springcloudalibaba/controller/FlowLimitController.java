package com.jiushiboy.springcloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author sh
 * @Date 2021/3/9 9:51
 */
@RestController
@Slf4j
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() {
        return "-------TestA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "-------TestB";
    }

    @GetMapping("/testD")
    public String testD(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testD测试");
        return "-------TestD";
    }

    @GetMapping("/testE")
    public String testE(){
        int age=10/0;
        log.info("testE测试 异常比例");
        return "-------TestE";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false)String p1
            ,@RequestParam(value = "p2",required = false)String p2){
        return "-------testHotKey";
    }

    public String deal_testHotKey(String p1, String p2, BlockException exception){
        return "_______deal_testHotKey";//sentinel系统默认提示: Blocked by Sentinel(flow limit)
    }

}
