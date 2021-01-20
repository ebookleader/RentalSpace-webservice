//package com.webservice.rentalSpace.web;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.webservice.rentalSpace.domain.products.Products;
//import com.webservice.rentalSpace.domain.products.ProductsRepository;
//import com.webservice.rentalSpace.web.dto.ProductsSaveRequestDto;
//import com.webservice.rentalSpace.web.dto.ProductsUpdateRequestDto;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringRunner;
//import java.util.List;
//import static org.assertj.core.api.Assertions.assertThat;
//
//import org.springframework.http.MediaType;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class ProductsApiControllerTest {
//    @LocalServerPort
//    private int port;
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    @Autowired
//    private ProductsRepository productsRepository;
//
//    @Autowired
//    private WebApplicationContext context;
//
//    private MockMvc mvc;
//
//    @Before
//    public void setup() {
//        mvc = MockMvcBuilders
//                .webAppContextSetup(context)
//                .apply(springSecurity())
//                .build();
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        productsRepository.deleteAll();
//    }
//
//    @Test
//    @WithMockUser(roles = "USER")
//    public void products_save() throws Exception {
//        String p_name="test product name";
//        String p_location="test location";
//        String p_city="test city";
//        String p_category="test category";
//        int p_weekdayPrice=7000;
//        int p_weekendPrice=8000;
//        String p_introduce="test product introduce";
//        int p_maxNum=10;
//        int p_liked=24;
//        double p_avgRating=3.5;
//
//        ProductsSaveRequestDto requestDto = ProductsSaveRequestDto.builder()
//                .p_name(p_name)
//                .p_location(p_location)
//                .p_city(p_city)
//                .p_category(p_category)
//                .p_weekdayPrice(p_weekdayPrice)
//                .p_weekendPrice(p_weekendPrice)
//                .p_introduce(p_introduce)
//                .p_maxNum(p_maxNum)
//                .p_liked(p_liked)
//                .p_avgRating(p_avgRating)
//                .build();
//        System.out.println("call0");
//        String url = "http://localhost:"+port+"/api/v1/products";
//
//        mvc.perform(post(url)
//                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                .content(new ObjectMapper().writeValueAsString(requestDto)))
//                .andExpect(status().isOk());
//        System.out.println("call1");
//
//
////        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);
////
////        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
////        assertThat(responseEntity.getBody()).isGreaterThan(0L);
//
//        List<Products> all = productsRepository.findAll();
//        System.out.println("call2");
//        assertThat(all.get(0).getP_name()).isEqualTo(p_name);
//        assertThat(all.get(0).getP_avgRating()).isEqualTo(p_avgRating);
//    }
//
//    @Test
//    @WithMockUser(roles = "USER")
//    public void products_update() throws Exception {
//        String p_name="test product name";
//        String p_location="test location";
//        String p_city="test city";
//        String p_category="test category";
//        int p_weekdayPrice=7000;
//        int p_weekendPrice=8000;
//        String p_introduce="test product introduce";
//        int p_maxNum=10;
//        int p_liked=24;
//        double p_avgRating=3.5;
//
//        Products savedProducts = productsRepository.save(Products.builder()
//                .p_name(p_name)
//                .p_location(p_location)
//                .p_city(p_city)
//                .p_category(p_category)
//                .p_weekdayPrice(p_weekdayPrice)
//                .p_weekendPrice(p_weekendPrice)
//                .p_introduce(p_introduce)
//                .p_maxNum(p_maxNum)
//                .p_liked(p_liked)
//                .p_avgRating(p_avgRating)
//                .build()
//        );
//
//        Long updateP_id = savedProducts.getP_id();
//
//        ProductsUpdateRequestDto requestDto = ProductsUpdateRequestDto.builder()
//                .p_name("new name")
//                .p_location("new location")
//                .p_city("new city")
//                .p_category("new category")
//                .p_weekdayPrice(100000)
//                .p_weekendPrice(100000)
//                .p_introduce("new introduce")
//                .p_maxNum(100)
//                .build();
//
//        String url = "http://localhost:"+port+"/api/v1/products/"+updateP_id;
//
//        mvc.perform(put(url)
//                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                .content(new ObjectMapper().writeValueAsString(requestDto)))
//                .andExpect(status().isOk());
//
////        HttpEntity<ProductsUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);
////
////        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);
////
////        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
////        assertThat(responseEntity.getBody()).isGreaterThan(0L);
//
//        List<Products> all = productsRepository.findAll();
//
//        assertThat(all.get(0).getP_name()).isEqualTo("new name");
//        assertThat(all.get(0).getP_introduce()).isEqualTo("new introduce");
//
//
//    }
//}
