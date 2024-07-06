package com.example.springrabbitmq.consumer;

import static com.example.springrabbitmq.config.RabbitMQFanoutExchangeConfig.FANOUT_QUEUE_1;
import static com.example.springrabbitmq.config.RabbitMQFanoutExchangeConfig.FANOUT_QUEUE_2;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
@RabbitListener(queues = { FANOUT_QUEUE_1, FANOUT_QUEUE_2 })
public class FanoutMessageConsumer {

  @RabbitHandler
  public void consume(String message) {
    log.info("Received message from fanout exchange: {}", message);
  }

}
