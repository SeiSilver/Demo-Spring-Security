package com.sei.springsecurity.demo.service;

import com.sei.springsecurity.demo.entity.User;
import com.sei.springsecurity.demo.user.CrmUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByUserName(String userName);

    void save(CrmUser crmUser);
}
