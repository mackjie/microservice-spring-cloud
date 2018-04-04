package com.whl.cloud.microservicesimplecconsumermovie.controller;

import com.whl.cloud.microservicesimplecconsumermovie.entity.User;
import com.whl.cloud.microservicesimplecconsumermovie.service.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/* *
 * @author --吴豪磊--
 * @date 2018/4/2 17:37
 * @param
 * @return
 * TODO
 * @Description:
 */
@RestController
@RequestMapping("/user1")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private UserClient userClient;

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

    @GetMapping("/findUser")
    public List<User> findUser(){
        List<User> list = userClient.getallUser();
        return list;
    }

    @GetMapping("/getUser1")
    private User getUser1(Long userId){
        User user = userClient.getUser(userId);
        return user;
    }

    @PostMapping("/updateUser")
    public String updateUser(User user){
        return userClient.updateUser(user);
    }

    @GetMapping("/delUser")
    public String delUser(User user){
        return userClient.delUser(user.getUserId());
    }

}
