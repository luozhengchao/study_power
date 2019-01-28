package com.luo.demo_eureka_user2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DemoEurekaUser2Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoEurekaUser2Application.class, args);
	}

}

