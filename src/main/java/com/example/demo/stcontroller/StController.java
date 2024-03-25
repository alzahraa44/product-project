package com.example.demo.stcontroller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.database.entity.Category;
import com.example.demo.database.entity.Product;
import com.example.demo.database.entity.ProductDTO;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;

@Controller
public class StController {
	public static String uploadDir = System.getProperty("user.dir") + "/src/main/resource/static/productImages";
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;

	@GetMapping("admin")
	public String admin() {
		return "adminHome";
	}

	@GetMapping("/admin/categories")
	public String adminCategories(Model model) {
		model.addAttribute("categories", categoryService.findallCat());
		return "categories";
	}

	@GetMapping("/admin/categories/add")
	public String grtCatAdd(Model model) {
		model.addAttribute("category", new Category());
		return "categoriesAdd";

	}

	@PostMapping("/admin/categories/add")
	public String possstcat(@ModelAttribute("category") Category category) {
		categoryService.addCatego(category);
		return "adminHome";
	}

	@GetMapping("/admin/categories/delete/{id}")
	public String delete(@PathVariable Integer id) {
		categoryService.deleteCategobyid(id);
		return "redirect:/admin/categories";

	}

	@GetMapping("/admin/categories/update/{id}")
	public String update(@PathVariable Integer id, Model model) {

		model.addAttribute("category", categoryService.getCategobyid(id));
		return "categoriesAdd";

	}

	@PostMapping("/admin/categories/update/{id}")
	public String postupdateCat(@ModelAttribute("category") Category category, @PathVariable Integer id) {
		Category exitingCategory = new Category(id);
		exitingCategory.setName(category.getName());
		categoryService.addCatego(exitingCategory);
		return "redirect:/admin/categories";
	}

	// product section
	@GetMapping("/admin/products")
	public String showallproduct(Model model) {
		model.addAttribute("products", productService.getAllProduct());

		return "products";
	}

	@GetMapping("/admin/products/add")
	public String adddproduct(Model model) {
		model.addAttribute("productDTO", new ProductDTO());
		model.addAttribute("categories", categoryService.findallCat());
		return "productsAdd";
	}

	@PostMapping("/admin/products/add")
	public String saveeProduct(@ModelAttribute("productDTO") ProductDTO productDTO,
			@RequestParam("productImage") MultipartFile file, @RequestParam("imgName") String imgName)
			throws IOException {
		Product product = new Product();
		product.setId(productDTO.getId());
		product.setName(productDTO.getName());
		product.setPrice(productDTO.getPrice());
		product.setDescription(productDTO.getDescription());
		product.setWeight(productDTO.getWeight());
		product.setCategory(categoryService.getCategobyid(productDTO.getCategoryId()));
		String imageUUID;
		if (!file.isEmpty()) {
			imageUUID = file.getOriginalFilename();
			java.nio.file.Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
			Files.write(fileNameAndPath, file.getBytes());
			// Files.write(fileNameAndPath,file.getBytes());
		} else {
			imageUUID = imgName;
		}
		product.setImageName(imageUUID);
		productService.saveProductt(product);
		return "redirect:/admin/products";

	}

	@GetMapping("/admin/product/delete/{id}")
	public String deletteproduct(@PathVariable Long id) {
		productService.deletesbyid(id);
		return "products";
	}

	@GetMapping("/admin/product/update/{id}")
	public String updatee(Model model, @PathVariable Long id) {
		Product product = productService.getProductById(id);
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setName(product.getName());
		productDTO.setPrice(product.getPrice());
		productDTO.setDescription(product.getDescription());
		productDTO.setWeight(product.getWeight());
		productDTO.setImageName(product.getImageName());
		productDTO.setCategoryId(product.getCategory().getId());
		model.addAttribute("productDTO", productDTO);
		model.addAttribute("category", categoryService.findallCat());

		return "productsAdd";
	}

	
	
}