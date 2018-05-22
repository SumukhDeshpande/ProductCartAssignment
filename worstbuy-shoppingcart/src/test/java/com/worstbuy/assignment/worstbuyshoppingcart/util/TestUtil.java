package com.worstbuy.assignment.worstbuyshoppingcart.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.worstbuy.assignment.worstbuyshoppingcart.model.Product;
import com.fasterxml.jackson.annotation.JsonInclude;

public class TestUtil {

	public static byte[] convertObjectToJsonBytes(Object object) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		return mapper.writeValueAsBytes(object);
	}

	public static List<Product> getMultiplePhoneCases(int count) {
		List<Product> phoneCaseList = new ArrayList<Product>();

		for (int i = 0; i < count; i++) {

			Product phoneCase = new Product();
			phoneCase.setId(10004L);
			phoneCase.setMaker("Phone Case");
			phoneCase.setModel("Some Phone Case");
			phoneCase.setName("Plastic");
			phoneCase.setPrice(100);
			phoneCase.setDescription("This is a Plastic Phone Case.");
			phoneCase.setCategoryId(ProductCategory.PHONE_CASE.getCategoryId());

			phoneCaseList.add(phoneCase);

		}
		return phoneCaseList;

	}

	public static List<Product> getMasterProductList() {

		List<Product> productMasterList = new ArrayList<Product>();

		Product insuranceMasterProduct = new Product();
		insuranceMasterProduct.setId(10005L);
		insuranceMasterProduct.setMaker("XYZ Company General Insurance");
		insuranceMasterProduct.setModel("General Insurance");
		insuranceMasterProduct.setName("General Insurance");
		insuranceMasterProduct.setPrice(100);
		insuranceMasterProduct.setDescription("This is a General Insurance.");
		insuranceMasterProduct.setCategoryId(ProductCategory.INSURANCE.getCategoryId());

		Product phoneMasterProduct = new Product();
		phoneMasterProduct.setId(10001L);
		phoneMasterProduct.setMaker("Samsung");
		phoneMasterProduct.setModel("Samsung-J7-4GLTE");
		phoneMasterProduct.setName("Samsung-J7");
		phoneMasterProduct.setPrice(1000);
		phoneMasterProduct.setDescription("Samsung-4G-latest-phone.");
		phoneMasterProduct.setCategoryId(ProductCategory.PHONE.getCategoryId());

		Product phoneCaseMasterProduct = new Product();
		phoneCaseMasterProduct.setId(10004L);
		phoneCaseMasterProduct.setMaker("Phone Case");
		phoneCaseMasterProduct.setModel("Some Phone Case");
		phoneCaseMasterProduct.setName("Plastic");
		phoneCaseMasterProduct.setDescription("This is a Plastic Phone Case.");
		phoneCaseMasterProduct.setPrice(150);
		phoneCaseMasterProduct.setCategoryId(ProductCategory.PHONE_CASE.getCategoryId());

		Product simMasterProduct = new Product();
		simMasterProduct.setId(10002L);
		simMasterProduct.setMaker("Vodafone");
		simMasterProduct.setModel("4G");
		simMasterProduct.setName("Vodafone");
		simMasterProduct.setPrice(300);
		simMasterProduct.setDescription("This is a 4G Sim.");
		simMasterProduct.setCategoryId(ProductCategory.SIM.getCategoryId());

		Product tvMasterProduct = new Product();
		tvMasterProduct.setId(10003L);
		tvMasterProduct.setMaker("LG");
		tvMasterProduct.setModel("LCD");
		tvMasterProduct.setName("LG");
		tvMasterProduct.setPrice(1000);
		tvMasterProduct.setDescription("This is a LCD TV.");
		tvMasterProduct.setCategoryId(ProductCategory.TELEVISION.getCategoryId());

		productMasterList.add(insuranceMasterProduct);
		productMasterList.add(phoneMasterProduct);
		productMasterList.add(phoneCaseMasterProduct);
		productMasterList.add(simMasterProduct);
		productMasterList.add(tvMasterProduct);
		
		return productMasterList;
	}
	
	
	public static List<Product> getSampleProductList(){
		
		List<Product> productList = new ArrayList<Product>();
		
		
		Product phone = new Product();
		phone.setId(10001L);
		phone.setMaker("SamZung");
		phone.setModel("SamZung-J7-4GLTE");
		phone.setName("SamZung-J7");
		phone.setPrice(1000);
		phone.setDescription("SamZung-4G-latest-phone.");
		phone.setCategoryId(ProductCategory.PHONE.getCategoryId());
		phone.setInsuranceRequired(true);
		
		Product simProduct = new Product();
		simProduct.setId(10002L);
		simProduct.setMaker("Vodafone");
		simProduct.setModel("4G");
		simProduct.setName("Vodafone");
		simProduct.setDescription("This is a 4G Sim.");
		simProduct.setPrice(300);
		simProduct.setCategoryId(ProductCategory.SIM.getCategoryId());
		simProduct.setInsuranceRequired(true);
		
		Product television = new Product();
		television.setId(10003L);
		television.setMaker("SamZung");
		television.setModel("LCD");
		television.setName("SamZung");
		television.setDescription("This is a LCD TV.");
		television.setPrice(1000);
		television.setCategoryId(ProductCategory.TELEVISION.getCategoryId());
		television.setInsuranceRequired(true);
		
		Product phoneCase = new Product();
		phoneCase.setId(10004L);
		phoneCase.setMaker("Phone Case");
		phoneCase.setModel("Some Phone Case");
		phoneCase.setName("Plastic");
		phoneCase.setPrice(100);
		phoneCase.setDescription("This is a Plastic Phone Case.");
		phoneCase.setCategoryId(ProductCategory.PHONE_CASE.getCategoryId());
		phoneCase.setInsuranceRequired(false);
		
		productList.add(phone);
		productList.add(simProduct);
		productList.add(phoneCase);
		productList.add(television);
		
		return productList;
	}
	
	public static List<Product> getSimList(int count){
		
		List<Product> simList = new ArrayList<Product>(); 
		for(int i = 0; i<count; i++) {
			
			Product simProduct = new Product();
			simProduct.setId(10002L);
			simProduct.setMaker("Vodafone");
			simProduct.setModel("4G");
			simProduct.setName("Vodafone");
			simProduct.setDescription("This is a 4G Sim.");
			simProduct.setPrice(300);
			simProduct.setCategoryId(ProductCategory.SIM.getCategoryId());
			
			simList.add(simProduct);
			
		}
		
		return simList;
		
	}

}
