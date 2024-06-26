package com.example.coffeeshop.api.controller;

import com.example.coffeeshop.api.service.OrderDetailService;
import com.example.coffeeshop.api.web.order_detail.CreateOrderDetailDto;
import com.example.coffeeshop.api.web.order_detail.OrderDetailDto;
import com.example.coffeeshop.api.web.order_detail.UpdateOrderDetailDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/order_detail")
@AllArgsConstructor
public class OrderDetailController {

    private final OrderDetailService orderDetailService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createNewOrderDetail(@RequestBody @Valid CreateOrderDetailDto createOrderDetailDto){
        orderDetailService.createNewOrderDetail(createOrderDetailDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{uuid}")
    public void updateByUuid(@PathVariable String uuid, @RequestBody @Valid UpdateOrderDetailDto updateOrderDetailDto){
        orderDetailService.updateByUuid(uuid, updateOrderDetailDto);
    }

    @DeleteMapping("/{uuid}")
    public void deleteByUuid(@PathVariable String uuid){
        orderDetailService.deleteByUuid(uuid);
    }

    @GetMapping("/{uuid}")
    public OrderDetailDto findByUuid(@PathVariable String uuid){
        return orderDetailService.findByUuid(uuid);
    }

    @GetMapping
    public List<OrderDetailDto> findAll(){
        return orderDetailService.findALl();
    }

    @GetMapping("/quantity/{orderId}")
    public Integer getQuantity(@PathVariable Long orderId){
        return orderDetailService.getQuantity(orderId);
    }

    @GetMapping("/order_uuid/{uuid}")
    public List<OrderDetailDto> getAllOrderDetailBuOrderUuid(@PathVariable String uuid){
        return orderDetailService.getAllOrderDetailBuOrderUuid(uuid);
    }

}
