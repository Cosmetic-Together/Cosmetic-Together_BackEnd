package Capston.CosmeticTogether.domain.form.repository;

import Capston.CosmeticTogether.domain.form.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT SUM(op.quantity) FROM OrderProduct op WHERE op.product.id = :productId")
    Integer sumQuantityByProductId(@Param("productId") Long productId);

    @Query("SELECT CASE WHEN COUNT(o) > 0 THEN true ELSE false END FROM Order o JOIN o.orderProducts op WHERE op.product.id IN (SELECT p.id FROM Form f JOIN f.product p WHERE f.id = :formId)")
    boolean existsByProduct_FormId(@Param("formId")Long formId);
}