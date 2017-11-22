package com.zwh.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author zwh
 * @Description 服务发现
 * @date 2017/11/22
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer {


    public static  void main(String []args){

        SpringApplication.run(EurekaServer.class,args);
    }
}
