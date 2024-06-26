package com.example.coffeeshop.api.mapper;

import com.example.coffeeshop.api.entities.Order;
import com.example.coffeeshop.api.web.order.CreateOrderDto;
import com.example.coffeeshop.api.web.order.OrderDto;
import com.example.coffeeshop.api.web.order.UpdateOrderDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    // create order
    @Mapping(source = "customerId", target = "customer.id")
    Order fromOrderDto(CreateOrderDto createOrderDto);

    // update order
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void fromUpdateOrder(@MappingTarget Order order, UpdateOrderDto updateOrderDto);

    // select order
    @Mapping(source = "customer.id", target = "customerId")
    @Mapping(source = "customer.name", target = "customer")
    OrderDto toOrderDto(Order order);

    List<OrderDto> toOrderDtoList(List<Order> orders);
}
