package com.kamal.eCommerce.service;

import com.kamal.eCommerce.model.Product;
import com.kamal.eCommerce.model.Seller;
import com.kamal.eCommerce.repository.ProductRepository;
import com.kamal.eCommerce.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SellerRepository sellerRepository;

    //  Get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    //  Search products by name
    public List<Product> searchProduct(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }

    //  Get product details by ID
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    // Seller adds a product
    public String addProduct(Product product, String sellerEmail) {
        Seller seller = sellerRepository.findByEmail(sellerEmail);
        if (seller == null) {
            return "Error: Seller not found!";
        }
        product.setSeller(seller);
        productRepository.save(product);
        return "Product added successfully!";
    }

    //  Seller updates a product
    public String updateProduct(Long productId, Product updatedProduct, String sellerEmail) {
        Product existingProduct = productRepository.findById(productId).orElse(null);
        if (existingProduct == null || !existingProduct.getSeller().getEmail().equals(sellerEmail)) {
            return "Error: Product not found or unauthorized!";
        }
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setDescription(updatedProduct.getDescription());
        productRepository.save(existingProduct);
        return "Product updated successfully!";
    }

    //  Seller deletes a product
    public String deleteProduct(Long productId, String sellerEmail) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product == null || !product.getSeller().getEmail().equals(sellerEmail)) {
            return "Error: Product not found or unauthorized!";
        }
        productRepository.delete(product);
        return "Product deleted successfully!";
    }
}
