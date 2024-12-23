package com.SpringBootVersioning.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootVersioning.Entity.UserV1;
import com.SpringBootVersioning.Entity.UserV2;

@RestController
@RequestMapping("Versioning")
public class Versioning {
	
	// url demo
	
	@GetMapping("/v1/user")
	public ResponseEntity<UserV1> UrlV1(){
		return new  ResponseEntity(new UserV1(1,"sushant","mohite"),HttpStatus.OK);
		
	}
	
	@GetMapping("/v2/user")
	public ResponseEntity<UserV2> UrlV2(){
		return new  ResponseEntity(new UserV2("sushant","mohite"),HttpStatus.OK);
	}
	
	// parameter
	@GetMapping(path = "/user", params = "version=1")
	public ResponseEntity<UserV1> parameterV1(){
		return new  ResponseEntity(new UserV1(1,"sushant","mohite"),HttpStatus.OK);
		
	}
	
	@GetMapping(path = "/user", params = "version=2")
	public ResponseEntity<UserV2> parameterV2(){
		return new  ResponseEntity(new UserV2("sushant","mohite"),HttpStatus.OK);
		
	}
	
	//header

	@GetMapping(path = "/user" ,headers = "X-API-VERSION=1")
	public ResponseEntity<UserV1> headerV1(){
		return new  ResponseEntity(new UserV1(1,"sushant","mohite"),HttpStatus.OK);
		
	}
	
	@GetMapping(path = "/user", headers =  "X-API-VERSION=2")
	public ResponseEntity<UserV2> headerV2(){
		return new  ResponseEntity(new UserV2("sushant","mohite"),HttpStatus.OK);
		
	}
	
	
	

}
