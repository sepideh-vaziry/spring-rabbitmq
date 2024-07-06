package com.example.springrabbitmq.consumer;

import static com.example.springrabbitmq.config.RabbitMQTopicExchangeConfig.TOPIC_QUEUE;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
@RabbitListener(queues = TOPIC_QUEUE)
public class TopicMessageConsumer {

  @RabbitHandler
  public void consume(String message) {
    log.info("Received message from topic exchange: {}", message);
  }

}
