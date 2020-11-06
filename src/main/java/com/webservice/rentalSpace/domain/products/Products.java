package com.webservice.rentalSpace.domain.products;

import com.webservice.rentalSpace.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Products extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    @Column(name="p_id", updatable = false, insertable = false)
    private Long p_id; //bigint

    @Column(nullable = false)
    private String p_owner_id;

    @Column(nullable = false, length = 100)
    private String p_name;

    @Column(nullable = false)
    private String p_location;

    @Column(nullable = false)
    private String p_city;

    @Column(nullable = false)
    private String p_category;

    @Column(nullable = false)
    private int p_weekdayPrice;

    @Column(nullable = false)
    private int p_weekendPrice;

    @Column(length = 500)
    private String p_introduce;

    private String p_img1;
    private String p_img2;
    private String p_img3;
//
//    private String p_facility1;
//    private String p_facility2;
//    private String p_facility3;
//    private String p_facility4;
//    private String p_facility5;
//    private String p_facility6;
//    private String p_facility7;
//    private String p_facility8;
//    private String p_facility9;
//    private String p_facility10;

    @Column(length = 500)
    private String p_notice;

    @Column(length = 500)
    private String p_policy;

    private int p_maxNum;
    private int p_liked;
    private double p_avgRating;

    @OneToMany(mappedBy = "products", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Facility> facility;

    public void setFacility(List<Facility> facility) {
        this.facility = facility;
    }

    public void addFacility(Facility f) {
        if(facility == null) {
            facility = new ArrayList<Facility>();
        }
        facility.add(f);
    }


    @Builder
    public Products(String p_owner_id, String p_name, String p_location, String p_city, String p_category, int p_weekdayPrice, int p_weekendPrice,
                    String p_introduce,
//                    String p_facility1, String p_facility2, String p_facility3, String p_facility4,
//                    String p_facility5, String p_facility6, String p_facility7, String p_facility8, String p_facility9, String p_facility10,
                    String p_notice, String p_policy, int p_maxNum, int p_liked, double p_avgRating, List<Facility> facility
                    ) {
        this.p_owner_id = p_owner_id;
        this.p_name = p_name;
        this.p_location = p_location;
        this.p_city = p_city;
        this.p_category = p_category;
        this.p_weekdayPrice = p_weekdayPrice;
        this.p_weekendPrice = p_weekendPrice;
        this.p_introduce = p_introduce;
//        this.p_facility1 = p_facility1;
//        this.p_facility2 = p_facility2;
//        this.p_facility3 = p_facility3;
//        this.p_facility4 = p_facility4;
//        this.p_facility5 = p_facility5;
//        this.p_facility6 = p_facility6;
//        this.p_facility7 = p_facility7;
//        this.p_facility8 = p_facility8;
//        this.p_facility9 = p_facility9;
//        this.p_facility10 = p_facility10;
        this.p_notice = p_notice;
        this.p_policy = p_policy;
        this.p_maxNum = p_maxNum;
        this.p_liked = p_liked;
        this.p_avgRating = p_avgRating;
        this.facility = facility;
    }

    public void update(String p_name, String p_location, String p_city, String p_category, int p_weekdayPrice, int p_weekendPrice, String p_introduce,
//                       String p_facility1, String p_facility2, String p_facility3, String p_facility4,
//                       String p_facility5, String p_facility6, String p_facility7, String p_facility8, String p_facility9, String p_facility10,
                       String p_notice, String p_policy, int p_maxNum, int p_liked, double p_avgRating) {
        this.p_name = p_name;
        this.p_location = p_location;
        this.p_city = p_city;
        this.p_category = p_category;
        this.p_weekdayPrice = p_weekdayPrice;
        this.p_weekendPrice = p_weekendPrice;
        this.p_introduce = p_introduce;
//        this.p_facility1 = p_facility1;
//        this.p_facility2 = p_facility2;
//        this.p_facility3 = p_facility3;
//        this.p_facility4 = p_facility4;
//        this.p_facility5 = p_facility5;
//        this.p_facility6 = p_facility6;
//        this.p_facility7 = p_facility7;
//        this.p_facility8 = p_facility8;
//        this.p_facility9 = p_facility9;
//        this.p_facility10 = p_facility10;
        this.p_notice = p_notice;
        this.p_policy = p_policy;
        this.p_maxNum = p_maxNum;
        this.p_liked = p_liked;
        this.p_avgRating = p_avgRating;
    }


}
