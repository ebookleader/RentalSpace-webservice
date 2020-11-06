package com.webservice.rentalSpace.web;

import com.webservice.rentalSpace.domain.products.Products;
import com.webservice.rentalSpace.service.products.ProductsService;
import com.webservice.rentalSpace.web.dto.ProductsResponseDto;
import com.webservice.rentalSpace.web.dto.ProductsSaveRequestDto;
import com.webservice.rentalSpace.web.dto.ProductsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductsApiController {
    private final ProductsService productsService;

    //save
    @PostMapping("/api/v1/products")
    public Long save(@RequestBody ProductsSaveRequestDto requestDto) {
        System.out.println("call1");
        Products products = requestDto.toEntity();
        System.out.println("call2");
        for(String facility : requestDto.getFacility()) {
            products.addFacility(productsService.addFacility(facility, products));
        }
        System.out.println("call3");
        return products.getP_id();
//        return productsService.save(requestDto);
    }

    //update
//    @PutMapping("/api/v1/products/{id}")
//    public Long update(@PathVariable Long id, @RequestBody ProductsUpdateRequestDto requestDto) {
//        return productsService.update(id, requestDto);
//    }

    //조회
    @GetMapping("/api/v1/products/{id}")
    public ProductsResponseDto findById(@PathVariable Long id) {
        return productsService.findById(id);
    }
}
