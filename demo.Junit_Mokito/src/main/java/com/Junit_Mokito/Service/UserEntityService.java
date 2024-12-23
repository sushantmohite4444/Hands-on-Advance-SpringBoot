package com.Junit_Mokito.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Junit_Mokito.Entity.UsersEntity;
import com.Junit_Mokito.Repository.UserRepository;

import jakarta.annotation.PostConstruct;

@Service
public class UserEntityService {

	@Autowired
	private UserRepository repo;
	
	
	public UsersEntity saveUser(UsersEntity user) {

		return repo.save(user);

	}

	
	
	@PostConstruct
	public void init() {
		System.out.println("init method of userEntity");
	}



	public void deleteUser(Integer id) {
		repo.deleteById(id);
	}
	
	private Boolean Privatemethod(String name) {
		System.out.println(name);
		return Boolean.TRUE;
		
	}
}
