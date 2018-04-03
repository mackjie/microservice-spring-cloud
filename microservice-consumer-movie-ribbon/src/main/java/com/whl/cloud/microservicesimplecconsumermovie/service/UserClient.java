package com.whl.cloud.microservicesimplecconsumermovie.service;

import com.whl.cloud.microservicesimplecconsumermovie.entity.User;
import com.whl.cloud.microservicesimplecconsumermovie.hystrix.UserRemoteHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* *   
 * @author --吴豪磊--
 * @date 2018/4/2 16:42
 * 用户微服务请求设置
 * FeignClient("name") name:注册服务名称
 * fallback: 操作异常执行方法不能查看错误原因
 * name:请求Eureka中注册的服务名称
 *  fallbackFactory：可以获取操作异常原因
 */
@FeignClient(name="microservice-privider-user",fallbackFactory = UserRemoteHystrix.class )
public interface UserClient {

    /* *   
     * @author --吴豪磊--
     * @date 2018/4/2 16:42
     * @param []  
     * @return java.util.List<com.whl.cloud.microservicesimplecconsumermovie.entity.User>
     */
    @GetMapping(value = "/user/getallUser")
    List<User> getallUser();

    /* *
     * @author --吴豪磊--
     * @date 2018/4/2 16:46
     * @param [userId]  
     * @return com.whl.cloud.microservicesimplecconsumermovie.entity.User  
     * TODO
     * @Description:
     */
    @GetMapping(value = "/user/getUser",consumes = "application/json")
    User getUser(@RequestParam("userId") Long userId);

    /* *
     * @author --吴豪磊--
     * @date  17:05
     * @param [User]  
     * @return java.lang.String  
     * TODO
     * @Description: consumes：指定请求提交内容类型
     */
    @PostMapping(value = "/user/addUser",consumes = "application/json")
    String updateUser(@RequestBody User User);

    /* *
     * @author --吴豪磊--
     * @date 2018/4/3 17:09  
     * @param [userId]  
     * @return java.lang.String  
     * TODO
     * @Description: 删除用户
     */
    @GetMapping(value = "/user/delUser")
    String delUser(@RequestParam("userId") Long userId);

    /* *
     * @author --吴豪磊--
     * @date 2018/4/3 17:09
     * @param [user]
     * @return com.whl.cloud.microservicesimplecconsumermovie.entity.User
     * TODO
     * @Description:添加用户
     */
    @PostMapping(value = "/user/addUser",consumes="application/json")
    String addUser(@RequestBody User user);
}