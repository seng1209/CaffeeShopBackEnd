//package com.example.coffeeshop.api.service;
//
//import com.example.coffeeshop.api.entities.Order;
//import com.example.coffeeshop.api.entities.OrderDetail;
//import com.example.coffeeshop.api.entities.Product;
//import com.example.coffeeshop.api.mapper.OrderDetailMapper;
//import com.example.coffeeshop.api.repository.OrderDetailRepository;
//import com.example.coffeeshop.api.web.order_detail.CreateOrderDetailDto;
//import com.example.coffeeshop.api.web.order_detail.OrderDetailDto;
//import com.example.coffeeshop.api.web.order_detail.UpdateOrderDetailDto;
//import lombok.AllArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.math.BigDecimal;
//import java.util.List;
//import java.util.UUID;
//
//@Service
//@AllArgsConstructor
//public class OrderDetailServiceImplement implements OrderDetailService{
//
//    private final OrderDetailMapper orderDetailMapper;
//    private final OrderDetailRepository orderDetailRepository;
//
//    @Override
//    public void createNewOrderDetail(CreateOrderDetailDto createOrderDetailDto) {
//        OrderDetail orderDetail = orderDetailMapper.fromOrderDetailDto(createOrderDetailDto);
//        orderDetail.setUuid(UUID.randomUUID().toString());
////        orderDetail.setAmount(createOrderDetailDto.unitPrice().multiply(BigDecimal.valueOf(createOrderDetailDto.quantity())));
//        orderDetailRepository.save(orderDetail);
//    }
//
//    @Override
//    public void updateByUuid(String uuid, UpdateOrderDetailDto updateOrderDetailDto) {
//        if (orderDetailRepository.existsByUuid(uuid)){
//            OrderDetail orderDetail = orderDetailRepository.findByUuid(uuid).orElseThrow();
//            orderDetailMapper.fromUpdateOrderDetailDto(orderDetail, updateOrderDetailDto);
//
//            if (updateOrderDetailDto.orderId() != null){
//                Order newOrder = new Order();
//                newOrder.setId(updateOrderDetailDto.orderId());
//                orderDetail.setOrder(newOrder);
//            }
//
//            if (updateOrderDetailDto.productId() != null){
//                Product newProduct = new Product();
//                newProduct.setId(updateOrderDetailDto.productId());
//                orderDetail.setProduct(newProduct);
//            }
//
//            orderDetailRepository.save(orderDetail);
//            return;
//        }
//
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
//                String.format("Order Detail at UUID : %s is not found...!", uuid));
//    }
//
//    @Override
//    public void deleteByUuid(String uuid) {
//        OrderDetail orderDetail = orderDetailRepository.findByUuid(uuid).orElseThrow(
//                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
//                String.format("Order Detail at UUID : %s is not found...!", uuid))
//        );
//
//        orderDetailRepository.delete(orderDetail);
//    }
//
//    @Override
//    public OrderDetailDto findByUuid(String uuid) {
//        OrderDetail orderDetail = orderDetailRepository.findByUuid(uuid).orElseThrow(
//                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
//                        String.format("Order Detail at UUID : %s is not found...!", uuid))
//        );
//        return orderDetailMapper.toOrderDetailDto(orderDetail);
//    }
//
//    @Override
//    public List<OrderDetailDto> findALl() {
//        List<OrderDetail> orderDetails = orderDetailRepository.findAll();
//        return orderDetailMapper.toOrderDetailDtoList(orderDetails);
//    }
//
//    @Override
//    public Integer getQuantity(Long orderId) {
//        return orderDetailRepository.quantity(orderId);
//    }
//
//    @Override
//    public List<OrderDetailDto> getAllOrderDetailBuOrderUuid(String uuid) {
//        List<OrderDetail> orderDetails = orderDetailRepository.selectAllOrderDetailByOrderUuid(uuid);
//        return orderDetailMapper.toOrderDetailDtoList(orderDetails);
//    }
//}
