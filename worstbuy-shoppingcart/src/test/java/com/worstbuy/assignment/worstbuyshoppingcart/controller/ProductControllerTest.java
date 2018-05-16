package com.worstbuy.assignment.worstbuyshoppingcart.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.worstbuy.assignment.worstbuyshoppingcart.model.Product;
import com.worstbuy.assignment.worstbuyshoppingcart.service.ProductService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProductController.class, secure = false)
public class ProductControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ProductService productService;
	
	private List<Product> mockProduct;
	
	@Test
	public void getAllProductsTest() throws Exception {
		
		Product product = new Product();
		product.setId(10001L);
		product.setMaker("Samsung");
		product.setModel("Samsung-J7-4GLTE");
		product.setName("Samsung-J7");
		product.setPrice(7000);
		product.setDescription("Samsung-4G-latest-phone.");
		product.setCategoryId(1L);
		mockProduct = new ArrayList<Product>();
		mockProduct.add(product);
		
		Mockito.when(productService.getAllProducts()).thenReturn(mockProduct);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/worstbuyshop/products");
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		System.out.println(result.getResponse());
		
		
		
		String expected = "[{id:10001,name:Samsung-J7,maker:Samsung,model:Samsung-J7-4GLTE,description:Samsung-4G-latest-phone.,price:7000,categoryId:1}]";
		
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
		
		
	}
	

}
