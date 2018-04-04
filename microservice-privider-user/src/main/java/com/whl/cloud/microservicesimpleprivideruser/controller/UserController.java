package com.whl.cloud.microservicesimpleprivideruser.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.whl.cloud.microservicesimpleprivideruser.entity.User;
import com.whl.cloud.microservicesimpleprivideruser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import javax.annotation.Resource;
import java.util.List;

    @RestController
    @RequestMapping("/user")
    @RefreshScope
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
        public User getUser(Long userId){
            return userRepository.getOne(userId);
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

        /* *
         * @author --吴豪磊--
         * @date 2018/4/4 15:42  
         * @param [user]  
         * @return java.lang.String  
         * TODO
         * @Description: 使用feign方式进行请求处理操作
         */
        @PostMapping("/addUser")
        public String addUserFeign(@RequestBody User user){
            userRepository.save(user);
            return "保存成功";
        }

        /* *
         * @author --吴豪磊--
         * @date 2018/4/4 15:41
         * @param [user]  
         * @return java.lang.String  
         * TODO
         * @Description: 使用路由方式进行请求处理
         */
        @PostMapping("/addUserZuul")
        public String addUserZuul(User user){
            userRepository.save(user);
            return "保存成功";
        }
}
