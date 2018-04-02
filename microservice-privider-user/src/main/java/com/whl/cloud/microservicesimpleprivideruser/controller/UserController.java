package com.whl.cloud.microservicesimpleprivideruser.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.whl.cloud.microservicesimpleprivideruser.entity.User;
import com.whl.cloud.microservicesimpleprivideruser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.*;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import javax.annotation.Resource;
import java.util.List;

    @RestController
    @RequestMapping("/user")
    public class UserController {

        @Resource
        private UserRepository userRepository;

        @Autowired
        private DiscoveryClient eurekaDiscoveryClient;

        @Qualifier("eurekaClient")
        @Autowired
        private EurekaClient eurekaClient;

        @GetMapping("/getallUser")
        public List<User> getUserPage(){
            return userRepository.findAll();
        }

        @GetMapping("/getUser")
        public User getUser(User user){
            return userRepository.getOne(user.getUserId());
    }

        @GetMapping("/eureka-instance")
        public String serviceUrl() {
            InstanceInfo instance = eurekaClient.getNextServerFromEureka("MICROSERVICE-PRIVIDER-USER", false);
            return instance.getHomePageUrl();
        }

        @GetMapping("/eureka-info")
        public ServiceInstance serviceInfo(){
            return eurekaDiscoveryClient.getLocalServiceInstance();
        }
}
