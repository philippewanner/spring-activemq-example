package io.hotkey.activemqexample;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class MessageCounter {

   AtomicInteger counter = new AtomicInteger(0);

   public int increment() {
      return counter.incrementAndGet();
   }

   public int getCount() {
      return counter.get();
   }
}
