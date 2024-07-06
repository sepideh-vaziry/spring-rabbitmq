package com.example.springrabbitmq.producer;

import static com.example.springrabbitmq.config.RabbitMQDirectExchangeConfig.DIRECT_EXCHANGE;
import static com.example.springrabbitmq.config.RabbitMQDirectExchangeConfig.DIRECT_ROUTING_KEY;
import static com.example.springrabbitmq.config.RabbitMQFanoutExchangeConfig.FANOUT_EXCHANGE;
import static com.example.springrabbitmq.config.RabbitMQTopicExchangeConfig.TOPIC_EXCHANGE;
import static com.example.springrabbitmq.config.RabbitMQHeadersExchangeConfig.HEADERS_EXCHANGE;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageProducer {

  private final RabbitTemplate rabbitTemplate;

  public void sendDirectMessage(String message) {
    rabbitTemplate.convertAndSend(DIRECT_EXCHANGE, DIRECT_ROUTING_KEY, message);
  }

  public void sendFanoutMessage(String message) {
    rabbitTemplate.convertAndSend(FANOUT_EXCHANGE, "", message);
  }

  public void sendTopicMessage(String message) {
    rabbitTemplate.convertAndSend(TOPIC_EXCHANGE, "topic.routing.key", message);
  }

  public void sendHeadersMessage(String message) {
    rabbitTemplate.convertAndSend(HEADERS_EXCHANGE, "", message, m -> {
      m.getMessageProperties().getHeaders().put("header-key", "header-value");
      return m;
    });
  }

}
