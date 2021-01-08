package com.webservice.rentalSpace.web.dto;

import com.webservice.rentalSpace.domain.products.ProductsOption;
import lombok.Getter;

@Getter
public class ProductsOptionResponseDto {
    private Long po_id;
    private String title;
    private int startTime;
    private int endTime;
    private int usingTime;

    public ProductsOptionResponseDto(ProductsOption option) {
        this.po_id = option.getPo_id();
        this.title = option.getOptionTitle();
        this.startTime = option.getStartTime();
        this.endTime = option.getEndTime();
        this.usingTime = option.getUsingTime();
    }
}
