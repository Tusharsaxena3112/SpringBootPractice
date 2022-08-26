package com.spring.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.crud.model.Product;
import com.spring.crud.service.ProductService;

@RestController
public class HomeController {
	
	@Autowired
	private ProductService productService;
	
	@PreAuthorize("hasAuthority('MANAGER')")
	@GetMapping("/products")
	public @ResponseBody List<Product> getAllProducts(){
		return productService.getProducts();
	}
	
	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable int id) {
		return productService.getProduct(id);
	}
	
	@PostMapping("/product")
	public @ResponseBody Product addProduct(@RequestBody Product product) {
		
		return productService.addProduct(product);
	}
	
	@PutMapping("/products/{id}")
	public @ResponseBody Product updateProduct(@PathVariable int id, @RequestBody Product product) {
		return productService.updateProduct(id, product);
	}
}
