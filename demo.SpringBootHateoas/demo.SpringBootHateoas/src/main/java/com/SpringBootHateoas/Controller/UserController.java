package com.SpringBootHateoas.Controller;


import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootHateoas.Entity.UserData;

@RestController
@RequestMapping("User")
public class UserController {

	@GetMapping("/one")
	public ResponseEntity<UserData> HateoasExample() {
		
       UserData userData =new UserData(1,"sushant","mohite");
		
		Link link = WebMvcLinkBuilder.linkTo(UserController.class).slash("delete")
				.slash(userData.getId()).withRel("Delete").withType("application/json");
		
	userData.add(link);
	
	Link link1 = Link.of("/User/update/"+ userData.getId()).withRel("Update").withType("application/json");
	
	userData.add(link1);
		
		return  new ResponseEntity(userData,HttpStatus.OK) ;
	}
	
	
	@PostMapping("/update/{id}")
   public ResponseEntity<UserData> updataEntity (@PathVariable("id") int id){
	   
		//update data and return 
		System.out.println(id);
	   
	return new ResponseEntity(new UserData(1,"sushant","mohite"),HttpStatus.OK);
	   
   }
	
	

}
