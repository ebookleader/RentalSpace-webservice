package com.webservice.rentalSpace.web;

import com.webservice.rentalSpace.domain.products.Products;
import com.webservice.rentalSpace.domain.products.ProductsRepository;
import com.webservice.rentalSpace.web.dto.ProductsSaveRequestDto;
import com.webservice.rentalSpace.web.dto.ProductsUpdateRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductsApiControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ProductsRepository productsRepository;

    @After
    public void tearDown() throws Exception {
        productsRepository.deleteAll();
    }

    @Test
    public void products_save() throws Exception {
        String p_owner_id="test id";
        String p_name="test product name";
        String p_location="test location";
        String p_city="test city";
        String p_category="test category";
        int p_weekdayPrice=7000;
        int p_weekendPrice=8000;
        String p_introduce="test product introduce";
        int p_maxNum=10;
        int p_liked=24;
        double p_avgRating=3.5;

        ProductsSaveRequestDto requestDto = ProductsSaveRequestDto.builder()
                .p_owner_id(p_owner_id)
                .p_name(p_name)
                .p_location(p_location)
                .p_city(p_city)
                .p_category(p_category)
                .p_weekdayPrice(p_weekdayPrice)
                .p_weekendPrice(p_weekendPrice)
                .p_introduce(p_introduce)
                .p_maxNum(p_maxNum)
                .p_liked(p_liked)
                .p_avgRating(p_avgRating)
                .build();

        String url = "http://localhost:"+port+"/api/v1/products";

        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Products> all = productsRepository.findAll();

        assertThat(all.get(0).getP_name()).isEqualTo(p_name);
        assertThat(all.get(0).getP_avgRating()).isEqualTo(p_avgRating);
    }

    @Test
    public void products_update() throws Exception {
        String p_owner_id="test id";
        String p_name="test product name";
        String p_location="test location";
        String p_city="test city";
        String p_category="test category";
        int p_weekdayPrice=7000;
        int p_weekendPrice=8000;
        String p_introduce="test product introduce";
        String p_facility1="test facility1";
        String p_notice="test notice";
        String p_policy="test policy";
        int p_maxNum=10;
        int p_liked=24;
        double p_avgRating=3.5;
        Products savedProducts = productsRepository.save(Products.builder()
                .p_owner_id(p_owner_id)
                .p_name(p_name)
                .p_location(p_location)
                .p_city(p_city)
                .p_category(p_category)
                .p_weekdayPrice(p_weekdayPrice)
                .p_weekendPrice(p_weekendPrice)
                .p_introduce(p_introduce)
                .p_maxNum(p_maxNum)
                .p_liked(p_liked)
                .p_avgRating(p_avgRating)
                .build()
        );

        Long updateP_id = savedProducts.getP_id();

        ProductsUpdateRequestDto requestDto = ProductsUpdateRequestDto.builder()
                .p_name("new name")
                .p_location("new location")
                .p_city("new city")
                .p_category("new category")
                .p_weekdayPrice(100000)
                .p_weekendPrice(100000)
                .p_introduce("new introduce")
                .p_facility1("new facility1")
                .p_notice("new notice")
                .p_policy("new policy")
                .p_maxNum(100)
                .p_liked(300)
                .p_avgRating(4.0)
                .build();

        String url = "http://localhost:"+port+"/api/v1/products/"+updateP_id;

        HttpEntity<ProductsUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);

        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Products> all = productsRepository.findAll();

        assertThat(all.get(0).getP_name()).isEqualTo("new name");
        assertThat(all.get(0).getP_avgRating()).isEqualTo(4.0);


    }
}
