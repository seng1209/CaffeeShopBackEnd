package com.example.coffeeshop.api.service;

import com.example.coffeeshop.api.web.order_detail.CreateOrderDetailDto;
import com.example.coffeeshop.api.web.order_detail.OrderDetailDto;
import com.example.coffeeshop.api.web.order_detail.UpdateOrderDetailDto;

import java.util.List;

public interface OrderDetailService {

    // create order_detail
    void createNewOrderDetail(CreateOrderDetailDto createOrderDetailDto);

    // update order_detail by uuid
    void updateByUuid(String uuid, UpdateOrderDetailDto updateOrderDetailDto);

    // delete order_detail by uuid
    void deleteByUuid(String uuid);

    // select order_detail by uuid
    OrderDetailDto findByUuid(String uuid);

    // select all order_detail
    List<OrderDetailDto> findALl();

    // get quantity
    Integer getQuantity(Long orderId);

    // get all order_detail by order_uuid
    List<OrderDetailDto> getAllOrderDetailBuOrderUuid(String uuid);

}
