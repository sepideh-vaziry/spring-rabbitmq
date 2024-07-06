package com.example.springrabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQTopicExchangeConfig {

  public static final String TOPIC_EXCHANGE = "topic-exchange";
  public static final String TOPIC_QUEUE = "topic-queue";
  public static final String TOPIC_DL_QUEUE = "topic-dl-queue";
  public static final String TOPIC_ROUTING_KEY = "topic.routing.#";

  @Bean
  public Queue topicDLQueue() {
    return QueueBuilder.durable(TOPIC_DL_QUEUE)
        .build();
  }

  @Bean
  public Queue topicQueue() {
    return QueueBuilder.durable(TOPIC_QUEUE)
        .withArgument("x-dead-letter-exchange", "")
        .withArgument("x-dead-letter-routing-key", TOPIC_DL_QUEUE)
        .build();
  }

  @Bean
  public TopicExchange topicExchange() {
    return new TopicExchange(TOPIC_EXCHANGE);
  }

  @Bean
  public Binding topicBinding(Queue topicQueue, TopicExchange topicExchange) {
    return BindingBuilder
        .bind(topicQueue)
        .to(topicExchange)
        .with(TOPIC_ROUTING_KEY);
  }

}
