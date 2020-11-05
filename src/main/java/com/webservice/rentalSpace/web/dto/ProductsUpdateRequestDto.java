package com.webservice.rentalSpace.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductsUpdateRequestDto {

    private String p_name;
    private String p_location;
    private String p_city;
    private String p_category;
    private int p_weekdayPrice;
    private int p_weekendPrice;
    private String p_introduce;
    private String p_facility1;
    private String p_facility2;
    private String p_facility3;
    private String p_facility4;
    private String p_facility5;
    private String p_facility6;
    private String p_facility7;
    private String p_facility8;
    private String p_facility9;
    private String p_facility10;
    private String p_notice;
    private String p_policy;
    private int p_maxNum;
    private int p_liked;
    private double p_avgRating;

    @Builder
    public ProductsUpdateRequestDto(String p_name, String p_location, String p_city, String p_category, int p_weekdayPrice, int p_weekendPrice,
                                  String p_introduce, String p_facility1, String p_facility2, String p_facility3, String p_facility4,
                                    String p_facility5, String p_facility6, String p_facility7, String p_facility8, String p_facility9, String p_facility10, String p_notice, String p_policy, int p_maxNum, int p_liked, double p_avgRating
    ) {
        this.p_name = p_name;
        this.p_location = p_location;
        this.p_city = p_city;
        this.p_category = p_category;
        this.p_weekdayPrice = p_weekdayPrice;
        this.p_weekendPrice = p_weekendPrice;
        this.p_introduce = p_introduce;
        this.p_facility1 = p_facility1;
        this.p_facility2 = p_facility2;
        this.p_facility3 = p_facility3;
        this.p_facility4 = p_facility4;
        this.p_facility5 = p_facility5;
        this.p_facility6 = p_facility6;
        this.p_facility7 = p_facility7;
        this.p_facility8 = p_facility8;
        this.p_facility9 = p_facility9;
        this.p_facility10 = p_facility10;
        this.p_notice = p_notice;
        this.p_policy = p_policy;
        this.p_maxNum = p_maxNum;
        this.p_liked = p_liked;
        this.p_avgRating = p_avgRating;
    }
}
