package com.example.demo.Configuretion;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.ServiceLayer.UserServiceimpl;

@Configuration
public class SpringBeanConfiguretion {
	
	
	@Autowired
	UserServiceimpl userServiceimpl;
	
	@Autowired
	AuthTokenFilter authTokenFilter;
	
	@Bean
	public AuthenticationProvider authprovider() {
		
		DaoAuthenticationProvider daoauth =
				new DaoAuthenticationProvider();
		daoauth.setUserDetailsService(userServiceimpl);
		daoauth.setPasswordEncoder(new BCryptPasswordEncoder(10));
		return daoauth;
	}
	
	@Bean
	public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
			return http.csrf(csrf ->csrf.disable())
						.authorizeHttpRequests(auth -> 
						 auth
						 .requestMatchers("Jwtadmin").hasRole("ADMIN")
						 .requestMatchers("Jwtuser").hasAnyRole("ADMIN","USER")
						 .requestMatchers("register","login").permitAll()
				          .anyRequest().authenticated())
						
//						.formLogin(Customizer.withDefaults())
//						.httpBasic(Customizer.withDefaults())
						.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				        .addFilterBefore(authTokenFilter, UsernamePasswordAuthenticationFilter.class)
				        
						.build();
	}
	
	@Bean 
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
		
		
	}
	
}
