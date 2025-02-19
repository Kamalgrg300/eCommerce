package com.kamal.eCommerce.controller;

import com.kamal.eCommerce.model.Product;
import com.kamal.eCommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	// Get all products (browse)
	@GetMapping
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	// Search products by name (Fixed method name to match service)
	@GetMapping("/search")
	public List<Product> searchProduct(@RequestParam String name) {
		return productService.searchProduct(name); // Ensure method exists in ProductService
	}

	// Get product details by ID (Fixed method name)
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Long id) {
		return productService.getProductById(id); // Ensure method exists in ProductService
	}

	// Seller adds a product (Fixed method name)
	@PostMapping("/add")
	public String addProduct(@RequestBody Product product, @RequestParam String sellerEmail) {
		return productService.addProduct(product, sellerEmail); // Ensure method exists in ProductService
	}

	// Seller updates a product (Fixed method name)
	@PutMapping("/update/{id}")
	public String updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct,
			@RequestParam String sellerEmail) {
		return productService.updateProduct(id, updatedProduct, sellerEmail); // Ensure method exists in ProductService
	}

	// Seller deletes a product (Fixed method name)
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable Long id, @RequestParam String sellerEmail) {
		return productService.deleteProduct(id, sellerEmail); // Ensure method exists in ProductService
	}
}
