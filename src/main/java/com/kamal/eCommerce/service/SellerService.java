package com.kamal.eCommerce.service;

import com.kamal.eCommerce.model.Seller;
import com.kamal.eCommerce.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for handling seller operations.
 */
@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    /**
     * Register a new seller.
     */
    public Seller registerSeller(Seller seller) {
        return sellerRepository.save(seller);
    }
}
