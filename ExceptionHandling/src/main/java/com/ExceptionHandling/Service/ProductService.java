package com.ExceptionHandling.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ExceptionHandling.Entity.ExceptionProduct;
import com.ExceptionHandling.Repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public ExceptionProduct save(ExceptionProduct p) {
		return productRepository.save(p);
	}
	
	public Optional<ExceptionProduct> getproduct(Integer  id) {
		return productRepository.findById(id);
	}
	
	public List< ExceptionProduct >getallproProduct() {
		return productRepository.findAll();
	}

}
