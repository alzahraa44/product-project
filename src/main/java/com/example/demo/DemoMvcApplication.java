package com.example.demo;

//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//import com.example.demo.database.entity.Category;
//import com.example.demo.database.repository.CategoryRepository;

@SpringBootApplication
public class DemoMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoMvcApplication.class, args);}
}	

//	@Bean
//	CommandLineRunner inite (CategoryRepository categoryRepository) {
//		return args -> {
//			Category c1=new Category();
//		c1.setName("zahraa");
//		categoryRepository.save(c1);
//		
//		Category c2=new Category();
//		c1.setName("zahraasa");
//		categoryRepository.save(c2);
//		
//		
//		};
//	}
//}
