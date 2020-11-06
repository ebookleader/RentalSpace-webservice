package com.webservice.rentalSpace.service.products;

import com.webservice.rentalSpace.domain.products.Facility;
import com.webservice.rentalSpace.domain.products.FacilityRepository;
import com.webservice.rentalSpace.domain.products.Products;
import com.webservice.rentalSpace.domain.products.ProductsRepository;
import com.webservice.rentalSpace.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductsService {
    private final ProductsRepository productsRepository;
    private final FacilityRepository facilityRepository;

//    @Transactional
//    public Long facility_save(ProductsSaveRequestDto requestDto, Long p_id) {
//        return facilityRepository.save(requestDto.toFacilityEntity()).getFid();
//    }

    @Transactional
    public Long save(ProductsSaveRequestDto requestDto) {
        System.out.println(">>>>>>>> save function <<<<<<<<<<<");
        Products products = requestDto.toEntity();
        return products.getP_id();
//        return productsRepository.save(products).getP_id();
    }

    public Facility addFacility(String facility, Products products) {
        System.out.println(">>>>>>>> addFacility function <<<<<<<<<<<");
        Facility fa = Facility.builder()
                .facility(facility)
                .products(products)
                .build();
        facilityRepository.save(fa);
        return fa;
    }

//    @Transactional
//    public Long update(Long id, ProductsUpdateRequestDto requestDto) {
//        Products products = productsRepository.findById(id).orElseThrow(
//                ()->new IllegalArgumentException("There is no products which id="+id)
//        );
//
//        products.update(requestDto.getP_name(), requestDto.getP_location(), requestDto.getP_city(), requestDto.getP_category(), requestDto.getP_weekdayPrice(), requestDto.getP_weekendPrice(),
//        requestDto.getP_introduce(), requestDto.getP_facility1(), requestDto.getP_facility2(), requestDto.getP_facility3(), requestDto.getP_facility4(),
//                requestDto.getP_facility5(), requestDto.getP_facility6(), requestDto.getP_facility7(), requestDto.getP_facility8(), requestDto.getP_facility9(), requestDto.getP_facility10(), requestDto.getP_notice(), requestDto.getP_policy(), requestDto.getP_maxNum(), requestDto.getP_liked(), requestDto.getP_avgRating());
//
//        return id;
//    }

    public ProductsResponseDto findById(Long id) {
        Products entity = productsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("There is no products which id=" + id)
        );

        return new ProductsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<ProductsListResponseDto> findAllDesc() {
        return productsRepository.findAllDesc().stream()
                .map(ProductsListResponseDto::new)
                .collect(Collectors.toList());
    }

}
