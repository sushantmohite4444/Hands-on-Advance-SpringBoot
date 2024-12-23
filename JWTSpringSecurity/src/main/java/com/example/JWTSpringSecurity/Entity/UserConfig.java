package com.example.JWTSpringSecurity.Entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserConfig implements UserDetails {
	
	
	UserEntity userEntity;
	
	public UserConfig(UserEntity userEntity) {
		 this.userEntity =userEntity;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return userEntity.getRoles();
	}

	@Override
	public String getPassword() {
		
		return userEntity.getPassword();
	}

	@Override
	public String getUsername() {
		
		return userEntity.getUsername();
	}

}
