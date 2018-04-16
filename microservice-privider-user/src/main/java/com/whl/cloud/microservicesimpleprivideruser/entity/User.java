package com.whl.cloud.microservicesimpleprivideruser.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name="TM_USER")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class User implements Serializable, Cloneable,InitializingBean,DisposableBean{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Long userId;

    /**
     * 登录名
     */
    @Column(name = "USER_NAME")
    private String userName;

    /**
     * 用户名
     */
    @Column(name="PASSWORD")
    private String name;

    /**
     * 薪水
     */
    @Column(name="SALARY")
    private BigDecimal balance;

    /**
     * 年龄
     */
    @Transient
    private int age;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void destroy() throws Exception {

    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
