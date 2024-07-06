package com.example.springrabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQHeadersExchangeConfig {

  public static final String HEADERS_EXCHANGE = "headers-exchange";
  public static final String HEADERS_QUEUE = "headers-queue";
  public static final String HEADERS_DL_QUEUE = "headers-dl-queue";

  @Bean
  public Queue headerDLQueue() {
    return QueueBuilder.durable(HEADERS_DL_QUEUE)
        .build();
  }

  @Bean
  public Queue headersQueue() {
    return QueueBuilder.durable(HEADERS_QUEUE)
        .withArgument("x-dead-letter-exchange", "")
        .withArgument("x-dead-letter-routing-key", HEADERS_DL_QUEUE)
        .build();
  }

  @Bean
  public HeadersExchange headersExchange() {
    return new HeadersExchange(HEADERS_EXCHANGE);
  }

  @Bean
  public Binding headersBinding(Queue headersQueue, HeadersExchange headersExchange) {
    return BindingBuilder
        .bind(headersQueue)
        .to(headersExchange)
        .where("header-key")
        .matches("header-value");
  }

}
