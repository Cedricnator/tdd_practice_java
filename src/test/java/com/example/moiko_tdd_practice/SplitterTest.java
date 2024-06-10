package com.example.moiko_tdd_practice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SplitterTest {
   Splitter splitter;

   @BeforeEach
   void setUp(){
      splitter = new Splitter();
   }

   @Test
   void testSplitTextAndSave(){
      splitter.splitTextAndSave("J1011221226,Jabón Copito,200,990,16.827.524-1,proveedor@copito.com", ",");
      assertEquals(
         "J1011221226", 
         splitter.getPropiedadCodigo(),
         "El código del producto debe ser igual al ingresado"
      );
   }
}
