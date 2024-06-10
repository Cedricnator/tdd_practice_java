package com.example.moiko_tdd_practice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producto")
public class ControllerProducto {
   Producto producto = new Producto();
   Splitter splitter = new Splitter();

   @PostMapping("/")
   public ResponseEntity<?> create(@RequestBody ProductoRequest productoRequest) {
      try {
         String propiedadesProducto = productoRequest.getPropiedadesProducto();
         splitter.splitTextAndSave(propiedadesProducto, ",");
         producto.agregarCodigo(splitter.getPropiedadCodigo());
         producto.agregarNombre(splitter.getPropiedadNombre());
         Integer stock = producto.convertirStringAEntero(splitter.getPropiedadStock());
         producto.agregarStock(stock);
         Integer precio = producto.convertirStringAEntero(splitter.getPropiedadPrecio());
         producto.agregarPrecio(precio);
         producto.agregarRutProveedor(splitter.getPropeidadRUT());
         producto.agregarCorreoProveedor(splitter.getPropiedadCorreo());
         return new ResponseEntity<>(producto.toString(), HttpStatus.OK);
      } catch (Exception e) {
         System.out.println(e);
         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
   }
}
