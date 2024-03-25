package com.example.demo.stcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import org.springframework.ui.Model;

@Controller
public class HomeController {
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;

	@GetMapping({ "/", "/home" })
	public String homepage(Module model) {
		return "index";
	}

	@GetMapping("/shope")
	public String shopepage(Model model) {
		model.addAttribute("categories", categoryService.findallCat());
		model.addAttribute("products", productService.getAllProduct());
		return "shope";
	}

	@GetMapping("/shop/category/{id}")
	public String shopbycategory(@PathVariable int id, Model model) {

		model.addAttribute("categories", categoryService.findallCat());
		model.addAttribute("products", productService.getAllProductsByCategoryId(id));
		return "shop";
	}

	@GetMapping("/shop/viewproduct/{id}")
	public String shopviewproduct(@PathVariable Long id, Model model) {

		model.addAttribute("product", productService.getProductById(id));
		return "viewProduct";
	}

}