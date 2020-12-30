package com.webservice.rentalSpace.domain.products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductsOptionRepository extends JpaRepository<ProductsOption, Long> {
    @Query("SELECT po FROM ProductsOption po WHERE p_id=:p_id ORDER BY po_id")
    List<ProductsOption> findProductsOption(@Param("p_id") Long p_id);
}
