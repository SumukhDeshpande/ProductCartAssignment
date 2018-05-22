package com.worstbuy.assignment.worstbuyshoppingcart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worstbuy.assignment.worstbuyshoppingcart.exception.ValidationException;
import com.worstbuy.assignment.worstbuyshoppingcart.model.Cart;
import com.worstbuy.assignment.worstbuyshoppingcart.model.Product;
import com.worstbuy.assignment.worstbuyshoppingcart.repositories.ProductRepository;
import com.worstbuy.assignment.worstbuyshoppingcart.util.CartMaker;

@Service
public class CartService {
	
	@Autowired
	CartMaker cartMaker;
	
	@Autowired
	ProductRepository productRepository;
	
	public Cart createCart(List<Product> productList) throws ValidationException {
		List<Product> productMasterList = productRepository.findAll();

		Cart cart = cartMaker.createCart(productList, productMasterList);
		return cart;
	}

}
