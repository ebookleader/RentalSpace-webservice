package com.webservice.rentalSpace.domain.products;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductsNoticeRepositoryTest {

    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    ProductsNoticeRepository noticeRepository;

    @After
    public void cleanup() {
        productsRepository.deleteAll();
        noticeRepository.deleteAll();
    }

    @Test
    public void notice_save_load() {
        String p_owner_id = "test id";
        String p_name = "test product name";
        String p_location = "test location";
        String p_city = "test city";
        String p_category = "test category";
        int p_weekdayPrice = 7000;
        int p_weekendPrice = 8000;
        String p_introduce = "test product introduce";
        int p_maxNum = 10;
        int p_liked = 24;
        double p_avgRating = 3.5;

        Products products = Products.builder()
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

        productsRepository.save(products);

        ProductsNotice pnotice = ProductsNotice.builder()
                .p_notice("notice1")
                .products(products)
                .build();

        noticeRepository.save(pnotice);

        //////////////////////////////////
        ProductsNotice p1 = noticeRepository.findAll().get(0);
        assertThat(p1.getP_notice()).isEqualTo("notice1");
        Products pro1 = productsRepository.findAll().get(0);
        assertThat(pro1.getP_name()).isEqualTo(p_name);

        List<ProductsNotice> nlist = products.getP_notice();
        for(ProductsNotice p : nlist) {
            assertThat(p.getP_notice()).startsWith("notice");
        }
    }
}
