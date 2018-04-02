package com.whl.cloud.microservicesimplecconsumermovie.service;

import com.whl.cloud.microservicesimplecconsumermovie.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/* *   
 * @author --吴豪磊--
 * @date 2018/4/2 16:42
 * 用户微服务请求设置
 *FeignClient("name") name:注册服务名称
 */
@FeignClient("microservice-privider-user") // 请求Eureka中注册的服务名称
public interface UserClient {

    /* *   
     * @author --吴豪磊--
     * @date 2018/4/2 16:42
     * @param []  
     * @return java.util.List<com.whl.cloud.microservicesimplecconsumermovie.entity.User>
     */
    @GetMapping(value = "/user/getallUser")
    List<User> getUser();

    /* *
     * @author --吴豪磊--
     * @date 2018/4/2 16:46
     * @param [userId]  
     * @return com.whl.cloud.microservicesimplecconsumermovie.entity.User  
     * TODO
     * @Description:
     */
    @RequestMapping(method = RequestMethod.POST, value = "/user/getUser", consumes = "application/json")
    User update(@PathVariable("userId") Long userId);
}