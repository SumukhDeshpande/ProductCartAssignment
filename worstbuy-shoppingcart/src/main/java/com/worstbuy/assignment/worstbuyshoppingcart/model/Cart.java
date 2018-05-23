package com.worstbuy.assignment.worstbuyshoppingcart.model;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Cart {
	
	private List<Order> orders;
	
	private double totalPrice;
	
	private String message;

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public int hashCode(){
	    return new HashCodeBuilder()
	    	.append(orders)
	        .append(totalPrice)
	        .append(message)
	        .toHashCode();
	}
	
	
	@Override
	public boolean equals(final Object obj){
	    if(obj instanceof Cart ){
	        final Cart other = (Cart) obj;
	        return new EqualsBuilder()
	        	.append(orders, other.orders)
	            .append(totalPrice, other.totalPrice)
	            .append(message, other.message)
	            .isEquals();
	    } else{
	        return false;
	    }
	}

	@Override
	public String toString() {
		return "Cart [orders=" + orders + ", totalPrice=" + totalPrice + ", message=" + message + "]";
	}
	


}
