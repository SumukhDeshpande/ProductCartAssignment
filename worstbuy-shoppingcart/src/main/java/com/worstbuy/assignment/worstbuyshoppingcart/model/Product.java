package com.worstbuy.assignment.worstbuyshoppingcart.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
public class Product {

	@Id
	private Long id;
	private String name;
	private String maker;
	private String model;
	private String description;
	private double price;
	private Long categoryId;
	private boolean insuranceRequired;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public boolean isInsuranceRequired() {
		return insuranceRequired;
	}

	public void setInsuranceRequired(boolean insuranceRequired) {
		this.insuranceRequired = insuranceRequired;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).append(name).append(maker).append(model).append(description).append(price).append(categoryId).append(insuranceRequired).toHashCode();
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj instanceof Product) {
			final Product other = (Product) obj;
			return new EqualsBuilder().append(id, other.id).append(name, other.name).append(maker, other.maker).append(model, other.model).append(description, other.description).append(price, other.price).append(categoryId, other.categoryId)
					.append(insuranceRequired, other.insuranceRequired).isEquals();
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", maker=" + maker + ", model=" + model + ", description=" + description + ", price=" + price + ", categoryId=" + categoryId + ", insuranceRequired=" + insuranceRequired + "]";
	}

}
