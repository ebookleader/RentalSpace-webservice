package com.webservice.rentalSpace.web.dto;

import com.webservice.rentalSpace.domain.products.Products;
import lombok.Getter;

@Getter
public class ProductsResponseDto {
    private Long p_id;
    private String p_owner_id;
    private String p_name;
    private String p_location;
    private String p_city;
    private String p_category;
    private int p_weekdayPrice;
    private int p_weekendPrice;
    private String p_introduce;
    private String p_facility;
    private String p_notice;
    private String p_policy;
    private int p_maxNum;
    private int p_liked;
    private double p_avgRating;

    public ProductsResponseDto(Products entity) {
        this.p_id = entity.getP_id();
        this.p_owner_id = entity.getP_owner_id();
        this.p_name = entity.getP_name();
        this.p_location = entity.getP_location();
        this.p_city = entity.getP_city();
        this.p_category = entity.getP_category();
        this.p_weekdayPrice = entity.getP_weekdayPrice();
        this.p_weekendPrice = entity.getP_weekendPrice();
        this.p_introduce = entity.getP_introduce();
        this.p_facility = entity.getP_facility();
        this.p_notice = entity.getP_notice();
        this.p_policy = entity.getP_policy();
        this.p_maxNum = entity.getP_maxNum();
        this.p_liked = entity.getP_liked();
        this.p_avgRating = entity.getP_avgRating();
    }
}
