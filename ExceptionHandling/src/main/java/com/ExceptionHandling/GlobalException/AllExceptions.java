package com.ExceptionHandling.GlobalException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ExceptionHandling.Entity.Exception;
import com.ExceptionHandling.Exceptions.ProductExceptions;



@RestControllerAdvice
public class AllExceptions  {
	
	@ExceptionHandler(ProductExceptions.class)
	public ResponseEntity<?> exception(ProductExceptions proexc){
		
		Exception ex = new Exception(proexc.getMessage(), HttpStatus.NOT_FOUND.toString());
		
		
		return new ResponseEntity<>(ex,HttpStatus.NOT_FOUND);
		
	}

}
