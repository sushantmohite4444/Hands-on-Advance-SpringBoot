package com.SpringbootProfiling.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@Profile("dev")
public class DevProfile {
	
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
