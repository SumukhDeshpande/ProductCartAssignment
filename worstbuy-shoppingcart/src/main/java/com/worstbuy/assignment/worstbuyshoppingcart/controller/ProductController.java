package com.worstbuy.assignment.worstbuyshoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.worstbuy.assignment.worstbuyshoppingcart.model.Product;
import com.worstbuy.assignment.worstbuyshoppingcart.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping("/worstbuyshop/products")
	public ResponseEntity<List<Product>> getAllProducts() {

		List<Product> productList = productService.getAllProducts();

		ResponseEntity<List<Product>> productResponseEntity = new ResponseEntity<List<Product>>(productList, HttpStatus.OK);

		return productResponseEntity;
	}

	@PostMapping("/worstbuyshop/updateProduct")
	public ResponseEntity<String> updateProduct(@RequestBody Product product) {
		
		ResponseEntity<String> productUpdateResponseEntity = new ResponseEntity<String>(productService.updateProduct(product), HttpStatus.OK);
		
		return productUpdateResponseEntity;
	}

}
