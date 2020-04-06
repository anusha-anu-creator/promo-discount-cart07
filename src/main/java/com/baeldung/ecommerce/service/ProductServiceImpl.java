package com.baeldung.ecommerce.service;

import com.baeldung.ecommerce.exception.ResourceNotFoundException;
import com.baeldung.ecommerce.model.Product;
import com.baeldung.ecommerce.model.ProductPromotions;
import com.baeldung.ecommerce.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    
    @Autowired
    private ProductPromotionsService productPromotionsService;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(long id) {
        return productRepository
          .findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }
    
    @Override
    public void loadInitialPromotions() {
        productPromotionsService.save(new ProductPromotions(1L, 1L, 3, 130.00));
        productPromotionsService.save(new ProductPromotions(2L, 2L, 2, 45.00));
    }
}
