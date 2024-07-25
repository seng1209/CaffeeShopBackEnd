package com.example.coffeeshop.api.mapper;

import com.example.coffeeshop.api.entities.Delivery;
import com.example.coffeeshop.api.web.delivery.CreateDeliveryDto;
import com.example.coffeeshop.api.web.delivery.DeliveryDto;
import com.example.coffeeshop.api.web.delivery.UpdateDeliveryDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DeliveryMapper {

    // create
    Delivery fromDeliveryDto(CreateDeliveryDto createDeliveryDto);

    // update
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void fromUpdateDeliveryDto(@MappingTarget Delivery delivery, UpdateDeliveryDto updateDeliveryDto);

    // select a delivery
    DeliveryDto toDeliveryDto(Delivery delivery);

    // select all delivery
    List<DeliveryDto> toDeliveryDtoList(List<Delivery> deliveries);

}
