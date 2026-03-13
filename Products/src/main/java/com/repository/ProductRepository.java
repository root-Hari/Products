package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Products;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long>
//The Jpa repository is Interface having in built CRUd operations the Products=Entity&Long is primary key
{
	public List<Products> findByPriceGreaterThan(double price);
	public List<Products> findByProductNameContaining(String productName);
	

}
