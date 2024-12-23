package EurekaClient.FeingClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import EurekaClient.Entity.User;




@FeignClient("REST-API-Example") 

public interface Feing {
	
	
	@GetMapping("/{id}")
	public ResponseEntity<User> senddata(@PathVariable("id") int id) ;

	@GetMapping("")
	public ResponseEntity<List<User>> senddata() ;
	

	@PutMapping("update/{id}")
	public ResponseEntity<User> Update(@RequestBody User obj,@PathVariable int id);
	
	@PostMapping("postdata")
	public ResponseEntity<User>  postdata(@RequestBody User ut )  ;
		
	}

