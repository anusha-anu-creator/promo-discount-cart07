package com.baeldung.ecommerce.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class ProductPromotions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Product id is required.")
    @Basic(optional = false)
    private Long productId;
    
    private Integer quantity;

	private Double promoPrice;
	
	public ProductPromotions() {
		
	}

    public ProductPromotions(Long id, @NotNull(message = "Product id is required.") Long productId, Integer quantity, Double promoPrice) {
        this.id = id;
        this.productId = productId;
        this.promoPrice = promoPrice;
        this.quantity = quantity;
    }
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPromoPrice() {
		return promoPrice;
	}

	public void setPromoPrice(Double promoPrice) {
		this.promoPrice = promoPrice;
	}

}
