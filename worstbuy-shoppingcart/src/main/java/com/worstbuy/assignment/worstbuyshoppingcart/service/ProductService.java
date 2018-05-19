package com.worstbuy.assignment.worstbuyshoppingcart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worstbuy.assignment.worstbuyshoppingcart.dao.ProductDao;
import com.worstbuy.assignment.worstbuyshoppingcart.model.Product;

@Service
public class ProductService {

	@Autowired
	ProductDao productDao;

	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}

	public String updateProduct(Product product) {
		return productDao.updateProduct(product);
	}

}
