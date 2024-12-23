package com.example.demo.ServiceLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.EntityClasses.UserDetailsimpl;

@Service
public class UserServiceimpl implements UserDetailsService {

	@Autowired
	UserEntityService userEntityService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		System.out.println(username + " UserServiceimpl");
		UserDetailsimpl userDetailsimpl =
				new UserDetailsimpl(userEntityService.getEntity(username));
		System.out.println( "UserServiceimpl "+userDetailsimpl);
		
		return userDetailsimpl;
	}

}
