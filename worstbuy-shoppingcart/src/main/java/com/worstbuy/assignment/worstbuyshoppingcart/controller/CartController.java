package com.worstbuy.assignment.worstbuyshoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.worstbuy.assignment.worstbuyshoppingcart.model.Cart;
import com.worstbuy.assignment.worstbuyshoppingcart.model.Product;
import com.worstbuy.assignment.worstbuyshoppingcart.service.CartService;

@RestController
public class CartController {
	
	@Autowired
	CartService cartService;
	
	
	@PostMapping("/worstbuyshop/createCart")
	public Cart createCart(List<Product> productList) {
		
		cartService.createCart(productList);
		
		return new Cart();
		
	}

}
