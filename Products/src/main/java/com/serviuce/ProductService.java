package com.serviuce;

import java.util.List;

import com.dto.ProductRequestDto;
import com.dto.ProductResponceDto;

public interface ProductService 
{

	public ProductResponceDto save(ProductRequestDto productRequestDto);
	//This is ProductService interface is used for security and abstract and incomplete methods

	public ProductResponceDto findId(Long id);

	public List<ProductResponceDto> search();

	public ProductResponceDto updateRating(long id, double rating);

	public List<ProductResponceDto> priceFillter(double price);

	public List<ProductResponceDto> findName(String productName);

	public List<ProductResponceDto> findIds(List<Long> ids);
	

}
