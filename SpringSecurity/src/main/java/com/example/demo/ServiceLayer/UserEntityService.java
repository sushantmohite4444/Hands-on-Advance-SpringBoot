package com.example.demo.ServiceLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.EntityClasses.UsersEntity;
import com.example.demo.Repository.UserRepository;

import jakarta.annotation.PostConstruct;

@Service

public class UserEntityService {

	@Autowired
	private UserRepository repo;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

	public UsersEntity saveUser(UsersEntity user) {
		user.setPassword(encoder.encode(user.getPassword()));
		
		System.out.println(user.getPassword());
		return repo.save(user);

	}

	public UsersEntity getEntity(String username) {
		System.out.println(username + " service " + repo.findByusername(username));
		return repo.findByusername(username);
	}
	
	@PostConstruct
	public void init() {
		System.out.println("init method of userEntity");
	}
}
