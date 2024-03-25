package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.database.entity.Product;
import com.example.demo.database.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;

	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	public Product getProductById(Long id) {
		return productRepository.findById(id).get();
	}

	public void saveProductt(Product product) {
		productRepository.save(product);
	}
	
	public void deletesbyid(Long id) {
		productRepository.deleteById(id);
	}
//	public Product getProductById(Long id) {
//		return productRepository.findById(id).get();
//	}
	
	public List<Product> getAllProductsByCategoryId(int id){
		return productRepository.findAllByCategoryId(id);
	}
}
