package com.example.coffeeshop.api.service;

import com.example.coffeeshop.api.web.delivery.CreateDeliveryDto;
import com.example.coffeeshop.api.web.delivery.DeliveryDto;
import com.example.coffeeshop.api.web.delivery.UpdateDeliveryDto;

import java.time.LocalDate;
import java.util.List;

public interface DeliveryService {

    // create delivery
    void createNewDelivery(CreateDeliveryDto createDeliveryDto);

    // update delivery by uuid
    void updateDeliveryByUuid(String uuid, UpdateDeliveryDto updateDeliveryDto);

    // delete delivery by uuid
    void deleteDeliveryByUuid(String uuid);

    // delete all delivery by delivery_date
    void deleteAllDeliveryByDeliveryDate(LocalDate date);

    // select delivery by uuid
    DeliveryDto findByUuid(String uuid);

    // select all delivery by delivery_date
    List<DeliveryDto> findAllByDeliveryDate(LocalDate date);

    // select all delivery
    List<DeliveryDto> findAll();

    DeliveryDto findById(Long id);

}
