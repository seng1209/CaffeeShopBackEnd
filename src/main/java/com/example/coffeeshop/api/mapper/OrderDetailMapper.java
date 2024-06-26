package com.example.coffeeshop.api.mapper;

import com.example.coffeeshop.api.entities.OrderDetail;
import com.example.coffeeshop.api.web.order_detail.CreateOrderDetailDto;
import com.example.coffeeshop.api.web.order_detail.OrderDetailDto;
import com.example.coffeeshop.api.web.order_detail.UpdateOrderDetailDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderDetailMapper {

    // create
    @Mapping(source = "productId", target = "product.id")
    @Mapping(source = "orderId", target = "order.id")
    OrderDetail fromOrderDetailDto(CreateOrderDetailDto createOrderDetailDto);

    // update
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void fromUpdateOrderDetailDto(@MappingTarget OrderDetail orderDetail, UpdateOrderDetailDto updateOrderDetailDto);

    // select a
    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "product.name", target = "product")
    @Mapping(source = "order.id", target = "orderId")
    @Mapping(source = "order.uuid", target = "order")
    OrderDetailDto toOrderDetailDto(OrderDetail orderDetail);

    // select all
    List<OrderDetailDto> toOrderDetailDtoList(List<OrderDetail> orderDetails);

}
