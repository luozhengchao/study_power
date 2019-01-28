package com.luo.demo_eureka_user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DemoEurekaUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoEurekaUserApplication.class, args);
    }

}

