package com.webservice.rentalSpace.service.products;

import com.webservice.rentalSpace.domain.products.*;
import com.webservice.rentalSpace.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductsService {
    private final ProductsRepository productsRepository;
    private final ProductsFacilityRepository productsFacilityRepository;
    private final ProductsNoticeRepository productsNoticeRepository;
    private final ProductsPolicyRepository productsPolicyRepository;

    @Transactional
    public Long save(ProductsSaveRequestDto requestDto) {
        Products products = requestDto.toEntity();
        productsRepository.save(products);
        List<String> facilities = requestDto.getFacility();
        for(String fac : facilities) {
            ProductsFacility f = ProductsFacility.builder()
                    .p_facility(fac)
                    .products(products)
                    .build();
            productsFacilityRepository.save(f);
        }
        List<String> notices = requestDto.getNotice();
        for(String pno : notices) {
            ProductsNotice pn = ProductsNotice.builder()
                    .p_notice(pno)
                    .products(products)
                    .build();
            productsNoticeRepository.save(pn);
        }
        List<String> policies = requestDto.getPolicy();
        for(String pol : policies) {
            ProductsPolicy p = ProductsPolicy.builder()
                    .p_policy(pol)
                    .products(products)
                    .build();
            productsPolicyRepository.save(p);
        }
        return products.getP_id();
    }

    @Transactional(readOnly = true)
    public ProductsResponseDto findById(Long id) {
        Products entity = productsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("There is no product which id=" + id)
        );
        return new ProductsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<FacilityResponseDto> findProductsFacilityById(Long id) {
        return productsFacilityRepository.findProductsFacility(id).stream()
                .map(FacilityResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ProductsNoticeResponseDto> findProductsNoticeById(Long id) {
        return productsNoticeRepository.findProductsNotice(id).stream()
                .map(ProductsNoticeResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ProductsPolicyResponseDto> findProductsPolicyById(Long id) {
        return productsPolicyRepository.findProductsPolicy(id).stream()
                .map(ProductsPolicyResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ProductsListResponseDto> findAllDesc() {
        return productsRepository.findAllDesc().stream()
                .map(ProductsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ProductsListResponseDto> findAllByCategory(String category) {
        return productsRepository.findAllByCategory(category).stream()
                .map(ProductsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ProductsListResponseDto> findAllByCity(String city) {
        return productsRepository.findAllByCity(city).stream()
                .map(ProductsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ProductsListResponseDto> findAllByPrice(int min, int max) {
        return productsRepository.findAllByPrice(min, max).stream()
                .map(ProductsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ProductsListResponseDto> findAllByPriceLast(int max) {
        return productsRepository.findAllByPriceLast(max).stream()
                .map(ProductsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ProductsListResponseDto> findAllByRating(double rating) {
        return productsRepository.findAllByRating(rating, rating+1.0).stream()
                .map(ProductsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteSpace(Long id) {
        Products products = productsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("There is no product which id=" + id));

        productsRepository.delete(products);
    }

    @Transactional
    public Long update(Long id, ProductsUpdateRequestDto requestDto) {
        Products products = productsRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("There is no products which id="+id)
        );

        products.update(requestDto.getP_name(), requestDto.getP_location(), requestDto.getP_city(), requestDto.getP_category(),
                requestDto.getP_weekdayPrice(), requestDto.getP_weekendPrice(), requestDto.getP_introduce(), requestDto.getP_maxNum());

        productsFacilityRepository.deleteProductsFacility(id);
        productsNoticeRepository.deleteProductsNotice(id);
        productsPolicyRepository.deleteProductsPolicy(id);

        List<String> facilities = requestDto.getFacility();
        for(String f : facilities) {
            ProductsFacility pf = ProductsFacility.builder()
                    .p_facility(f)
                    .products(products)
                    .build();
            productsFacilityRepository.save(pf);
        }

        List<String> notices = requestDto.getNotice();
        for(String pno : notices) {
            ProductsNotice pn = ProductsNotice.builder()
                    .p_notice(pno)
                    .products(products)
                    .build();
            productsNoticeRepository.save(pn);
        }

        List<String> policies = requestDto.getPolicy();
        for(String pol : policies) {
            ProductsPolicy p = ProductsPolicy.builder()
                    .p_policy(pol)
                    .products(products)
                    .build();
            productsPolicyRepository.save(p);
        }
        return id;
    }

    // sidebar 관련
    @Transactional(readOnly = true)
    public int findEachNumByCity(String p_city) {
        return productsRepository.findEachNumByCity(p_city);
    }

    @Transactional(readOnly = true)
    public int findEachNumByCategory(String p_category) {
        return productsRepository.findEachNumByCategory(p_category);
    }

    @Transactional(readOnly = true)
    public int findEachNumByPrice(int min, int max) {
        return productsRepository.findEachNumByPrice(min, max);
    }

    @Transactional(readOnly = true)
    public int findEachNumByPriceMax(int max) {
        return productsRepository.findEachNumByPriceLast(max);
    }

    @Transactional(readOnly = true)
    public int findEachNumByRating(double p_avgRating) {
        return productsRepository.findEachNumByRating(p_avgRating, p_avgRating+1.0);

    }



}
