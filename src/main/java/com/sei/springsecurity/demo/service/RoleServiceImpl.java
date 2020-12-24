package com.sei.springsecurity.demo.service;

import com.sei.springsecurity.demo.dao.RoleDao;
import com.sei.springsecurity.demo.dao.RoleDaoImpl;
import com.sei.springsecurity.demo.dao.UserDao;
import com.sei.springsecurity.demo.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    @Transactional
    public List<Role> getALlRoles() {

        return roleDao.getAllRoles();
    }
}
