package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.Product;
import com.springboot.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController 
{
	@Autowired
	ProductService productService;
	
	// getAll
	@GetMapping
	private List<Product> getProducts()
	{
		return productService.getProducts();
	}
		
	// create
	@PostMapping
	private int createProduct(@RequestBody Product product)
	{
		productService.save(product);
		return product.getId();
	}
		
	// getById
	@GetMapping("/{id}")
	private Product getProduct(@PathVariable(value = "id")int id) 
	{
		return productService.getProductById(id);
	}
		
	// updateById
	@PutMapping("/{id}")
	private Product update(@PathVariable(value = "id")int id,@RequestBody Product product)
	{
		productService.update(product, id);
			
		return product;
	}
		
	// deleteById
	@DeleteMapping("/{id}")
	private void deleteProduct(@PathVariable(value = "id")int id)
	{
		productService.delete(id);
	}
}
