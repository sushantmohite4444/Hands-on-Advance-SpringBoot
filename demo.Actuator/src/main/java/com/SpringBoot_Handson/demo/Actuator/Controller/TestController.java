package com.SpringBoot_Handson.demo.Actuator.Controller;

import java.security.PublicKey;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/hello")
	public void print() throws InterruptedException {
		
		
		while(true) {
			
			Runnable runnable= ()->{
				 int count=0;
				while(true) {
					count++;
				}
				
			};
			
			new Thread(runnable).start();
			
		
			
			
		}
		
		
		
		
	}
}
