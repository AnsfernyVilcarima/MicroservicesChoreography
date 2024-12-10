package com.example.choreographyservice.controller;

import com.example.choreographyservice.model.Order;
import com.example.choreographyservice.publisher.OrderPublisher;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderPublisher orderPublisher;

    public OrderController(OrderPublisher orderPublisher) {
        this.orderPublisher = orderPublisher;
    }

    @PostMapping
    public String placeOrder(@RequestBody Order order) {
        orderPublisher.sendOrder(order);
        return "Order placed: " + order.getOrderId();
    }
}
