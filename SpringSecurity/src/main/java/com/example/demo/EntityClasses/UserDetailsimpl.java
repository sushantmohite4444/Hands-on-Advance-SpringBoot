package com.example.demo.EntityClasses;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import lombok.Data;


public class UserDetailsimpl implements UserDetails {

	
	 private  UsersEntity usersEntity;
	
	public UserDetailsimpl(UsersEntity usersEntity) {
		System.out.println("UserDetailsimpl = " + usersEntity );
		this.usersEntity = usersEntity;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return  usersEntity.getRole().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role)) // Prefix roles with 'ROLE_' to match Spring Security convention
                .collect(Collectors.toList());
    }
	

	@Override
	public String getPassword() {
		
		return usersEntity.getPassword();
	}

	@Override
	public String getUsername() {
		
		return usersEntity.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}
	

}
