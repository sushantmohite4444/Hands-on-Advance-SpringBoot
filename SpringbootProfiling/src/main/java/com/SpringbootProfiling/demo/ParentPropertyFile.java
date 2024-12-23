package com.SpringbootProfiling.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class ParentPropertyFile {
	
	@Value("${Myusername}")
	private String username;
	
	@Value("${password}")
	private String password;
	
	@PostConstruct
	public void init() {

	    System.out.println("Active Profile: " + System.getProperty("spring.profiles.active"));
		System.out.println( "Username = "+ username + " password = " +password);
	}
	

}
