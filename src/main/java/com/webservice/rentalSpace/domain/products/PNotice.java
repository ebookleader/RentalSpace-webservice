package com.webservice.rentalSpace.domain.products;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class PNotice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pno_id;

    @ManyToOne
    @JoinColumn(name="p_id")
    private Products products;

    private String p_notice;

    @Builder
    public PNotice(String p_notice, Products products) {
        this.p_notice = p_notice;
        this.products = products;
    }
}
