package io.hotkey.activemqexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

   private static Logger LOGGER = LoggerFactory.getLogger(MessageConsumer.class);

   @JmsListener(destination = "text.queue")
   public void receiveQueue(String text) {
      LOGGER.info(text);
   }

   @JmsListener(destination = "person.queue")
   public void receivePerson(Person person) {
      LOGGER.info("Person received: "+ person);
   }
}
