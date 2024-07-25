//package com.example.coffeeshop.api.repository;
//
//import com.example.coffeeshop.api.entities.Order;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//
//import java.time.LocalDate;
//import java.util.List;
//import java.util.Optional;
//
//public interface OrderRepository extends JpaRepository<Order, Long> {
//
//    Boolean existsByUuid(String uuid);
//
//    Boolean existsByOrderDate(LocalDate date);
//
//    Optional<Order> findByUuid(String uuid);
//
//    List<Order> findAllByOrderDateAndIsDeleteIsFalse(LocalDate date);
//
//    @Modifying
//    @Query("UPDATE Order  AS o SET o.isDelete = true WHERE o.uuid = ?1")
//    void editOrderIsDeleteByUuid(String uuid);
//
//    @Modifying
//    @Query("UPDATE Order AS o SET o.isDelete = true WHERE o.orderDate = ?1")
//    void editAllIsDeleteByOrderDate(LocalDate date);
//
//    List<Order> findAllByOrderDate(LocalDate date);
//
//    List<Order> findAllByIsDeleteIsFalse();
//
//    List<Order> findAllByIsDeleteIsTrue();
//
//    @Query("SELECT MAX(O.id) FROM Order AS O")
//    Long getLastOrderId();
//    @Modifying
//    @Query("UPDATE Order AS O SET O.quantity = ?2 WHERE O.id = ?1")
//    void editQuantity(Long orderId, Integer quantity);
//
//}
