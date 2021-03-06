package com.zwh;

import io.prometheus.client.spring.boot.EnableSpringBootMetricsCollector;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableFeignClients
@EnableHystrix
@EnableSpringBootMetricsCollector
@EnableEurekaClient
//@MapperScan("com.zwh.mapper")
public class UcenterApplication {


    public static void main(String[] args) {
        SpringApplication.run(UcenterApplication.class, args);
    }
}
