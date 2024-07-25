package com.example.coffeeshop.api.controller;

import com.example.coffeeshop.api.service.DeliveryService;
import com.example.coffeeshop.api.web.delivery.CreateDeliveryDto;
import com.example.coffeeshop.api.web.delivery.DeliveryDto;
import com.example.coffeeshop.api.web.delivery.UpdateDeliveryDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v2/deliveries")
@AllArgsConstructor
public class DeliveryController {

    private final DeliveryService deliveryService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createNewDelivery(@RequestBody @Valid CreateDeliveryDto createDeliveryDto){
        deliveryService.createNewDelivery(createDeliveryDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{uuid}")
    public void updateDeliveryByUuid(@PathVariable String uuid, @RequestBody @Valid UpdateDeliveryDto updateDeliveryDto){
        deliveryService.updateDeliveryByUuid(uuid, updateDeliveryDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{uuid}")
    public void deleteDeliveryByUuid(@PathVariable String uuid){
        deliveryService.deleteDeliveryByUuid(uuid);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/date/{date}")
    public void deleteAllDeliveryByDeliveryDate(@PathVariable LocalDate date){
        deliveryService.deleteAllDeliveryByDeliveryDate(date);
    }

    @GetMapping("/{uuid}")
    public DeliveryDto findByUuid(@PathVariable String uuid){
        return deliveryService.findByUuid(uuid);
    }

    @GetMapping("/date/{date}")
    public List<DeliveryDto> findAllByDeliveryDate(@PathVariable LocalDate date){
        return deliveryService.findAllByDeliveryDate(date);
    }

    @GetMapping
    public List<DeliveryDto> findAll(){
        return deliveryService.findAll();
    }

    @GetMapping("/delivery_id/{id}")
    public DeliveryDto findById(@PathVariable Long id){
        return deliveryService.findById(id);
    }

}
