package io.hotkey.activemqexample;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.jms.Queue;

@SpringBootApplication
@EnableJms
@EnableScheduling
public class Application {

	@Bean
	public Queue textQueue() {
		return new ActiveMQQueue("text.queue");
	}

   @Bean
   public Queue personQueue() {
      return new ActiveMQQueue("person.queue");
   }

	@Bean
   public MessageConverter jacksonJmsMessageConverter() {
      MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
      converter.setTargetType(MessageType.TEXT);
      converter.setTypeIdPropertyName("_type");
      return converter;
   }

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
