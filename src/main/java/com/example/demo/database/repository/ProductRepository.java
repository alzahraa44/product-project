package com.example.demo.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.database.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
List<Product> findAllByCategoryId(int id);
}

