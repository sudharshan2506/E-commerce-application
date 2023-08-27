package com.example.demo.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Roledao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;

@Service
public class UserService {

    @Autowired
    private UserDao userdao;

    @Autowired
    private Roledao roleDao;

	public User registerNewUser(User user) {
		userdao.save(user);
		return user;
	}
	public void initolesandurser() {
		Role adminRole=new Role();
		adminRole.setRoleName("Admin");
		adminRole.setRoleDescription("Admin role");
		roleDao.save(adminRole);
		Role userRole=new Role();
		userRole.setRoleName("User");
		userRole.setRoleDescription("Default User role");
		roleDao.save(userRole);
		
		User adminUser=new User();
		adminUser.setUserFirstName("admin");
		adminUser.setUserLastName("admin");
		adminUser.setUserName("admin123");
		adminUser.setUserPassword("admin@pass");
		Set <Role> adminRoles=new HashSet<>();
		adminRoles.add(adminRole);
		adminUser.setRole(adminRoles);
		userdao.save(adminUser);
		
		User user=new User();
		user.setUserFirstName("raj");
		user.setUserLastName("sharma");
		user.setUserName("raj123");
		user.setUserPassword("raj@pass");
		Set <Role> userRoles=new HashSet<>();
		userRoles.add(userRole);
		user.setRole(userRoles);
		userdao.save(user);

	}

    }

    
    