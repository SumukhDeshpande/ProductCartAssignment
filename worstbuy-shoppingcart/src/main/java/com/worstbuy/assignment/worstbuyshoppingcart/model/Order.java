package com.worstbuy.assignment.worstbuyshoppingcart.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Order {
	
	private String name;
	private String maker;
	private String model;
	private String description;
	private double price;
	private Long categoryId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(name).append(maker).append(model).append(description).append(price).append(categoryId).toHashCode();
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj instanceof Order) {
			final Order other = (Order) obj;
			return new EqualsBuilder().append(name, other.name).append(maker, other.maker).append(model, other.model).append(description, other.description).append(price, other.price).append(categoryId, other.categoryId)
					.isEquals();
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "Order [name=" + name + ", maker=" + maker + ", model=" + model + ", description=" + description + ", price=" + price + ", categoryId=" + categoryId + "]";
	}
	
	

}
