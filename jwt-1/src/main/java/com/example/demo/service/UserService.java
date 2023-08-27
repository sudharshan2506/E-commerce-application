package com.example.demo.service;
import com.example.demo.entity.*;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    @Autowired
    private PasswordEncoder passwordencoder;
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
	}
		
		
		public User registerNewUser(User user) {
	        Role role = roleDao.findById("User").get();
	        Set<Role> userRoles = new HashSet<>();
	        userRoles.add(role);
	        user.setRole(userRoles);
	        user.setUserPassword(getEncodedPassword(user.getUserPassword()));

	        return userdao.save(user);
	    }

	    public String getEncodedPassword(String password) {
	        return passwordencoder.encode(password);
	    }

	

    }

    
    