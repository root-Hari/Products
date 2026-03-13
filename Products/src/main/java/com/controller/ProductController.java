package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.dto.ProductRequestDto;
import com.dto.ProductResponceDto;
import com.serviuce.ProductService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/products")
public class ProductController 
{
	
	@Autowired
	//@Autowirde is used for injecting the ProductService Bean in controller class
	ProductService productService;
	
	@PostMapping("/Add")
	//The post meto0de is used to save the details in database And the @requestBody is used for convert Json to Java object
	public ProductResponceDto productSave(@RequestBody ProductRequestDto productRequestDto)
	{
		return productService.save(productRequestDto);
	}
	@GetMapping("/id/{id}")
	public ProductResponceDto findId(@PathVariable Long id)
	{
		return productService.findId(id);
		
	}
	@GetMapping("/findAll")
	public List<ProductResponceDto>findAll()
	{
		return productService.search();
	}
	
	@PostMapping("/update")
	public ProductResponceDto update(@RequestParam Long id, double rating)
	{
		return productService.updateRating(id,rating);
	}
	
	@GetMapping("/fillterPrice")
	public List<ProductResponceDto> fillter(@RequestParam double price)
	{
		return productService.priceFillter(price);
	}
	
	@GetMapping("/myName")
	public  List<ProductResponceDto>findName(@RequestParam ("productName")String productName)
	{
		return productService.findName(productName);
	}
	
	@GetMapping("/ids")
	//This line is used to send many ids at at time
	public List<ProductResponceDto>findIds(@RequestParam List<Long> ids)
	{
		return productService.findIds(ids);
	}
	

}
