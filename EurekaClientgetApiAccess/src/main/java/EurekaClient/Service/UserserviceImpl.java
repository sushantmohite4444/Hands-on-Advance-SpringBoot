package EurekaClient.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import EurekaClient.Entity.User;
import EurekaClient.FeingClient.Feing;




@Service
public class UserserviceImpl  {

	@Autowired
	Feing feing;

//	
	public ResponseEntity<User> updateUser(Integer id, User user) {

	    
	     
	     return feing.Update(user,id);
	}

	
	public ResponseEntity<User> getUser(Integer id) {
		
		
		return feing.senddata(id);
		

	}
	
	public ResponseEntity<List<User>> getUsers() {
		return feing.senddata();
	}


	public ResponseEntity<User> saveUser(User ut) {
		
		return feing.postdata(ut);
	}
	
	

}
