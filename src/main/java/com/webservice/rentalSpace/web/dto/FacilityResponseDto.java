package com.webservice.rentalSpace.web.dto;

import com.webservice.rentalSpace.domain.products.ProductsFacility;
import lombok.Getter;

@Getter
public class FacilityResponseDto {
    private Long pf_id;
    private String p_facility;

    public FacilityResponseDto(ProductsFacility entity) {
        this.pf_id = entity.getPf_id();
        this.p_facility = entity.getP_facility();
    }
}
