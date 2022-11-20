package com.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.Category;
import com.springboot.repository.CategoryRepository;

@Service
public class CategoryService 
{
	@Autowired
	CategoryRepository categoryRepository;
	
	// get all
	public List<Category> getCategories()
	{
		List<Category> category = new ArrayList<Category>();
		categoryRepository.findAll().forEach(category1 -> category.add(category1));
		return category;
	}
	
	// create
	public void save(Category category)
	{
		categoryRepository.save(category);
	}
	
	// getById
	public Category getCategoryById(int id)
	{
		return categoryRepository.findById(id).get();
	}
	
	// updateById
	public void update(Category category, int id)
	{
		categoryRepository.save(category);
	}
	
	// deleteById
	public void delete(int id)
	{
		categoryRepository.deleteById(id);
	}
}
