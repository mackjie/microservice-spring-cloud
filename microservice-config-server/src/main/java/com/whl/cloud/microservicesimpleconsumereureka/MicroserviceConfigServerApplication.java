package com.whl.cloud.microservicesimpleconsumereureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient        //启用eureka客户端
@EnableConfigServer
public class MicroserviceConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceConfigServerApplication.class, args);
	}
}
