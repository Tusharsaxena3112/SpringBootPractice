package com.spring.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.crud.exceptions.NotFoundException;
import com.spring.crud.model.Product;
import com.spring.crud.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getProducts(){
		return productRepository.findAll();
	}
	
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}
	
	public Product getProduct(int id) {
		Product existingProduct = productRepository.findById(id).orElse(null);
		if (existingProduct == null) {
			throw new NotFoundException("Product Not Found");
		}
		return existingProduct;
	}
	
	public Product updateProduct(int id,Product newProduct) {
		Product existingProduct = productRepository.findById(id).orElse(null);
		existingProduct.setName(newProduct.getName());
		existingProduct.setDescription(newProduct.getDescription());
		existingProduct.setPrice(newProduct.getPrice());
		return productRepository.save(existingProduct);
	}
}
