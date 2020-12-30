package com.webservice.rentalSpace.domain.products;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class ProductsOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long po_id;

    @ManyToOne
    @JoinColumn(name="p_id")
    private Products products;

    // optionTitle, startTime, endTime, usingTime, count
    private String optionTitle;

    private int startTime;

    private int endTime;

    private int usingTime;

    private int count;

    @Builder ProductsOption(String optionTitle, int startTime, int endTime, int usingTime, int count, Products products) {
        this.optionTitle = optionTitle;
        this.startTime = startTime;
        this.endTime = endTime;
        this.usingTime = usingTime;
        this.products = products;
        this.count = count;
    }
}
