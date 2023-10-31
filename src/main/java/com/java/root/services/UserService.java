package com.java.root.services;

import java.util.ArrayList;
import java.util.List;

import com.java.root.entities.Category;
import com.java.root.payloads.UserDto;
import com.java.root.repositories.CategoryRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UserService {
	@Autowired
	private CategoryRepo categoryRepo;
	public List<Category> getAllUsers() {
		
		List<Category> categories = this.categoryRepo.findAll();



		return categories;
	}

}
