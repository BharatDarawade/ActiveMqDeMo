package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductRespository;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ProductNotFound;
import com.example.demo.model.Product;

@Service
public class ProductService {

	@Autowired
	ProductRespository productRespository;
	
	public Optional<Product> getProduct(Long id) {
		
		return productRespository.findById(id);
	}
	
	public void save(Product product) {
		try {
		productRespository.save(product);
		}
		catch(Exception ex) {
			throw new BadRequestException(ex.getLocalizedMessage());
		}
		
	}
	
	public void deleteProduct(Long id) {
		
		productRespository.deleteById(id);
	}
	
	public void updateProduct(Long id,Product product) {
		
		if(productRespository.findById(id).isPresent()) {
			productRespository.save(product);
		}
		else {
				throw new ProductNotFound("Product not found");
			
			

		}
		
	}
}
