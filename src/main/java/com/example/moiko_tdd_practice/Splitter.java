package com.example.moiko_tdd_practice;

import java.util.ArrayList;
import java.util.List;

public class Splitter {
   List<String> productAtributes;
   
   Splitter(){
      productAtributes = new ArrayList<>();
   }

   public String getPropiedadCodigo(){
      return productAtributes.get(0).trim();
   }

   public String getPropiedadNombre(){
      return productAtributes.get(1).trim();
   }

   public String getPropiedadStock(){
      return productAtributes.get(2).trim();
   }

   public String getPropiedadPrecio(){
      return productAtributes.get(3).trim();
   }

   public String getPropeidadRUT(){
      return productAtributes.get(4).trim();
   }

   public String getPropiedadCorreo(){
      return productAtributes.get(5).trim();
   }

   private String[] splitText(String text, String separator){
      String[] splittedText = text.split(separator);
      for (int i = 0; i < splittedText.length; i++) {
         splittedText[i] = splittedText[i].trim();
      }
      if (splittedText.length == 0) {
         throw new IllegalArgumentException("El texto no puede ser dividido por el separador");
      }
      if (splittedText.length < 6) {
         throw new IllegalArgumentException("El texto le hace falta más propiedades");
      }
      return splittedText;
   }

   public void splitTextAndSave(String text, String separator){
      // Eliminar las comillas dobles del inicio y del final de la cadena
      text = text.replace("\"", "");
      text = text.replace("propiedadesProducto:", "");
      text.trim();
      String[] splittedText = splitText(text, separator);
      for (String string : splittedText) {
         productAtributes.add(string);
      }
  }
}
