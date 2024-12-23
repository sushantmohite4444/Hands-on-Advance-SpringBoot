package com.ExceptionHandling.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ExceptionHandling.Entity.ExceptionProduct;

@Repository
public interface ProductRepository extends JpaRepository<ExceptionProduct,Integer> {

}
