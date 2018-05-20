package com.worstbuy.assignment.worstbuyshoppingcart.controller;

import static com.worstbuy.assignment.worstbuyshoppingcart.util.TestUtil.convertObjectToJsonBytes;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.worstbuy.assignment.worstbuyshoppingcart.model.Product;
import com.worstbuy.assignment.worstbuyshoppingcart.service.CartService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CartController.class, secure = false)
public class CartControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CartService cartService;

	private List<Product> mockProduct;
	
	@Test
	public void testCreateCart() throws Exception {
		String jsonString = "[{\"id\":1001,\"name\":\"SamZungJ7\",\"maker\":\"SamZung\",\"model\":\"J7\",\"description\":\"Thisisa4GPhone\",\"categoryId\":1,\"insuranceRequired\":true},{\"id\":1001,\"name\":\"LG\",\"maker\":\"LG\",\"model\":\"LGMAX\",\"description\":\"Thisisa4GPhone\",\"categoryId\":1,\"insuranceRequired\":false},{\"id\":1002,\"name\":\"Vodafone\",\"maker\":\"Vodafone\",\"model\":\"4G\",\"description\":\"Thisisa4GSim\",\"categoryId\":4,\"insuranceRequired\":true}]";
		
		mockMvc.perform(post("/worstbuyshop/createCart").contentType(MediaType.APPLICATION_JSON).content(jsonString))
		.andExpect(status().isOk());
		
	}

}
