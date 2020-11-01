package com.webservice.rentalSpace.domain.products;

import com.webservice.rentalSpace.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Products extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private Long p_id; //bigint

    @Column(nullable = false)
    private String p_owner_id;

    @Column(nullable = false)
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

    @Column(length = 500)
    private String p_facility;

    @Column(length = 500)
    private String p_notice;

    @Column(length = 500)
    private String p_policy;

    private int p_maxNum;
    private int p_liked;
    private double p_avgRating;

    @Builder
    public Products(String p_owner_id, String p_name, String p_location, String p_city, String p_category, int p_weekdayPrice, int p_weekendPrice,
                    String p_introduce, String p_facility, String p_notice, String p_policy, int p_maxNum, int p_liked, double p_avgRating
                    ) {
        this.p_owner_id = p_owner_id;
        this.p_name = p_name;
        this.p_location = p_location;
        this.p_city = p_city;
        this.p_category = p_category;
        this.p_weekdayPrice = p_weekdayPrice;
        this.p_weekendPrice = p_weekendPrice;
        this.p_introduce = p_introduce;
        this.p_facility = p_facility;
        this.p_notice = p_notice;
        this.p_policy = p_policy;
        this.p_maxNum = p_maxNum;
        this.p_liked = p_liked;
        this.p_avgRating = p_avgRating;
    }

    public void update(String p_name, String p_location, String p_city, String p_category, int p_weekdayPrice, int p_weekendPrice,
                       String p_introduce, String p_facility, String p_notice, String p_policy, int p_maxNum, int p_liked, double p_avgRating) {
        this.p_name = p_name;
        this.p_location = p_location;
        this.p_city = p_city;
        this.p_category = p_category;
        this.p_weekdayPrice = p_weekdayPrice;
        this.p_weekendPrice = p_weekendPrice;
        this.p_introduce = p_introduce;
        this.p_facility = p_facility;
        this.p_notice = p_notice;
        this.p_policy = p_policy;
        this.p_maxNum = p_maxNum;
        this.p_liked = p_liked;
        this.p_avgRating = p_avgRating;
    }


}
