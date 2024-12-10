package com.example.choreographyservice.listener;

import com.example.choreographyservice.model.Order;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class OrderListener {

    @RabbitListener(queues = "order.queue")
    public void receiveOrder(Order order) {
        System.out.println("Order received: " + order.getOrderId() + " with status " + order.getStatus());
    }
}
