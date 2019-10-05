package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ProductNotFound;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

	@Autowired
	ProductService service;

	@GetMapping("/{id}")
	public ResponseEntity<Object>  getProduct(@PathVariable Long id) throws ProductNotFound{
		Optional<Product> product=service.getProduct(id);
		
		if(!product.isPresent()) {
			throw new ProductNotFound("Product not found");
		}
		

		return new ResponseEntity<>( product,HttpStatus.OK);
	}
	
	@PostMapping("/createProduct")
	public ResponseEntity<Object> saveProduct(@RequestBody Product product) {
		service.save(product);
			
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Object> patchProduct(@RequestBody Product product,@PathVariable Long id) {
		service.updateProduct(id,product);
			
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> removeProduct(@PathVariable Long id) {
		service.deleteProduct(id);
			
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
