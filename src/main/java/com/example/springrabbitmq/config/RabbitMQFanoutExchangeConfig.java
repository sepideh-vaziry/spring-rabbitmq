package com.example.springrabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQFanoutExchangeConfig {

  public static final String FANOUT_EXCHANGE = "fanout-exchange";
  public static final String FANOUT_QUEUE_1 = "fanout-queue-1";
  public static final String FANOUT_QUEUE_2 = "fanout-queue-2";

  @Bean
  public Queue fanoutQueue1() {
    return QueueBuilder.durable(FANOUT_QUEUE_1)
        .build();
  }

  @Bean
  public Queue fanoutQueue2() {
    return QueueBuilder.durable(FANOUT_QUEUE_2)
        .build();
  }

  @Bean
  public FanoutExchange fanoutExchange() {
    return new FanoutExchange(FANOUT_EXCHANGE);
  }

  @Bean
  public Binding fanoutBinding1(Queue fanoutQueue1, FanoutExchange fanoutExchange) {
    return BindingBuilder
        .bind(fanoutQueue1)
        .to(fanoutExchange);
  }

  @Bean
  public Binding fanoutBinding2(Queue fanoutQueue2, FanoutExchange fanoutExchange) {
    return BindingBuilder
        .bind(fanoutQueue2)
        .to(fanoutExchange);
  }

}
