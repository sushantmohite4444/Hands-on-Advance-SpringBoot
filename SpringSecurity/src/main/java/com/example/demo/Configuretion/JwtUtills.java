package com.example.demo.Configuretion;


import java.security.Key;
import java.util.Date;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import ch.qos.logback.classic.Logger;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtills {
    private static final Logger logger =(Logger) LoggerFactory.getLogger(JwtUtills.class);

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwtExpiration}")
    private int jwtExpiration;
	
	public String generateJwtToken(Authentication authentication){
	    UserDetails userPricipal = (UserDetails) authentication.getPrincipal();
	    return Jwts.builder()
	        .setSubject(userPricipal.getUsername())
	        .setIssuedAt(new Date())
	        .setExpiration(new Date(new Date().getTime()+jwtExpiration))
	        .signWith(key(), SignatureAlgorithm.HS384)
	        
	        .compact();
	}
	public Key key(){
	    return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
	}
	
	public  boolean validateJwtToken(String authtoken){
	    try {
	    	System.out.println("validateJwtToken");
	        Jwts.parserBuilder().setSigningKey(key()).build().parse(authtoken);
	        return true;
	        
	    } catch (MalformedJwtException e) {
	        logger.error("Invalid JWT Token : {}",e.getMessage());
	    }
	    return false;


	}

	public String getUsernameFromJwtToken(String authtoken){
	    return Jwts.parserBuilder().setSigningKey(key()).build().parseClaimsJws(authtoken).getBody().getSubject();
	}
	}


