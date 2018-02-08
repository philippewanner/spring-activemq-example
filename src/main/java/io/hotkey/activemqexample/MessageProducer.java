package io.hotkey.activemqexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

@Component
public class MessageProducer {

   private static Logger LOGGER = LoggerFactory.getLogger(MessageProducer.class);

   @Autowired
   private JmsMessagingTemplate jmsMessagingTemplate;

   @Autowired
   private Queue textQueue;

   @Autowired
   private Queue personQueue;

   @Autowired
   private MessageCounter messageCounter;

   @Scheduled(fixedRate = 1000L)
   public void scheduler1() {
      final int count = messageCounter.increment();
      final String msg = "A dummy message";
      sendText(msg);
      LOGGER.info("Message {} was sent to the queue: {}", count, msg);

   }

   @Scheduled(fixedRate = 2100L)
   public void scheduler2() {
      final int count = messageCounter.increment();
      final Person person = new Person("firstName"+count, "lastName"+count, "email"+count);
      sendPerson(person);
      LOGGER.info("Message {} was sent to the queue: {}", count, person);

   }

   public void sendText(String msg) {
      this.jmsMessagingTemplate.convertAndSend(textQueue, msg);
   }

   public void sendPerson(Person person) {
      this.jmsMessagingTemplate.convertAndSend(personQueue, person);
   }
}
