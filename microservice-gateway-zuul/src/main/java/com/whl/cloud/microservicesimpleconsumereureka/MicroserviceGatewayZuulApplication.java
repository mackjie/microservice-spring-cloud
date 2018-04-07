package com.whl.cloud.microservicesimpleconsumereureka;

import com.whl.cloud.microservicesimpleconsumereureka.zuulfilter.QueryParamPreFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy        //启用嵌入式Zuul反向代理
public class MicroserviceGatewayZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceGatewayZuulApplication.class, args);
	}

	@Bean
	public QueryParamPreFilter getQueryPreFilter(){
		return new QueryParamPreFilter();
	}
}
