package com.webservice.rentalSpace.web;
import com.webservice.rentalSpace.service.products.ProductsService;
import com.webservice.rentalSpace.web.dto.ProductsResponseDto;
import com.webservice.rentalSpace.web.dto.ProductsSaveRequestDto;
import com.webservice.rentalSpace.web.dto.ProductsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class ProductsApiController {
    private final ProductsService productsService;

    //save
    @PostMapping("/api/v1/products")
    public Long save(@RequestBody ProductsSaveRequestDto requestDto) {
        return productsService.save(requestDto);
    }

    //update
    @PutMapping("/api/v1/products/{id}")
    public Long updateSpace(@PathVariable Long id, @RequestBody ProductsUpdateRequestDto requestDto) {
        return productsService.update(id, requestDto);
    }


//    @GetMapping("/api/v1/products/{id}")
//    public ProductsResponseDto findById(@PathVariable Long id) {
//        return productsService.findById(id);
//    }

    @DeleteMapping("/space/delete/{id}")
    public Long deleteSpace(@PathVariable Long id) {
        productsService.deleteSpace(id);
        return id;
    }
}
