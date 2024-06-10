package com.example.moiko_tdd_practice;

import java.util.ArrayList;
import java.util.List;

public class Splitter {
   List<String> productAtributes;
   
   Splitter(){
      productAtributes = new ArrayList<>();
   }

   private String[] splitText(String text, String separator){
      String[] splittedText = text.split(separator);
      if (splittedText.length == 0) {
         throw new IllegalArgumentException("El texto no puede ser dividido por el separador");
      }
      if (splittedText.length < 7) {
         throw new IllegalArgumentException("El texto le hace falta más propiedades");
      }
      return text.split(separator);
   }

   public void splitTextAndSave(String text, String separator){
      String[] splittedText = splitText(text, separator);
      for (String string : splittedText) {
         productAtributes.add(string);
      }
   }


}
