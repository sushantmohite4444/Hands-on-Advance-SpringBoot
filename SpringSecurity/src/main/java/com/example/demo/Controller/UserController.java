package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authorization.AuthoritiesAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Configuretion.JwtUtills;
import com.example.demo.EntityClasses.UsersEntity;
import com.example.demo.ServiceLayer.UserEntityService;

@RestController
public class UserController {

	
	@Autowired 
	UserEntityService userEntityService;
	
	@Autowired
	JwtUtills utills;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@GetMapping("login")
	public String Login(@RequestBody UsersEntity usersEntity ) {
		System.out.println("conroller login");

		Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usersEntity.getUsername(),usersEntity.getPassword()));
	       System.out.println(authentication + "sldkfjsa;dlkfjs;ldkfj");
//		SecurityContextHolder.getContext().setAuthentication(authentication);
	        String jwt= utills.generateJwtToken(authentication);
	        return jwt;
	}
	
	@PostMapping("register")
	public UsersEntity regiteruser(@RequestBody UsersEntity user) {
		System.out.println("sushant  mohite");
		return  userEntityService.saveUser(user);
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
