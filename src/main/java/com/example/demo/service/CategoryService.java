package com.example.demo.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.example.demo.database.entity.Category;
import com.example.demo.database.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
	
	private final CategoryRepository categoryRepository ;

    CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

	public List<Category> findallCat() {
		return categoryRepository.findAll();
	}

	public Category addCatego(Category category) {
		 return categoryRepository.save(category);
	}

//	public Category getCategobyid(Integer id) {
//		 return categoryRepository.findById(id).get();
//	}

	public void deleteCategobyid(Integer id) {
		  categoryRepository.deleteById(id);
	}

	public Category getCategobyid(Integer id) {
		return categoryRepository.findById(id).get(); 
	}
}
