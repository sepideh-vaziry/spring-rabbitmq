package com.example.springrabbitmq.consumer;

import static com.example.springrabbitmq.config.RabbitMQDirectExchangeConfig.DIRECT_QUEUE;
import static com.example.springrabbitmq.config.RabbitMQHeadersExchangeConfig.HEADERS_QUEUE;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
@RabbitListener(queues = HEADERS_QUEUE)
public class HeaderMessageConsumer {

  @RabbitHandler
  public void consume(String message) {
    log.info("Received message from header exchange: {}", message);
  }

}
