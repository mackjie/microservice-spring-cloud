package com.whl.cloud.microservicesimpleprivideruser.repository;

import com.whl.cloud.microservicesimpleprivideruser.entity.UserProcedure;
import oracle.jdbc.OracleResultSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.List;

@Repository
public interface UserProcedureRepository extends JpaRepository<UserProcedure,BigDecimal> {

    /* *
     * @author --吴豪磊--
     * @date 2018/4/16 18:00  
     * @param [uName]  
     * @return java.lang.Number  
     * TODO
     * @Description: 根据用户名查询改用户的年薪
     */
    @Procedure(name = "procedureTest")
    String getYearSalary(@Param("uName") String uName);

    /* *
     * @author --吴豪磊--
     * @date 2018/4/16 17:59
     * @param [salary]  
     * @return java.util.List<com.whl.cloud.microservicesimpleprivideruser.entity.UserProcedure>  
     * TODO
     * @Description: 获取薪资大于当前的用户集合
     */
    @Procedure(name = "userListTest")
    ResultSet getAllUser(@Param("uSalary") Integer salary);
}
