package com.whl.cloud.microservicesimplecconsumermovie.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class User implements Serializable {

    private Long userId;

    /**
     * 登录名
     */
    private String userName;

    /**
     * 用户名
     */
    private String name;

    /**
     * 薪水
     */
    private BigDecimal balance;

    /**
     * 年龄
     */
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
}
