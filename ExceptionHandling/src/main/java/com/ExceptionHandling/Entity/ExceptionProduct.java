package com.ExceptionHandling.Entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ExceptionProduct  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id ;
	private String productName;
	private String productDetails;
	

}
