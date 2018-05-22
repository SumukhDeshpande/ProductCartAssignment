package com.worstbuy.assignment.worstbuyshoppingcart.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.worstbuy.assignment.worstbuyshoppingcart.model.Product;



public interface ProductRepository extends CrudRepository<Product, Long> {
	
	public List<Product> findAll();
	
	public Product save(Product product);
	

}
