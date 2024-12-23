package com.SpringBootHateoas.Entity;


import org.springframework.hateoas.RepresentationModel;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public  class UserData extends RepresentationModel<UserData>{

	private int id;
	private String name;
	private String lastname;
	
}



