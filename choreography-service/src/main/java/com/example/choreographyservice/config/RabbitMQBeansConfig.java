package com.example.choreographyservice.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQBeansConfig {

    @Bean
    public Queue queue() {
        return new Queue("order.queue", true);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange("order.exchange");
    }

    @Bean
    public Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("order.routing.key");
    }
}
