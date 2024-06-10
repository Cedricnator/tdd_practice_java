package com.example.moiko_tdd_practice;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test de la clase Producto")
public class ProductoTest {
   Producto producto;

   @BeforeEach
   void setUp(){
      producto = new Producto();
   }


   @DisplayName("Test agregar código producto")
   @Test
   void testAgregarCodigoProductoRetornaElCodigoDelProducto(){
      producto.agregarCodigo("J1011221226");
      assertEquals(
         "J1011221226", 
         producto.getCodigo(),
         "El código del producto debe ser igual al ingresado"
      );
   }

   @DisplayName("Test agregar código producto sin inicial nombre retorna error")
   @Test
   void testAgregarCodigoProductoSinInicialNombreRetornaError(){      
      assertThrows(
         IllegalArgumentException.class, 
         () -> producto.agregarCodigo("11011221226"), 
         "El código del producto debe empezar con un caracter"
      );
   }

   @DisplayName("Test agregar código producto con letra minúscula retorna error")
   @Test
   void testAgregarCodigoProductoLetraMinusculaRetornaError(){
      assertThrows(
         IllegalArgumentException.class, 
         () -> producto.agregarCodigo("j1011221226"), 
         "El código del producto debe empezar con un caracter en mayúscula"
      );
   }

   @DisplayName("Test agregar código producto con formato inválido retorna error")
   @Test
   void testAgregarCodigoProductoFormatoInvalidoRetornaError(){
      
   }

   @DisplayName("Test agregar código producto con fecha actual inválida retorna error")
   @Test
   void testAgregarCodigoProductoFechaActualInvalidaRetornaError(){
   
   }

   @DisplayName("Test agregar nombre producto retorna el nombre del producto")
   @Test
   void testAgregarNombreProductoRetornaNombreProducto(){
      producto.agregarNombre("Jabón Copito");
      assertEquals(
         "Jabón Copito", 
         producto.getNombre(),
         "El nombre del producto debe ser igual al ingresado"
      );
   }

   @DisplayName("Test agregar nombre producto con caracteres mayores a 30 retorna error")
   @Test
   void testAgregarNombreProductoMayor30CaracteresRetornaError(){
      assertThrows(
         IllegalArgumentException.class, 
         () -> producto.agregarNombre("Este_Nombre_Tiene_Más_De_Treinta_Caracteres"), 
         "El nombre del producto no puede tener más de 30 caracteres"
      );
   }

   @DisplayName("Test agregar nombre producto vacío retorna error")
   @Test
   void testAgregarNombreProductoVacioRetornaError(){
      assertThrows(
         IllegalArgumentException.class, 
         () -> producto.agregarNombre(""), 
         "El nombre del producto no puede estar vacío"
      );
   }

   @DisplayName("Test agregar stock producto retorna stock producto")
   @Test
   void testAgregarStockProductoRetornaStockProducto(){
      String stockString = "100";
      Integer stockParsed = producto.convertirStringAEntero(stockString);
      producto.agregarStock(stockParsed);
      assertEquals(
         100, 
         producto.getStock()
      );
   }

   @DisplayName("Test agregar stock producto con valor negativo retorna error")
   @Test
   void testAgregarStockProductoNegativoRetornaError(){
      assertThrows(
         IllegalArgumentException.class, 
         () -> producto.agregarStock(-100), 
         "El stock del producto no puede ser negativo ni menor a 0"
      );
   }

   @DisplayName("Test agregar precio producto retorna precio producto")
   @Test
   void testAgregarPrecioProductoRetornaPrecioProducto(){
      String precioString = "100";
      Integer precioNumerico = producto.convertirStringAEntero(precioString);
      producto.agregarPrecio(precioNumerico);
      assertEquals(
         100, 
         producto.getPrecio(), 
         "El precio debe ser igual a lo que fue ingresado"
      );
   }

   @DisplayName("Test convertir debe recibir un string como número entero, sino lanza una exepcion")
   @Test
   void testAgregarPrecioProductoNoNumericoRetornaError(){
      assertThrows(
         IllegalArgumentException.class, 
         () -> producto.convertirStringAEntero("esto no es un número"), 
         "El precio del producto debe ser un número"
      );
   }

   @DisplayName("Test agregar precio producto con valor negativo retorna error")
   @Test
   void testAgregarPrecioProductoVacioRetornaError(){
      assertThrows(
         IllegalArgumentException.class, 
         () -> producto.agregarPrecio(0), 
         "El precio del producto no puede estar vacío"
      );
   }

   @DisplayName("Test se agrega correctamente el rut del proveedor")
   @Test
   void testAgregarRutProveedorRetornaRutProveedor(){
      producto.agregarRutProveedor("12.345.678-9");
      assertEquals(
         "12.345.678-9",
         producto.getRutProveedor()
      );
   }

   @DisplayName("Retorna error si el rut del proveedor es inválido")
   @Test
   void testAgregarRutProveedorInvalidoRetornaError(){
      assertThrows(
         IllegalArgumentException.class, 
         () -> producto.agregarRutProveedor("123456789"), 
         "El RUT del proveedor debe tener un formato válido"
      );
   }

   @DisplayName("Retorna error si el rut del proveedor no concuerda con el CSV")
   @Test
   void testAgregarRutProveedorNoConcuerdaConCsvRetornaError(){
      assertThrows(
         IllegalArgumentException.class, 
         () -> producto.agregarRutProveedor("12.345.678-0"), 
         "El RUT del proveedor no concuerda con el CSV"
      );
   }


   @DisplayName("Retorna el correo del proveedor")
   @Test
   void testCorreoProveedorRetornaCorreoProveedor(){
      producto.agregarCorreoProveedor("test@google.com");
      assertEquals(
         "test@google.com", 
         producto.getCorreoProveedor(),
         "El correo del proveedor debe ser igual al ingresado"
      );
   }

   @DisplayName("Retorna error si el correo del proveedor es inválido")
   @Test
   void testCorreoProveedorInvalidoRetornaError(){
      assertThrows(
         IllegalArgumentException.class, 
         () -> producto.agregarCorreoProveedor("testgoogle.com"), 
         "El correo del proveedor debe tener un formato válido"
      );
   }
}
