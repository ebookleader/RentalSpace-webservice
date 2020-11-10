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
public class FacilityRepositoryTest {

    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    FacilityRepository facilityRepository;

    @After
    public void cleanup() {
        productsRepository.deleteAll();
        facilityRepository.deleteAll();
    }

    @Test
    public void facility_save_load() {
        String p_owner_id = "test id";
        String p_name = "test product name";
        String p_location = "test location";
        String p_city = "test city";
        String p_category = "test category";
        int p_weekdayPrice = 7000;
        int p_weekendPrice = 8000;
        String p_introduce = "test product introduce";
        String p_notice = "test notice";
        String p_policy = "test policy";
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
                .p_notice(p_notice)
                .p_policy(p_policy)
                .p_maxNum(p_maxNum)
                .p_liked(p_liked)
                .p_avgRating(p_avgRating)
                .build();

        productsRepository.save(products);

        Facility facility = Facility.builder()
                .facility("facility1")
                .products(products)
                .build();

        facilityRepository.save(facility);

        ////////////////////////
        Facility f1 = facilityRepository.findAll().get(0);
        assertThat(f1.getFacility()).isEqualTo("facility1");
        Products p1 = productsRepository.findAll().get(0);
        assertThat(p1.getP_name()).isEqualTo(p_name);

        List<Facility> flist = products.getFacility();
        for(Facility f : flist) {
            assertThat(f.getFacility()).startsWith("facility");
        }
    }
}
