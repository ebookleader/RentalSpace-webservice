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
    private String p_facility;
    private String p_notice;
    private String p_policy;
    private int p_maxNum;
    private int p_liked;
    private double p_avgRating;

    @Builder
    public ProductsUpdateRequestDto(String p_name, String p_location, String p_city, String p_category, int p_weekdayPrice, int p_weekendPrice,
                                  String p_introduce, String p_facility, String p_notice, String p_policy, int p_maxNum, int p_liked, double p_avgRating
    ) {
        this.p_name = p_name;
        this.p_location = p_location;
        this.p_city = p_city;
        this.p_category = p_category;
        this.p_weekdayPrice = p_weekdayPrice;
        this.p_weekendPrice = p_weekendPrice;
        this.p_introduce = p_introduce;
        this.p_facility = p_facility;
        this.p_notice = p_notice;
        this.p_policy = p_policy;
        this.p_maxNum = p_maxNum;
        this.p_liked = p_liked;
        this.p_avgRating = p_avgRating;
    }
}
