package com.kamal.eCommerce.controller;

import com.kamal.eCommerce.model.Seller;
import com.kamal.eCommerce.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for seller operations.
 */
@RestController
@RequestMapping("/sellers")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    /**
     * Register a new seller.
     */
    @PostMapping("/register")
    public Seller registerSeller(@RequestBody Seller seller) {
        return sellerService.registerSeller(seller);
    }
}
