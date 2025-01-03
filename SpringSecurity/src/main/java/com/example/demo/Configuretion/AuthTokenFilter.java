package com.example.demo.Configuretion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.ServiceLayer.UserServiceimpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component
public class AuthTokenFilter  extends OncePerRequestFilter{
    @Autowired
    private JwtUtills jwtUtills;

    @Autowired
    private UserServiceimpl userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException,  java.io.IOException {
        try {
            String jwt = paresJwt(request);
        
            if(jwt != null && jwtUtills.validateJwtToken(jwt)){
                String username = jwtUtills.getUsernameFromJwtToken(jwt);
                UserDetails userDetails= userDetailsService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken authenticationToken =
                		new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }catch (Exception e){
            logger.error("Cannot set User Authenticaion :{}", e);
        }
        filterChain.doFilter(request, response);
    }

    private String paresJwt(HttpServletRequest request){
        String headerAuth= request.getHeader("Authorization");
        if ( headerAuth.startsWith("Bearer ")){
            return headerAuth.substring(7);

        }
        return null;
    }

	
}

