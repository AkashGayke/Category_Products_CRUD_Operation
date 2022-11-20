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

import com.springboot.entity.Category;
import com.springboot.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController 
{
	@Autowired
	CategoryService categoryService;
	
	// getAll
	@GetMapping
	private List<Category> getCategories()
	{
		return categoryService.getCategories();
	}
	
	// create
	@PostMapping
	private int createCategory(@RequestBody Category category)
	{
		categoryService.save(category);
		return category.getId();
	}
	
	// getById
	@GetMapping("/{id}")
	private Category getCategory(@PathVariable(value = "id")int id) 
	{
		return categoryService.getCategoryById(id);
	}
	
	// updateById
	@PutMapping("/{id}")
	private Category update(@PathVariable(value = "id")int id,@RequestBody Category category)
             
	{
		categoryService.update(category, id);
		
		return category;
	}
	
	// deleteById
	@DeleteMapping("/{id}")
	private void deleteCategory(@PathVariable(value = "id")int id)
	{
		categoryService.delete(id);
	}
}
