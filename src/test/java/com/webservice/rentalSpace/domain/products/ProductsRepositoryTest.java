//package com.webservice.rentalSpace.domain.products;
//
//import org.junit.After;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.persistence.Column;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ProductsRepositoryTest {
//
//    @Autowired
//    ProductsRepository productsRepository;
//
//    @After
//    public void cleanup() {
//        productsRepository.deleteAll();
//    }
//
//    @Test
//    public void products_save_load() {
//        String p_owner_id="test id";
//        String p_name="test product name";
//        String p_location="test location";
//        String p_city="test city";
//        String p_category="test category";
//        int p_weekdayPrice=7000;
//        int p_weekendPrice=8000;
//        String p_introduce="test product introduce";
//        String p_facility1="test facility1";
//        String p_notice="test notice";
//        String p_policy="test policy";
//        int p_maxNum=10;
//        int p_liked=24;
//        double p_avgRating=3.5;
//
//        productsRepository.save(
//                Products.builder()
//                .p_owner_id(p_owner_id)
//                .p_name(p_name)
//                .p_location(p_location)
//                .p_city(p_city)
//                .p_category(p_category)
//                .p_weekdayPrice(p_weekdayPrice)
//                .p_weekendPrice(p_weekendPrice)
//                .p_introduce(p_introduce)
//                .p_facility1(p_facility1)
//                .p_notice(p_notice)
//                .p_policy(p_policy)
//                .p_maxNum(p_maxNum)
//                .p_liked(p_liked)
//                .p_avgRating(p_avgRating)
//                .build()
//        );
//
//        List<Products> productsList = productsRepository.findAll();
//
//        Products products = productsList.get(0);
//
//        assertThat(products.getP_name()).isEqualTo(p_name);
//        assertThat(products.getP_owner_id()).isEqualTo(p_owner_id);
//        assertThat(products.getP_avgRating()).isEqualTo(p_avgRating);
//    }
//}
