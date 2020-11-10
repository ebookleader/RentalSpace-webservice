package com.webservice.rentalSpace.domain.products;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "facility")
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long f_id;

//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @ManyToOne // facility 저장시 product 저장하지 않도록 cascade 설정x
    @JoinColumn(name="p_id")
    private Products products;

    private String facility;


    @Builder
    public Facility(String facility, Products products) {
        this.facility = facility;
        this.products = products;
    }
}
