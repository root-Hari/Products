package com.dto;

import lombok.Data;

@Data
public class ProductResponceDto
{
	
    private long productId;
	
	private String productName;
	
	private double price;
	
	private double discount;
	
	private double rating;
	
	private boolean isAvaialable;
	
	private int stock;
}
