package com.worstbuy.assignment.worstbuyshoppingcart.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.worstbuy.assignment.worstbuyshoppingcart.model.Product;

@Repository
public class ProductDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Product> getAllProducts(){
		
		return jdbcTemplate.query("select id, name, maker, model, description, price, category_id from product", new ProductRowMapper());
		
	}
	
	public String updateProduct(Product product) {
		return null;
	}
	
	
	class ProductRowMapper implements RowMapper<Product> {
		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product product = new Product();
			
			product.setId(rs.getLong("id"));
			product.setMaker(rs.getString("maker"));
			product.setModel(rs.getString("model"));
			product.setName(rs.getString("name"));
			product.setPrice(rs.getInt("price"));
			product.setDescription(rs.getString("description"));
			product.setCategoryId(rs.getLong("category_id"));
			
			return product;
		}

	}

}
