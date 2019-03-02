package com.luo.demo_euraka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 表示Euraka server客户端
 */
@SpringBootApplication
@EnableEurekaServer
public class DemoEurakaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoEurakaApplication.class, args);
    }

}

