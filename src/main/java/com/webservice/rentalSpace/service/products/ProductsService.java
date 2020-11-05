package com.webservice.rentalSpace.service.products;

import com.webservice.rentalSpace.domain.products.Products;
import com.webservice.rentalSpace.domain.products.ProductsRepository;
import com.webservice.rentalSpace.web.dto.ProductsListResponseDto;
import com.webservice.rentalSpace.web.dto.ProductsResponseDto;
import com.webservice.rentalSpace.web.dto.ProductsSaveRequestDto;
import com.webservice.rentalSpace.web.dto.ProductsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductsService {
    private final ProductsRepository productsRepository;

    @Transactional
    public Long save(ProductsSaveRequestDto requestDto) {
        return productsRepository.save(requestDto.toEntity()).getP_id();
    }

    @Transactional
    public Long update(Long id, ProductsUpdateRequestDto requestDto) {
        Products products = productsRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("There is no products which id="+id)
        );

        products.update(requestDto.getP_name(), requestDto.getP_location(), requestDto.getP_city(), requestDto.getP_category(), requestDto.getP_weekdayPrice(), requestDto.getP_weekendPrice(),
        requestDto.getP_introduce(), requestDto.getP_facility1(), requestDto.getP_facility2(), requestDto.getP_facility3(), requestDto.getP_facility4(),
                requestDto.getP_facility5(), requestDto.getP_facility6(), requestDto.getP_facility7(), requestDto.getP_facility8(), requestDto.getP_facility9(), requestDto.getP_facility10(), requestDto.getP_notice(), requestDto.getP_policy(), requestDto.getP_maxNum(), requestDto.getP_liked(), requestDto.getP_avgRating());

        return id;
    }

    public ProductsResponseDto findById(Long id) {
        Products entity = productsRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("There is no products which id="+id)
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
