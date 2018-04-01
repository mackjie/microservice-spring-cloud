package com.whl.cloud.microservicesimplecconsumermovie.controller;

import com.whl.cloud.microservicesimplecconsumermovie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Value("${user.urlPath}")
    private String urlpath;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/allUser")
    private User getAllUser(){
       // ResponseEntity<List<User>> responseEntity = restTemplate.exchange(urlpath, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {});
        User user = restTemplate.getForObject(urlpath+"user/getUser?userId=2",User.class);
        return user;
    }



}
