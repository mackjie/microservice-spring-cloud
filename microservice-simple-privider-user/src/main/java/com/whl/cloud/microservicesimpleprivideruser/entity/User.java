package com.whl.cloud.microservicesimpleprivideruser.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name="TM_USER")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class User implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long userId;

    /**
     * 登录名
     */
    @Column(name = "USER_NAME")
    private String userName;

    /**
     * 用户名
     */
    @Column
    private String name;

    /**
     * 薪水
     */
    @Column
    private BigDecimal balance;

    /**
     * 年龄
     */
    @Column
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
