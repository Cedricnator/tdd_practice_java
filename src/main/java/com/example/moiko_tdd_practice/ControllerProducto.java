package com.example.moiko_tdd_practice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/controllerproducto")
public class ControllerProducto {
   Producto producto = new Producto();
   Splitter splitter = new Splitter();

   @PostMapping("/")
   public ResponseEntity<?> create(@RequestBody String propiedadesProducto) {
      try {
         splitter.splitTextAndSave(propiedadesProducto, ",");
         producto.agregarCodigo(splitter.productAtributes.get(0));
         producto.agregarNombre(splitter.productAtributes.get(1));
         Integer stock = producto.convertirStringAEntero(splitter.productAtributes.get(2));
         producto.agregarStock( stock );
         Integer precio = producto.convertirStringAEntero(splitter.productAtributes.get(3));
         producto.agregarPrecio( precio );
         producto.agregarRutProveedor(splitter.productAtributes.get(4));
         producto.agregarCorreoProveedor(splitter.productAtributes.get(5));
         return new ResponseEntity<>(producto.toString(), HttpStatus.OK);
      } catch (Exception e) {
         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
   }  
}
