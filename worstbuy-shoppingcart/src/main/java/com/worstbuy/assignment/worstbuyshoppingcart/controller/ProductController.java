package com.worstbuy.assignment.worstbuyshoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.worstbuy.assignment.worstbuyshoppingcart.model.Product;
import com.worstbuy.assignment.worstbuyshoppingcart.service.ProductService;

@RestController
public class ProductController {
	
	
	@Autowired
	ProductService productService;
	
	
	@GetMapping("/worstbuyshop/products")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}
	
	
	@PostMapping("/worstbuyshop/updateProduct")
	public String updateProduct(Product product) {
		return "success";
	}

}
