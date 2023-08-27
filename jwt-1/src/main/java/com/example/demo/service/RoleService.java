package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.Roledao;
import com.example.demo.entity.Role;

@Service
public class RoleService {

    @Autowired
    private Roledao roleDao;

    public Role createNewRole(Role role) {
        return roleDao.save(role);
    }
}