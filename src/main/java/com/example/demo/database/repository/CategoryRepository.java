package com.example.demo.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.database.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
