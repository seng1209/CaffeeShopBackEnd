package com.example.coffeeshop.api.controller;

import com.example.coffeeshop.api.service.OrderService;
import com.example.coffeeshop.api.web.order.CreateOrderDto;
import com.example.coffeeshop.api.web.order.OrderDto;
import com.example.coffeeshop.api.web.order.UpdateOrderDto;
import com.example.coffeeshop.api.web.order.UpdateQuantityOrder;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v2/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createNewOrder(@RequestBody @Valid CreateOrderDto createOrderDto){
        orderService.createNewOrder(createOrderDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{uuid}")
    public void updateOrder(@PathVariable String uuid, @RequestBody @Valid UpdateOrderDto updateOrderDto){
        orderService.updateOrder(uuid, updateOrderDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{uuid}")
    public void updateOrderIsDeleteByUuid(@PathVariable String uuid){
        orderService.updateOrderIsDeleteByUuid(uuid);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{date}")
    public void updateAllIsDeleteByOrderDate(@PathVariable LocalDate date){
        orderService.updateAllIsDeleteByOrderDate(date);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/quantity/{id}")
    public void updateQuantityByOrderId(@PathVariable Long id, @RequestBody UpdateQuantityOrder updateQuantityOrder){
        orderService.updateQuantityByOrderId(id, updateQuantityOrder);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{uuid}")
    public void deleteOrderByUuid(@PathVariable String uuid){
        orderService.deleteOrderByUuid(uuid);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{date}")
    public void deleteAllOrderByOrderDate(@PathVariable LocalDate date){
        orderService.deleteAllOrderByOrderDate(date);
    }

    @GetMapping("/{uuid}")
    public OrderDto findByUuid(@PathVariable String uuid){
        return orderService.findByUuid(uuid);
    }

    @GetMapping("/date/{date}")
    public List<OrderDto> findByOrderDate(@PathVariable LocalDate date){
        return orderService.findByOrderDate(date);
    }

    @GetMapping
    public List<OrderDto> findAll(){
        return orderService.findAll();
    }

    @GetMapping("/is_delete")
    public List<OrderDto> findAllOrderIsDeleteIsTrue(){
        return orderService.findAllOrderIsDeleteIsTrue();
    }

    @GetMapping("/last_id")
    public Long getLastOrderId(){
        return orderService.getLastOrderId();
    }

}
