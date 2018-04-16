package com.whl.cloud.microservicesimpleprivideruser.entity;

import oracle.jdbc.OracleResultSet;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.ResultSet;

/**
 * UserProcedure
 * TODO:
 * 2018/4/1616:53
 * 1.0
 * hlwu
 */
@Entity
@Table(name = "TM_USER")
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(name = "procedureTest", procedureName = "procedureTest", parameters = {
            @StoredProcedureParameter(name = "uName", mode = ParameterMode.IN, type = String.class),
            @StoredProcedureParameter(name = "uSalary", mode = ParameterMode.OUT, type = String.class)
    }),
    @NamedStoredProcedureQuery(name = "userListTest", procedureName = "packageTest.userListTest", parameters = {
            @StoredProcedureParameter(name = "uSalary", mode = ParameterMode.IN, type = Integer.class),
            @StoredProcedureParameter(name = "userList", mode = ParameterMode.OUT, type = ResultSet.class)
    })
})
public class UserProcedure implements InitializingBean,DisposableBean,Serializable{

    /**
     * 用户Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="USER_ID",unique = true,nullable = false)
    @SequenceGenerator(name="userId",sequenceName="userId_seq",allocationSize=1)
    private BigDecimal userId;

    /**
     * 用户姓名 登录名
     */
    @Column(name = "USER_NAME")
    private String userName;

    /**
     * 密码
     */
    @Column
    private String password;

    /**
     * 部门Id
     */
    @Column(name = "DEPT_NO")
    private BigDecimal deptNo;

    @Column
    private int age;

    @Column
    private String address;

    /**
     * 薪水
     */
    @Column
    private Double salary;

    /**
     * 奖金
     */
    @Column
    private Double bonus;

    public BigDecimal getUserId() {
        return userId;
    }

    public void setUserId(BigDecimal userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(BigDecimal deptNo) {
        this.deptNo = deptNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public UserProcedure() {
    }

    @Override
    public void destroy() throws Exception {

    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
