package com.webservice.rentalSpace.domain.products;

import com.webservice.rentalSpace.domain.BaseTimeEntity;
import com.webservice.rentalSpace.domain.reservation.Reservation;
import com.webservice.rentalSpace.domain.user.User;
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

    @ManyToOne
    @JoinColumn(name="id")
    private User user;

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

    private int p_maxNum;
    private int p_liked;
    private double p_avgRating;

    @OneToMany(mappedBy = "products", fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<ProductsFacility> facility = new ArrayList<>();

    @OneToMany(mappedBy = "products")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<ProductsNotice> p_notice = new ArrayList<>();

    @OneToMany(mappedBy = "products")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<ProductsPolicy> p_policy = new ArrayList<>();

    @OneToMany(mappedBy = "products")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<ProductsOption> p_option = new ArrayList<>();

    @OneToMany(mappedBy = "products")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Reservation> reservations = new ArrayList<>();



    @Builder
    public Products(String p_name, String p_location, String p_city, String p_category, int p_weekdayPrice, int p_weekendPrice,
                    String p_introduce,  int p_maxNum, int p_liked, double p_avgRating
                    ) {
        this.p_name = p_name;
        this.p_location = p_location;
        this.p_city = p_city;
        this.p_category = p_category;
        this.p_weekdayPrice = p_weekdayPrice;
        this.p_weekendPrice = p_weekendPrice;
        this.p_introduce = p_introduce;
        this.p_maxNum = p_maxNum;
        this.p_liked = p_liked;
        this.p_avgRating = p_avgRating;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void update(String p_name, String p_location, String p_city, String p_category, int p_weekdayPrice, int p_weekendPrice, String p_introduce,
                       int p_maxNum) {
        this.p_name = p_name;
        this.p_location = p_location;
        this.p_city = p_city;
        this.p_category = p_category;
        this.p_weekdayPrice = p_weekdayPrice;
        this.p_weekendPrice = p_weekendPrice;
        this.p_introduce = p_introduce;
        this.p_maxNum = p_maxNum;
    }

    public Long getSellerId() {
        return this.user.getId();
    }


}
