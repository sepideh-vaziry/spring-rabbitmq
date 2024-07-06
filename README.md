# Spring Boot RabbitMQ Demo

This project demonstrates how to use all types of RabbitMQ exchanges (Direct, Fanout, Topic, and Headers) 
with a Spring Boot application. It includes configuration, producer, and consumer examples for each 
type of exchange.

## Project Structure
    ```
    src
    └── main
    ├── java
    │ └── com.example.springrabbitmq
    │   ├── SpringRabbitmqApplication.java
    │   ├── config
    │   │ └── RabbitmqConfig.java
    │   │ └── RabbitMQDirectExchangeConfig.java
    │   │ └── RabbitMQFanoutExchangeConfig.java
    │   │ └── RabbitMQHeadersExchangeConfig.java
    │   │ └── RabbitMQTopicExchangeConfig.java
    │   ├── producer
    │   │ └── MessageProducer.java
    │   └── consumer
    │     └── DirectMessageConsumer.java
    │     └── FanoutMessageConsumer.java
    │     └── HeaderMessageConsumer.java
    │     └── TopicMessageConsumer.java
    └── resources
        └── application.properties
    ```