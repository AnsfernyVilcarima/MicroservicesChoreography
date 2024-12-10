package com.example.choreographyservice.publisher;

import com.example.choreographyservice.model.Order;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrderPublisher {

    private final AmqpTemplate amqpTemplate;

    @Value("${spring.rabbitmq.template.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.template.routing-key}")
    private String routingKey;

    public OrderPublisher(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void sendOrder(Order order) {
        amqpTemplate.convertAndSend(exchange, routingKey, order);
        System.out.println("Order sent: " + order.getOrderId());
    }
}
