package com.baeldung.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.baeldung.ecommerce.model.ProductPromotions;

public interface ProductPromotionsRepository  extends CrudRepository<ProductPromotions, Long> {

}
