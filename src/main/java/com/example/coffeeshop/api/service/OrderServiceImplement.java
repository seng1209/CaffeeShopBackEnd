//package com.example.coffeeshop.api.service;
//
//import com.example.coffeeshop.api.entities.Customer;
//import com.example.coffeeshop.api.entities.Delivery;
//import com.example.coffeeshop.api.entities.Order;
//import com.example.coffeeshop.api.entities.Payment;
//import com.example.coffeeshop.api.mapper.OrderMapper;
//import com.example.coffeeshop.api.repository.OrderRepository;
//import com.example.coffeeshop.api.web.order.CreateOrderDto;
//import com.example.coffeeshop.api.web.order.OrderDto;
//import com.example.coffeeshop.api.web.order.UpdateOrderDto;
//import com.example.coffeeshop.api.web.order.UpdateQuantityOrder;
//import lombok.AllArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.time.LocalDate;
//import java.util.List;
//import java.util.UUID;
//
//@Service
//@AllArgsConstructor
//public class OrderServiceImplement implements OrderService{
//
//    private final OrderMapper orderMapper;
//    private final OrderRepository orderRepository;
//
//
//    @Override
//    public void createNewOrder(CreateOrderDto createOrderDto) {
//        Order order = orderMapper.fromOrderDto(createOrderDto);
//        order.setUuid(UUID.randomUUID().toString());
//        order.setOrderDate(LocalDate.now());
//        order.setIsDelete(false);
//        orderRepository.save(order);
//    }
//
//    @Override
//    public void updateOrder(String uuid, UpdateOrderDto updateOrderDto) {
//        if (orderRepository.existsByUuid(uuid)){
//            Order order = orderRepository.findByUuid(uuid).orElseThrow();
//            orderMapper.fromUpdateOrder(order, updateOrderDto);
//
//            if (updateOrderDto.customerId() != null){
//                Customer newCustomer = new Customer();
//                newCustomer.setId(updateOrderDto.customerId());
//                order.setCustomer(newCustomer);
//            }
//
//            if (updateOrderDto.paymentId() != null){
//                Payment newPayment = new Payment();
//                newPayment.setId(updateOrderDto.paymentId());
//                order.setPayment(newPayment);
//            }
//
//            if (updateOrderDto.deliveryId() != null){
//                Delivery newDelivery = new Delivery();
//                newDelivery.setId(updateOrderDto.deliveryId());
//                order.setDelivery(newDelivery);
//            }
//
//            orderRepository.save(order);
//            return;
//        }
//
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
//                String.format("Order at UUID : %s is not found...!", uuid));
//    }
//
//    @Transactional
//    @Override
//    public void updateOrderIsDeleteByUuid(String uuid) {
//        if (orderRepository.existsByUuid(uuid)){
//            orderRepository.editOrderIsDeleteByUuid(uuid);
//            return;
//        }
//
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
//                String.format("Order at UUID : %s is not found...!", uuid));
//    }
//
//    @Transactional
//    @Override
//    public void updateAllIsDeleteByOrderDate(LocalDate date) {
//        if (orderRepository.existsByOrderDate(date)){
//            orderRepository.editAllIsDeleteByOrderDate(date);
//            return;
//        }
//
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
//                String.format("Order at Date : %s is not found...!", date));
//    }
//
//    @Override
//    public void deleteOrderByUuid(String uuid) {
//        Order order = orderRepository.findByUuid(uuid).orElseThrow(
//                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
//                String.format("Order at UUID : %s is not found...!", uuid))
//        );
//
//        orderRepository.delete(order);
//    }
//
//    @Override
//    public void deleteAllOrderByOrderDate(LocalDate date) {
//        List<Order> orders = orderRepository.findAllByOrderDate(date);
//        orderRepository.deleteAll(orders);
//    }
//
//    @Override
//    public OrderDto findByUuid(String uuid) {
//        Order order = orderRepository.findByUuid(uuid).orElseThrow(
//                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
//                String.format("Order at UUID : %s is not found...!", uuid))
//        );
//        return orderMapper.toOrderDto(order);
//    }
//
//    @Override
//    public List<OrderDto> findByOrderDate(LocalDate date) {
//        List<Order> orders = orderRepository.findAllByOrderDateAndIsDeleteIsFalse(date);
//        return orderMapper.toOrderDtoList(orders);
//    }
//
//    @Override
//    public List<OrderDto> findAll() {
//        List<Order> orders = orderRepository.findAllByIsDeleteIsFalse();
//        return orderMapper.toOrderDtoList(orders);
//    }
//
//    @Override
//    public List<OrderDto> findAllOrderIsDeleteIsTrue() {
//        List<Order> orders = orderRepository.findAllByIsDeleteIsTrue();
//        return orderMapper.toOrderDtoList(orders);
//    }
//
//    @Override
//    public Long getLastOrderId() {
//        return orderRepository.getLastOrderId();
//    }
//
//    @Transactional
//    @Override
//    public void updateQuantityByOrderId(Long orderId, UpdateQuantityOrder updateQuantityOrder) {
//        orderRepository.editQuantity(orderId, updateQuantityOrder.quantity());
//    }
//}
