package com.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.Product;
import com.springboot.repository.ProductRepository;

@Service
public class ProductService 
{
	@Autowired
	ProductRepository productRepository;
	
	// get all
	public List<Product> getProducts()
	{
		List<Product> product = new ArrayList<Product>();
		productRepository.findAll().forEach(product1 -> product.add(product1));
		return product;
	}
	
	// create
	public void save(Product product)
	{
		productRepository.save(product);
	}
	
	// getById
	public Product getProductById(int id)
	{
		return productRepository.findById(id).get();
	}
	
	// updateById
	public void update(Product product, int id)
	{
		productRepository.save(product);
	}
	
	// deleteById
	public void delete(int id)
	{
		productRepository.deleteById(id);
	}
}
