package com.webservice.rentalSpace.domain.products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductsFacilityRepository extends JpaRepository<ProductsFacility, Long> {

    @Query("SELECT pf FROM ProductsFacility pf WHERE p_id=:p_id ORDER BY pf_id")
    List<ProductsFacility> findProductsFacility(@Param("p_id") Long p_id);
}
