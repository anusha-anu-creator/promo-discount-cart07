package com.baeldung.ecommerce.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baeldung.ecommerce.model.Product;
import com.baeldung.ecommerce.model.ProductPromotions;
import com.baeldung.ecommerce.service.ProductPromotionsService;
import com.baeldung.ecommerce.service.ProductService;

@RestController
@RequestMapping("/api/productpromotions")
public class ProductPromotionsController {
    private ProductPromotionsService productPromotionsService;
    private ProductService productService;

    public ProductPromotionsController(ProductPromotionsService productPromotionsService, ProductService productService) {
        this.productPromotionsService = productPromotionsService;
        this.productService = productService;
    }

    @GetMapping(value = { "", "/" })
    public @NotNull Iterable<ProductPromotions> getProductPromotions() {
        return productPromotionsService.getAllProductPromotions();
    }
    
    @GetMapping(value = "/{productId}/{quantity}")
    public @NotNull Double getProductPromotions(@PathVariable Long productId, @PathVariable Integer quantity) {
        Iterable<ProductPromotions> productPromotionsIterator = productPromotionsService.getAllProductPromotions();
        Double totalPriceWithPromotion = null;
        for(ProductPromotions productPromotions : productPromotionsIterator) {
        	if(productPromotions.getProductId().equals(productId) && productPromotions.getQuantity().equals(quantity)) {
        		totalPriceWithPromotion = productPromotions.getPromoPrice();
        	}else if(productPromotions.getProductId().equals(productId) && (quantity % productPromotions.getQuantity() == 0)) {
        		int numberOfPromotions = quantity / productPromotions.getQuantity();
        		totalPriceWithPromotion = productPromotions.getPromoPrice() * numberOfPromotions;
        	}
        }
        if(totalPriceWithPromotion == null) {
        	Product product = productService.getProduct(productId);
        	totalPriceWithPromotion = product.getPrice() * quantity;
        }
        
        return totalPriceWithPromotion;
    }
}
