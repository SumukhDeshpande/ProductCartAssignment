package com.worstbuy.assignment.worstbuyshoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.worstbuy.assignment.worstbuyshoppingcart.exception.ValidationException;
import com.worstbuy.assignment.worstbuyshoppingcart.model.Cart;
import com.worstbuy.assignment.worstbuyshoppingcart.model.Product;
import com.worstbuy.assignment.worstbuyshoppingcart.service.CartService;

@RestController
public class CartController {
	
	@Autowired
	CartService cartService;
	
	
	@PostMapping("/worstbuyshop/createCart")
	public ResponseEntity<Cart> createCart(@RequestBody List<Product> productList) {
		ResponseEntity<Cart> cart = null;
		try {
			cart = new ResponseEntity<Cart>(cartService.createCart(productList), HttpStatus.OK);
		} catch (ValidationException e) {
			
		}
		return cart;
		
	}

}
