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
    private int p_maxNum;

    @Builder
    public ProductsUpdateRequestDto(String p_name, String p_location, String p_city, String p_category, int p_weekdayPrice, int p_weekendPrice,
                                  String p_introduce,int p_maxNum
    ) {
        this.p_name = p_name;
        this.p_location = p_location;
        this.p_city = p_city;
        this.p_category = p_category;
        this.p_weekdayPrice = p_weekdayPrice;
        this.p_weekendPrice = p_weekendPrice;
        this.p_introduce = p_introduce;
        this.p_maxNum = p_maxNum;
    }
}
