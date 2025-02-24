package com.kamal.eCommerce.controller;

import com.kamal.eCommerce.model.Product;
import com.kamal.eCommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controller for product operations.
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * Get all products.
     */
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    /**
     * Search products by name.
     */
    @GetMapping("/search")
    public List<Product> searchProduct(@RequestParam String name) {
        return productService.searchProduct(name);
    }

    /**
     * Get product details by ID.
     */
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    /**
     * Seller adds a product.
     */
    @PostMapping("/add")
    public String addProduct(@RequestBody Product product, @RequestParam String sellerEmail) {
        return productService.addProduct(product, sellerEmail);
    }

    /**
     * Seller updates a product.
     */
    @PutMapping("/update/{id}")
    public String updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct,
                                @RequestParam String sellerEmail) {
        return productService.updateProduct(id, updatedProduct, sellerEmail);
    }

    /**
     * Seller deletes a product.
     */
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id, @RequestParam String sellerEmail) {
        return productService.deleteProduct(id, sellerEmail);
    }
}
