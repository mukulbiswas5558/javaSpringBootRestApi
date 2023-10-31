package com.java.root.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.root.entities.Category;
import com.java.root.payloads.ApiResponse;
import com.java.root.services.CategoryService;
@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	@PostMapping("/")
	public ResponseEntity<Category> createCategory(@RequestBody Category category) {
		Category createCategory = this.categoryService.createCategory(category);
		return new ResponseEntity<Category>(createCategory, HttpStatus.CREATED);
	}

	// update

	@PutMapping("/{catId}")
	public ResponseEntity<Category> updateCategory(@RequestBody Category category,
			@PathVariable Integer catId) {
		Category updatedCategory = this.categoryService.updateCategory(category, catId);
		return new ResponseEntity<Category>(updatedCategory, HttpStatus.OK);
	}

	// delete

	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId) {
		this.categoryService.deleteCategory(catId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("category is deleted successfully !!", true),
				HttpStatus.OK);
	}
	// get

	@GetMapping("/{catId}")
	public ResponseEntity<Category> getCategory(@PathVariable Integer catId) {

		Category categoryDto = this.categoryService.getCategory(catId);

		return new ResponseEntity<Category>(categoryDto, HttpStatus.OK);

	}

	// get all
	@GetMapping("/")
	public ResponseEntity<List<Category>> getCategories() {
		List<Category> categories = this.categoryService.getCategories();
		return ResponseEntity.ok(categories);
	}

}
