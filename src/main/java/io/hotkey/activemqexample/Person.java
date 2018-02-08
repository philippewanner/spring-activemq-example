package io.hotkey.activemqexample;

import lombok.Data;
import lombok.NonNull;

@Data
public class Person {

   @NonNull
   private String firstName;

   @NonNull
   private String lastName;

   private String emailAddress;

   public Person(){}

   public Person(String firstName, String lastName, String emailAddress){
      this.firstName = firstName;
      this.lastName = lastName;
      this.emailAddress = emailAddress;
   }
}
