package com.SpringBootVersioning.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserV1 {

	private Integer id;
	private String name;
	private String lastName;
}
