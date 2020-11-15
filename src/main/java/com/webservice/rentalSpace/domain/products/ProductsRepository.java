package com.webservice.rentalSpace.domain.products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Products, Long> {
    // JpaRepository<Entity class, pk type>
    // CRUD 메소드 자동 생성

    @Query("SELECT p FROM Products p ORDER BY p_id DESC")
    List<Products> findAllDesc();
}
