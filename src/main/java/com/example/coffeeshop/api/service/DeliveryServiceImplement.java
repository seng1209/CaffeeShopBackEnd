package com.example.coffeeshop.api.service;

import com.example.coffeeshop.api.entities.Delivery;
import com.example.coffeeshop.api.mapper.DeliveryMapper;
import com.example.coffeeshop.api.repository.DeliveryRepository;
import com.example.coffeeshop.api.web.delivery.CreateDeliveryDto;
import com.example.coffeeshop.api.web.delivery.DeliveryDto;
import com.example.coffeeshop.api.web.delivery.UpdateDeliveryDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class DeliveryServiceImplement implements DeliveryService{

    private final DeliveryMapper deliveryMapper;
    private final DeliveryRepository deliveryRepository;

    @Override
    public void createNewDelivery(CreateDeliveryDto createDeliveryDto) {
        Delivery delivery = deliveryMapper.fromDeliveryDto(createDeliveryDto);
        delivery.setUuid(UUID.randomUUID().toString());
        delivery.setDeliveryDate(LocalDate.now());
        deliveryRepository.save(delivery);
    }

    @Override
    public void updateDeliveryByUuid(String uuid, UpdateDeliveryDto updateDeliveryDto) {
        if (deliveryRepository.existsByUuid(uuid)){
            Delivery delivery = deliveryRepository.findByUuid(uuid).orElseThrow();
            deliveryMapper.fromUpdateDeliveryDto(delivery, updateDeliveryDto);

            deliveryRepository.save(delivery);
            return;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Delivery at UUID : %s is not found...!", uuid));
    }

    @Override
    public void deleteDeliveryByUuid(String uuid) {
        if (deliveryRepository.existsByUuid(uuid)){
            Delivery delivery = deliveryRepository.findByUuid(uuid).orElseThrow(
                    () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Delivery at UUID : %s is not found...!", uuid))
            );

            deliveryRepository.delete(delivery);
            return;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Delivery at UUID : %s is not found...!", uuid));
    }

    @Override
    public void deleteAllDeliveryByDeliveryDate(LocalDate date) {
        if (deliveryRepository.existsByDeliveryDate(date)){
            List<Delivery> deliveries = deliveryRepository.findAllByDeliveryDate(date);
            deliveryRepository.deleteAll(deliveries);
            return;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Delivery at Date : %s is not found...!", date));
    }

    @Override
    public DeliveryDto findByUuid(String uuid) {
        Delivery delivery = deliveryRepository.findByUuid(uuid).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Delivery at UUID : %s is not found...!", uuid))
        );
        return deliveryMapper.toDeliveryDto(delivery);
    }

    @Override
    public List<DeliveryDto> findAllByDeliveryDate(LocalDate date) {
        if (deliveryRepository.existsByDeliveryDate(date)){
            List<Delivery> deliveries = deliveryRepository.findAllByDeliveryDate(date);
            return deliveryMapper.toDeliveryDtoList(deliveries);
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Delivery at Date : %s is not found...!", date));
    }

    @Override
    public List<DeliveryDto> findAll() {
        List<Delivery> deliveries = deliveryRepository.findAll();
        return deliveryMapper.toDeliveryDtoList(deliveries);
    }

    @Override
    public DeliveryDto findById(Long id) {
        Delivery delivery = deliveryRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Delivery at ID : %s not found!", id))
        );
        return deliveryMapper.toDeliveryDto(delivery);
    }
}
