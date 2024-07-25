//package com.example.coffeeshop.api.repository;
//
//import com.example.coffeeshop.api.entities.OrderDetail;
//import com.example.coffeeshop.api.web.order_detail.CreateOrderDetailDto;
//import com.example.coffeeshop.api.web.order_detail.OrderDetailDto;
//import com.example.coffeeshop.api.web.order_detail.UpdateOrderDetailDto;
//import org.mapstruct.BeanMapping;
//import org.mapstruct.Mapping;
//import org.mapstruct.MappingTarget;
//import org.mapstruct.NullValuePropertyMappingStrategy;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import java.util.List;
//import java.util.Optional;
//
//public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
//
//    Boolean existsByUuid(String uuid);
//
//    Optional<OrderDetail> findByUuid(String uuid);
//
//    @Query("SELECT SUM(OD.quantity) FROM OrderDetail AS OD WHERE OD.order.id = ?1")
//    Integer quantity(Long orderId);
//
//    @Query("SELECT OD FROM OrderDetail AS OD WHERE OD.order.uuid = ?1")
//    List<OrderDetail> selectAllOrderDetailByOrderUuid(String uuid);
//
//}
