package com.worstbuy.assignment.worstbuyshoppingcart.model;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Cart {
	
	private List<Product> products;
	
	private double totalPrice;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	@Override
	public int hashCode(){
	    return new HashCodeBuilder()
	    	.append(products)
	        .append(totalPrice)
	        .toHashCode();
	}
	
	
	@Override
	public boolean equals(final Object obj){
	    if(obj instanceof Cart ){
	        final Cart other = (Cart) obj;
	        return new EqualsBuilder()
	        	.append(products, other.products)
	            .append(totalPrice, other.totalPrice)
	            .isEquals();
	    } else{
	        return false;
	    }
	}
	

	@Override
	public String toString() {
		return "Cart [products=" + products + ", totalPrice=" + totalPrice + "]";
	}
	
	
	
	

}
