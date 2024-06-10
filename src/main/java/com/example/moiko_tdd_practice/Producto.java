package com.example.moiko_tdd_practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Producto {
   private String codigo;
   private String nombre;
   private Integer stock;
   private Integer precio;
   private String  rutProveedor;
   private String  correoProveedor;

   public Producto(){
   }

   public Integer convertirStringAEntero(String valor){
      try {
         return Integer.parseInt(valor);
      } catch (NumberFormatException e) {
         throw new IllegalArgumentException("El valor proporcionado no es un número válido");
      }
   }

 
   public void agregarCodigo(String codigo){
      String primerCaracter = codigo.substring(0, 1).toUpperCase();
      String fecha = codigo.substring(1);
   
      if (!Character.isLetter(primerCaracter.charAt(0))) {
         throw new IllegalArgumentException("El código del producto debe empezar con un caracter");
      }
      if (!Character.isUpperCase(primerCaracter.charAt(0))) {
         throw new IllegalArgumentException("El código del producto debe empezar con un caracter en mayúscula");
      }
   
      SimpleDateFormat formatoFecha = new SimpleDateFormat("MMddHHmmss");
      formatoFecha.setLenient(false);
      try {
         Date fechaValida = formatoFecha.parse(fecha);
         if (fechaValida.after(new Date())) {
            throw new IllegalArgumentException("La fecha en el código del producto no puede ser mayor a la fecha actual");
         }
      } catch (ParseException e) {
         throw new IllegalArgumentException("La fecha en el código del producto no es válida");
      }
   
      this.codigo = codigo;
   }
   
   public void agregarNombre(String nombre){
      if (nombre == "") {
         throw new IllegalArgumentException("El nombre del producto no puede estar vacío");
      }
      if (nombre.length() > 30) {
         throw new IllegalArgumentException("El nombre del producto no puede tener más de 30 caracteres");
      }
      this.nombre = nombre;
   }

   public void agregarStock(Integer stock){
      if (stock < 0) {
         throw new IllegalArgumentException("El stock del producto no puede ser negativo ni menor a 0");
      }
      this.stock = stock;
   }

   public void agregarPrecio(Integer precio){
      this.precio = precio;
   }

   public void agregarRutProveedor(String rutProveedor){
      this.rutProveedor = rutProveedor;
   }

   public void agregarCorreoProveedor(String correoProveedor){
      this.correoProveedor = correoProveedor;
   }

   public String getCodigo(){
      return this.codigo;
   }

   public String getNombre(){
      return this.nombre;
   }

   public Integer getStock(){
      return this.stock;
   }

   public Integer getPrecio(){
      return this.precio;
   }

   public String getRutProveedor(){
      return this.rutProveedor;
   }

   public String getCorreoProveedor(){
      return this.correoProveedor;
   }

}
