package com.baeldung.ecommerce.service;

import com.baeldung.ecommerce.exception.ResourceNotFoundException;
import com.baeldung.ecommerce.model.ProductPromotions;
import com.baeldung.ecommerce.repository.ProductPromotionsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductPromotionsServiceImpl implements ProductPromotionsService {

    private ProductPromotionsRepository productPromotionsRepository;

    public ProductPromotionsServiceImpl(ProductPromotionsRepository productRepository) {
        this.productPromotionsRepository = productRepository;
    }

    @Override
    public Iterable<ProductPromotions> getAllProductPromotions() {
        return productPromotionsRepository.findAll();
    }

    @Override
    public ProductPromotions getProductPromotions(long id) {
        return productPromotionsRepository
          .findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("ProductPromotions not found"));
    }

    @Override
    public ProductPromotions save(ProductPromotions productPromotions) {
        return productPromotionsRepository.save(productPromotions);
    }
}
