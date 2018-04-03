package com.whl.cloud.microservicesimplecconsumermovie.hystrix;

import com.whl.cloud.microservicesimplecconsumermovie.entity.User;
import com.whl.cloud.microservicesimplecconsumermovie.service.UserClient;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * StoreIntegration
 * TODO:
 * 2018/4/316:52
 * 1.0
 * hlwu
 * 断路器集成，发生错误时候返回方法
 * 不能查看操作异常信息
 */
/*@Component
public class UserRemoteHystrix implements  UserClient {

    @Override
    public List<User> getallUser() {
        return null;
    }

    @Override
    public User getUser(Long userId) {
        return null;
    }

    @Override
    public String updateUser(User User) {
        return "修改异常";
    }

    @Override
    public String delUser(Long userId) {
        return "删除异常";
    }

    @Override
    public String addUser(User user) {
        return "删除异常";
    }
}*/
/* *
 * @author --吴豪磊--
 * @date 2018/4/3 19:46
 * @param   
 * @return   
 * TODO
 * @Description:通过FallbackFactory查看错误信息
 */
@Component
public class UserRemoteHystrix implements FallbackFactory<UserClient> {
    Logger logger = LoggerFactory.getLogger(UserRemoteHystrix.class);

    @Override
    public UserClient create(Throwable throwable) {
        return new UserClient() {
            @Override
            public List<User> getallUser() {
                return null;
            }

            @Override
            public User getUser(Long userId) {
                return null;
            }

            @Override
            public String updateUser(User User) {
                System.out.println("fallback; reason was:" + throwable);
                return null;
            }

            @Override
            public String delUser(Long userId) {
                return null;
            }

            @Override
            public String addUser(User user) {
                System.out.println("fallback; reason was:" + throwable);
                return null;
            }
        };
    }
}