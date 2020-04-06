package com.baeldung.ecommerce;

import com.baeldung.ecommerce.model.Product;
import com.baeldung.ecommerce.model.ProductPromotions;
import com.baeldung.ecommerce.service.ProductPromotionsService;
import com.baeldung.ecommerce.service.ProductService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EcommerceApplication {
	
    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ProductService productService) {
        return args -> {
            productService.save(new Product(1L, "A", 50.00, "http://placehold.it/200x100"));
            productService.save(new Product(2L, "B", 30.00, "http://placehold.it/200x100"));
            productService.save(new Product(3L, "C", 20.00, "http://placehold.it/200x100"));
            productService.save(new Product(4L, "D", 15.00, "http://placehold.it/200x100"));
            productService.loadInitialPromotions();
        };
    }
}
