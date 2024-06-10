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
      if (precio <= 0) {
         throw new IllegalArgumentException("El precio del producto no puede estar vacío");
      }
      this.precio = precio;
   }

   public void agregarRutProveedor(String rutProveedor){
      if (!esRutValido(rutProveedor)) {
         throw new IllegalArgumentException("El RUT no es valido");
      }
      this.rutProveedor = rutProveedor;
   }

   public void agregarCorreoProveedor(String correoProveedor){
      if (correoProveedor == "") {
         throw new IllegalArgumentException("El correo del proveedor no puede estar vacío");
      }
      if (!esCorreoValido(correoProveedor)) {
         throw new IllegalArgumentException("El correo no es valido");
      }
      this.correoProveedor = correoProveedor;
   }

   private boolean esRutValido(String rut) {
      try {
          rut = rut.toUpperCase();
          rut = rut.replace(".", "");
          rut = rut.replace("-", "");
          int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));
  
          char dv = rut.charAt(rut.length() - 1);
  
          int m = 0, s = 1;
          for (; rutAux != 0; rutAux /= 10) {
              s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
          }
          return dv == (char) (s != 0 ? s + 47 : 75);
      } catch (java.lang.NumberFormatException e) {
          return false;
      } catch (java.lang.Exception e) {
          return false;
      }
  }

   private boolean esCorreoValido(String correo){
      return correo.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
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
