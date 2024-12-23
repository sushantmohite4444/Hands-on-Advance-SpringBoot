package com.Junit_Mokito.Entity;






import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.FetchType;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class UsersEntity  {
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	  @Column(unique = true) 
    private String username;

    private String password;
    
    

   
}