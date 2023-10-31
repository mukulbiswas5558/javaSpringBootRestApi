package com.java.root.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.root.entities.Category;
import com.java.root.exceptions.ResourceNotFoundException;
import com.java.root.repositories.CategoryRepo;

@Service

public class CategoryService {
	@Autowired
	private CategoryRepo categoryRepo;
	public Category createCategory(Category category) {
		
		Category addedCat = this.categoryRepo.save(category);
		return addedCat;
	}

	public Category updateCategory(Category category, Integer categoryId) {

		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "category id", categoryId));

		cat.setTitle(category.getTitle());
		cat.setDescription(category.getDescription());

		Category updatedcat = this.categoryRepo.save(cat);

		return updatedcat;
	}

	public void deleteCategory(Integer categoryId) {

		Category cat = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category ", "category id", categoryId));
		this.categoryRepo.delete(cat);
	}

	public Category getCategory(Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "category id", categoryId));

		return cat;
	}

	public List<Category> getCategories() {

		List<Category> categories = this.categoryRepo.findAll();
		

		return categories;
	}
	

}
