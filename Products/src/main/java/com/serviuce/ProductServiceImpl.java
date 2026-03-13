package com.serviuce;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.ProductRequestDto;
import com.dto.ProductResponceDto;
import com.model.Products;
import com.repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService
{
	@Autowired
	ProductRepository productRepository;

	@Override
	public ProductResponceDto save(ProductRequestDto productRequestDto) {
		Products products=new Products();//The object is used for set the details of products 
		
		products.setProductName(productRequestDto.getProductName());
		products.setPrice(productRequestDto.getPrice());
		products.setDiscount(productRequestDto.getDiscount());
		products.setAvaialable(true);
		products.setStock(productRequestDto.getStock());
		Products savedProducts = productRepository.save(products);//set and get Products details after save the product details in database using Repository
	    ProductResponceDto productResponceDto=new ProductResponceDto();
	    BeanUtils.copyProperties(savedProducts, productResponceDto);
		
		return productResponceDto;
	}

	@Override
	public ProductResponceDto findId(Long id) {
		Products products = productRepository.findById(id).get();
		ProductResponceDto dto=new ProductResponceDto();
		BeanUtils.copyProperties(products, dto);
		return dto;
	}

	@Override
	public List<ProductResponceDto> search() 
	{
		List<Products> all = productRepository.findAll();
		List<ProductResponceDto> dto=new ArrayList<>();
		for(Products products :all)
		{
			ProductResponceDto responce=new ProductResponceDto();
		BeanUtils.copyProperties(products,responce);
		dto.add(responce);
		}
		return dto ;
	}

	@Override
	public ProductResponceDto updateRating(long id, double rating) {
		Products products = productRepository.findById(id).get();
		products.setRating(rating);
		Products save = productRepository.save(products);
		ProductResponceDto dto=new ProductResponceDto();
		BeanUtils.copyProperties(save, dto);
		return dto;
	}

	@Override
	public List<ProductResponceDto> priceFillter(double price) {
		List<Products> greaterThan = productRepository.findByPriceGreaterThan(price);
		List<ProductResponceDto> dto=new ArrayList<>();
		for(Products products : greaterThan)
		{
			ProductResponceDto productResponceDto=new ProductResponceDto();
			BeanUtils.copyProperties(products,productResponceDto);
			dto.add(productResponceDto);
			
		}
		
		return dto;
	}

	@Override
	public List<ProductResponceDto> findName(String productName) 
	{
		List<Products> containing = productRepository.findByProductNameContaining(productName);
		List<ProductResponceDto> dto=new ArrayList<>();
		for(Products products :containing)
		{
			ProductResponceDto productResponceDto=new ProductResponceDto();
			BeanUtils.copyProperties(products,productResponceDto);
			dto.add(productResponceDto);
			
		}
		
		return dto;
	}

	@Override
	public List<ProductResponceDto> findIds(List<Long> ids) {
		List<Products> allById = productRepository.findAllById(ids);
		List<ProductResponceDto> dto=new ArrayList<>();
		for(Products products :allById)
		{
			ProductResponceDto productResponceDto=new ProductResponceDto();
			BeanUtils.copyProperties(products,productResponceDto);
			dto.add(productResponceDto);
			
		}
		
		return dto;
	}
}
	


