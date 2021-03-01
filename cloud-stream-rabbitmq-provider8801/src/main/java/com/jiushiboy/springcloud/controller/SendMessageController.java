package com.jiushiboy.springcloud.controller;

import com.jiushiboy.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author sh
 * @Date 2021/3/1 15:36
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("/sendMessage")
    public String sendMassage(){
        return messageProvider.send();
    }

}
