package com.example.springrabbitmq;

import com.example.springrabbitmq.producer.MessageProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringRabbitmqApplication implements CommandLineRunner {

	private final MessageProducer messageProducer;

	public static void main(String[] args) {
		SpringApplication.run(SpringRabbitmqApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		messageProducer.sendDirectMessage("Direct message");
		messageProducer.sendFanoutMessage("Fanout message");
		messageProducer.sendTopicMessage("Topic message");
		messageProducer.sendHeadersMessage("Headers message");
	}

}
