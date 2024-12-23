package com.ExceptionHandling.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ExceptionHandling.Entity.Exception;
import com.ExceptionHandling.Entity.ExceptionProduct;
import com.ExceptionHandling.Exceptions.ProductExceptions;
import com.ExceptionHandling.Service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService ;
	
	
	@GetMapping("product/{id}")
	public ResponseEntity<?> getExceptionproduct (@PathVariable ("id") Integer id){
		
		
		ExceptionProduct eProduct =productService.getproduct(id).orElseThrow(() ->new ProductExceptions(" Id " + id +" not found"));
	
		return new ResponseEntity<>(eProduct, HttpStatus.OK);
	}
	
	@PostMapping("product")
	public ResponseEntity<ExceptionProduct> addExceptionproduct (@RequestBody ExceptionProduct p){
	
		return new ResponseEntity<>(productService.save(p), HttpStatus.OK);
	}
	
	@GetMapping("products")
	public ResponseEntity<?> getalldata (){
	
		return new ResponseEntity<>(productService.getallproProduct(), HttpStatus.OK);
	}
	

//	@ExceptionHandler(ProductExceptions.class)
//	public ResponseEntity<?> exception (ProductExceptions p ){
//		
//		Exception e = new Exception(p.getMessage(),"1222");
//		
//		return new ResponseEntity<Object>(e,HttpStatus.NOT_FOUND);
//		
//	}
	
	

}
