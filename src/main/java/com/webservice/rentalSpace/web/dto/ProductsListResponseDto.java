package com.webservice.rentalSpace.web.dto;

import com.webservice.rentalSpace.domain.products.Products;
import lombok.Getter;

@Getter
public class ProductsListResponseDto {
    private Long p_id;
    private String p_name;
    private double p_avgRating;
    private int p_weekdayPrice;

    public ProductsListResponseDto(Products entity) {
        this.p_id = entity.getP_id();
        this.p_avgRating = entity.getP_avgRating();
        this.p_name = entity.getP_name();
        this.p_weekdayPrice = entity.getP_weekdayPrice();
    }
}
