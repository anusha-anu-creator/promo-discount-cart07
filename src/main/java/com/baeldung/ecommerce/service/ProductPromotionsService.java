package com.baeldung.ecommerce.service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.baeldung.ecommerce.model.ProductPromotions;

public interface ProductPromotionsService {
    @NotNull Iterable<ProductPromotions> getAllProductPromotions();

    ProductPromotions getProductPromotions(@Min(value = 1L, message = "Invalid productPromotion ID.") long id);

    ProductPromotions save(ProductPromotions productPromotions);
}
