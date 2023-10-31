package com.java.root.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.root.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{
	

}
