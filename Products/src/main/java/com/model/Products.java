package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@Entity is used for it is behave like a database and the fields are columns

@Data
//@Data is used for getters,setters&ToString  comibination

@AllArgsConstructor
@NoArgsConstructor
@Table(name="products")
//@Table is used for giving the name of table in Database 

public class Products 
{
	@Id
	//@Id is used for primary key.the primary key is combination of uniquw+not null
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@generatedValue is used for reverce bind the value from the database
	
	private long productId;
	
	private String productName;
	
	private double price;
	
	private double discount;
	
	private double rating;
	
	private boolean isAvaialable;
	
	private int stock;

	public Products(String productName, double price, double discount, double rating, boolean isAvaialable, int stock) {
		super();
		this.productName = productName;
		this.price = price;
		this.discount = discount;
		this.rating = rating;
		this.isAvaialable = isAvaialable;
		this.stock = stock;
	}
	
	

}
