package com.whl.cloud.microservicesimplecconsumermovie.controller;

import com.whl.cloud.microservicesimplecconsumermovie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/allUser")
    private List<User> getAllUser(){
        ResponseEntity<List<User>> responseEntity = restTemplate.exchange("http://microservice-privider-user/user/getallUser?", HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {});
        return responseEntity.getBody();
    }

    @GetMapping("/getUser")
    private User getUser(){
        User user = restTemplate.getForObject("http://microservice-privider-user/user/getUser?userId=2",User.class);
        return user;
    }

}
