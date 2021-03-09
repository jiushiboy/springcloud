package com.jiushiboy.springcloudalibaba.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author sh
 * @Date 2021/3/9 9:51
 */
@RestController
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() {
        return "-------TestA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "-------TestB";
    }
}
