package com.worstbuy.assignment.worstbuyshoppingcart.util;

public enum ProductCategory {
	
	PHONE(1),
	TELEVISION(2),
	INSURANCE(3),
	SIM(4),
	PHONE_CASE(5);
  	
	private long categoryId;
	
	private ProductCategory(long categoryId){
		this.categoryId = categoryId;
	}
	
	public long getCategoryId() {
		return this.categoryId;
	}
	

}
