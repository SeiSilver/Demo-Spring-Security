package com.sei.springsecurity.demo.dao;

import com.sei.springsecurity.demo.entity.Role;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public interface RoleDao {

    public Role findRoleByName(String theRoleName);

    public List<Role> getAllRoles();
}
