package com.whl.cloud.microservicesimplecconsumermovie.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * UserClientConfig
 * TODO:
 * 2018/4/412:05
 * 1.0
 * hlwu
 */
@Configuration
public class UserClientConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.HEADERS;
    }
}
