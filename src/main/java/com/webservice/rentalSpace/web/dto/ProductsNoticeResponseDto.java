package com.webservice.rentalSpace.web.dto;

import com.webservice.rentalSpace.domain.products.ProductsNotice;
import lombok.Getter;

@Getter
public class ProductsNoticeResponseDto {
    private Long pn_id;
    private String p_notice;

    public ProductsNoticeResponseDto(ProductsNotice entity) {
        this.pn_id = entity.getPn_id();
        this.p_notice = entity.getP_notice();
    }
}
