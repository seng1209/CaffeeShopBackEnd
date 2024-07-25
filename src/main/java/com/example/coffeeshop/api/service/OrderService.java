//package com.example.coffeeshop.api.service;
//
//import com.example.coffeeshop.api.web.order.CreateOrderDto;
//import com.example.coffeeshop.api.web.order.OrderDto;
//import com.example.coffeeshop.api.web.order.UpdateOrderDto;
//import com.example.coffeeshop.api.web.order.UpdateQuantityOrder;
//
//import java.time.LocalDate;
//import java.util.List;
//
//public interface OrderService {
//
//    // create order
//    void createNewOrder(CreateOrderDto createOrderDto);
//
//    // update order by uuid
//    void updateOrder(String uuid, UpdateOrderDto updateOrderDto);
//
//    // update is_delete by uuid
//    void updateOrderIsDeleteByUuid(String uuid);
//
//    // update is_delete by date
//    void updateAllIsDeleteByOrderDate(LocalDate date);
//
//    // delete by uuid
//    void deleteOrderByUuid(String uuid);
//
//    // delete all by date
//    void deleteAllOrderByOrderDate(LocalDate date);
//
//    // select order by uuid
//    OrderDto findByUuid(String uuid);
//
//    // select all by date is_delete = false
//    List<OrderDto> findByOrderDate(LocalDate date);
//
//    // select all order is_delete = false
//    List<OrderDto> findAll();
//
//    // select all order is_delete = true
//    List<OrderDto> findAllOrderIsDeleteIsTrue();
//
//    // get last order id
//    Long getLastOrderId();
//
//    // update quantity by order_id
//    void updateQuantityByOrderId(Long orderId, UpdateQuantityOrder updateQuantityOrder);
//
//}
