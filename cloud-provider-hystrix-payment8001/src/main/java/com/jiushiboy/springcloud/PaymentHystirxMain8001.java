package com.jiushiboy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author sh
 * @Date 2021/2/22 17:22
 */

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class PaymentHystirxMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentHystirxMain8001.class, args);
    }

}
