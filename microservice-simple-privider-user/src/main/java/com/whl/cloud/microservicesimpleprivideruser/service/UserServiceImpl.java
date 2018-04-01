package com.whl.cloud.microservicesimpleprivideruser.service;

import com.whl.cloud.microservicesimpleprivideruser.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRep;
}
