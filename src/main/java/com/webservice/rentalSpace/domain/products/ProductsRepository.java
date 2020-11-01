package com.webservice.rentalSpace.domain.products;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products, Long> {
    // JpaRepository<Entity class, pk type>
    // CRUD 메소드 자동 생성
}
