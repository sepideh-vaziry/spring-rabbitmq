package com.example.springrabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQDirectExchangeConfig {

  public static final String DIRECT_EXCHANGE = "direct-exchange";
  public static final String DIRECT_QUEUE = "direct-queue";
  public static final String DIRECT_DL_QUEUE = "direct-dl-queue";
  public static final String DIRECT_ROUTING_KEY = "direct-routing-key";

  @Bean
  public Queue directDLQueue() {
    return QueueBuilder.durable(DIRECT_DL_QUEUE)
        .build();
  }

  @Bean
  public Queue directQueue() {
    return QueueBuilder.durable(DIRECT_QUEUE)
        .withArgument("x-dead-letter-exchange", "")
        .withArgument("x-dead-letter-routing-key", DIRECT_DL_QUEUE)
        .build();
  }

  @Bean
  public DirectExchange directExchange() {
    return new DirectExchange(DIRECT_EXCHANGE);
  }

  @Bean
  public Binding directBinding(Queue directQueue, DirectExchange directExchange) {
    return BindingBuilder
        .bind(directQueue)
        .to(directExchange)
        .with(DIRECT_ROUTING_KEY);
  }

}
