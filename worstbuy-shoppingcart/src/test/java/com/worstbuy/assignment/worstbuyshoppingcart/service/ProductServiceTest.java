package com.worstbuy.assignment.worstbuyshoppingcart.service;

import static com.worstbuy.assignment.worstbuyshoppingcart.util.TestUtil.getMasterProductList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.worstbuy.assignment.worstbuyshoppingcart.model.Product;
import com.worstbuy.assignment.worstbuyshoppingcart.repositories.ProductRepository;
import com.worstbuy.assignment.worstbuyshoppingcart.util.ProductCategory;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {
	
	@Mock
	ProductRepository productRepository;
	
	@InjectMocks
	ProductService productService = new ProductService();
	
	@Test
	public void testFindAllProducts() {
		
		List<Product> productMasterList = getMasterProductList();
		
		when(productRepository.findAll()).thenReturn(productMasterList);
		
		List<Product> productMasterListFromRepo = productService.getAllProducts();
		
		assertEquals(productMasterList, productMasterListFromRepo);
		
	}
	
	@Test
	public void testSaveProduct() {
		
		Product phoneProduct = new Product();
		phoneProduct.setId(10001L);
		phoneProduct.setMaker("Samsung");
		phoneProduct.setModel("Samsung-J7-4GLTE");
		phoneProduct.setName("Samsung-J7");
		phoneProduct.setPrice(1000);
		phoneProduct.setDescription("Samsung-4G-latest-phone.");
		phoneProduct.setCategoryId(ProductCategory.PHONE.getCategoryId());
		
		when(productRepository.save(phoneProduct)).thenReturn(phoneProduct);
		
		String message = productService.updateProduct(phoneProduct);
		
		assertEquals("success", message);
		
	}
	
	@Test
	public void testSaveProductForNull() {
		
		Product phoneProduct = new Product();
		phoneProduct.setId(10008L);
		phoneProduct.setMaker("Samsung");
		phoneProduct.setModel("Samsung-Refrigerator");
		phoneProduct.setName("Samsung-Refrigerator");
		phoneProduct.setPrice(1000);
		phoneProduct.setDescription("Samsung-latest-refrigerator.");
		phoneProduct.setCategoryId(ProductCategory.PHONE.getCategoryId());
		
		when(productRepository.save(phoneProduct)).thenReturn(null);
		
		String message = productService.updateProduct(phoneProduct);
		
		assertEquals("failure", message);
		
	}

}
