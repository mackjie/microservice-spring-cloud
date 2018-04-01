package com.whl.cloud.microservicesimpleconsumereureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroserviceCommonEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceCommonEurekaApplication.class, args);
	}
}
