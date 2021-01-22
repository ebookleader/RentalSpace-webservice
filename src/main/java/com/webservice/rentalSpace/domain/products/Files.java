package com.webservice.rentalSpace.domain.products;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Files {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileId;

    private String fileName;

    private String fileOriginalName;

    private String fileUrl;

    @ManyToOne
    @JoinColumn(name="p_id")
    private Products products;

    @Builder
    public Files(String fileName, String fileOriginalName, String fileUrl, Products products) {
        this.fileName = fileName;
        this.fileOriginalName = fileOriginalName;
        this.fileUrl = fileUrl;
        this.products = products;
    }
}
