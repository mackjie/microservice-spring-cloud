package com.whl.cloud.microservicesimpleprivideruser.repository;

import com.whl.cloud.microservicesimpleprivideruser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
