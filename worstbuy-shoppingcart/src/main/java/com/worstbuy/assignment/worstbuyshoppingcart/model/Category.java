package com.worstbuy.assignment.worstbuyshoppingcart.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
public class Category {
	
	@Id
	private Long id;
	private String name;
	private String description;
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public int hashCode(){
	    return new HashCodeBuilder()
	    	.append(id)
	        .append(name)
	        .append(description)
	        .toHashCode();
	}
	
	
	@Override
	public boolean equals(final Object obj){
	    if(obj instanceof Product){
	        final Category other = (Category) obj;
	        return new EqualsBuilder()
	        	.append(id, other.id)
	            .append(name, other.name)
	            .append(description, other.description)
	            .isEquals();
	    } else{
	        return false;
	    }
	}
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	
	
	
	
	
	
	

}
