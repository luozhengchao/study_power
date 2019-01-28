package com.luo.demo_eureka_consumer_feign;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 启动类
 */
@SpringCloudApplication
@EnableFeignClients
public class DemoEurekaConsumerFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoEurekaConsumerFeignApplication.class, args);
	}

}
