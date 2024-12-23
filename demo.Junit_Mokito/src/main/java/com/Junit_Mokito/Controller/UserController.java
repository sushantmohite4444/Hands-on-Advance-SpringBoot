package com.Junit_Mokito.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Junit_Mokito.Entity.UsersEntity;
import com.Junit_Mokito.Service.UserEntityService;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;


@RestController
public class UserController {

	
	@Autowired 
	UserEntityService userEntityService;
	
	

	
	@GetMapping("/login")
	public String Login() {
		return "ok";
		
	}
	
	@GetMapping("/delete/{id}")
	public void delete(@PathVariable("id") Integer Id ) {
		
		userEntityService.deleteUser(Id);
	}
	
	@PostMapping("/register")
	public UsersEntity regiteruser(@RequestBody UsersEntity user) {
		return userEntityService.saveUser(user);
		
	}
	
	@GetMapping("Jwtuser")
	public String Printuser() {
	
		return "USER";
	}
	
	@GetMapping("Jwtadmin")
	public String Printadmin() {
	
		return "ADMIN";
	}
	
	
	
	
}
