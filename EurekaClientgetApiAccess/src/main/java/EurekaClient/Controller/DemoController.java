package EurekaClient.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import EurekaClient.Entity.User;
import EurekaClient.Service.UserserviceImpl;



@RestController
public class DemoController {
	
	
		@Autowired
		UserserviceImpl userserviceImpl;

	@GetMapping("/{id}")
	public ResponseEntity<User> senddata(@PathVariable("id") int id) {
		
	
		return  userserviceImpl.getUser(id);
		}

	@GetMapping("")
	public ResponseEntity<List<User>> senddata() {

		return userserviceImpl.getUsers();

	}

	@PutMapping("update/{id}")
	public ResponseEntity<User> Update(@RequestBody User obj,@PathVariable int id){

		return userserviceImpl.updateUser( id,obj );
		
	}
	
	@PostMapping("postdata")
	public ResponseEntity<User>  postdata(@RequestBody User ut ) {
  
		
		System.out.println("000000000000000000000000000000000");
		
		 
		return userserviceImpl.saveUser(ut) ;
		
	}
	
	@GetMapping("ok")
	public String ok() {
		return "client is working";
	}
	
}
