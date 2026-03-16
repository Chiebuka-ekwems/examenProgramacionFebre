package model;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class ProductoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ProductoTest
{
    /**
     * Default constructor for test class ProductoTest
     */
    public ProductoTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }
    
    
    
    /*@Test
    public void testGetters(){
        
    }*/
    
    @Test
    public void testGetPrecio(){
        //Triple AAA
        
        
        //Add - Activar, añadir, crear
        String codigoProducto = "CC112244A";
        String descripcion = "Portatil Asus AST-45";
        int stock = 4;
        double precio = -500;
        
        for(int i=0;i<1000;i++){
            
            
            Producto p = new Producto (codigoProducto,descripcion,precio,stock);
            
            double precioResultado = p.getPrecio();
            
            assertTrue(precio==precioResultado);
            
            precio +=1;
        }
        
        
        
        
        
        //Act - Actuar llamar a metodo, funcion, asignar
        
        
        
        //Assert - Aseguro que el resultao es el precio
        
    }
    
    @Test
    public void testCodigo(){
        
        String codigoProducto = "CC112244A";
        String codigoProductoFi = codigoProducto;
        String descripcion = "Portatil Asus AST-45";
        int stock = 4;
        double precio = 500;
        
        for(int i=0;i<1000;i++){
            
            
            Producto p = new Producto (codigoProducto,descripcion,precio,stock);
            
            String codigoResultado = p.getCodigoProducto();
            
            assertTrue(codigoProducto.equals(codigoResultado));            
            
            codigoProducto = codigoProductoFi;
            
            codigoProducto = codigoProducto + i;
        }
    }
    
    @Test
    public void testDescripcion(){
        String codigoProducto = "CC112244A";
        String descripcion = "Portatil Asus AST-45";
        int stock = 4;
        double precio = 500;
        
        for(int i=0;i<1000;i++){
            
            
            Producto p = new Producto (codigoProducto,descripcion,precio,stock);
            
            String descripcionResultado = p.getDescripcion();
            
            assertTrue(descripcion.equals(descripcionResultado));   
            
            
            
            descripcion = descripcion+ i;
        }
    }
    
    @Test
    public void testGetStock(){
        String codigoProducto = "CC112244A";
        String descripcion = "Portatil Asus AST-45";
        int stock = 4;
        double precio = -500;
        
        for(int i=0;i<1000;i++){
            
            
            Producto p = new Producto (codigoProducto,descripcion,precio,stock);
            
            double stockResultado = p.getStock();
            
            assertTrue(stock==stockResultado);
            
            stock +=1;
        }
    }
    
    //Setters
    @Test
    public void testSetPrecio(){
        String codigoProducto = "CC112244A";
        String descripcion = "Portatil Asus AST-45";
        int stock = 4;
        double precio = -499;
        double precioResultado = -500;
        for(int i=0;i<1000;i++){           
            
            Producto p = new Producto (codigoProducto,descripcion,precio,stock);
            
            p.setPrecio(precioResultado);
            double precioFinal = p.getPrecio();
            if(precioResultado>=0.0){
                assertTrue(precioFinal==precioResultado);
            } else {
              assertTrue(precioFinal==precio);
            }
            
            
            precioResultado +=1;
        }
    }
    
    @Test
    public void testSetCodigo(){
        String codigoProducto = "CC112244A";
        String codigoProductoFi = codigoProducto;
        String descripcion = "Portatil Asus AST-45";
        int stock = 4;
        double precio = 500;
        
        for(int i=0;i<1000;i++){
            
            
            Producto p = new Producto (codigoProducto,descripcion,precio,stock);
            p.setCodigoProducto(codigoProducto);
            String codigoResultado = p.getCodigoProducto();
            
            assertTrue(codigoProducto.equals(codigoResultado));            
            
            codigoProducto = codigoProductoFi;
            
            codigoProducto = codigoProducto + i;
        }
    }
    
    @Test
    public void testSetDescripcion(){
        String codigoProducto = "CC112244A";
        String descripcion = "Portatil Asus AST-45";
        int stock = 4;
        double precio = 500;
        
        for(int i=0;i<1000;i++){
            
            
            Producto p = new Producto (codigoProducto,descripcion,precio,stock);
            p.setDescripcion(descripcion);
            String descripcionResultado = p.getDescripcion();
            
            assertTrue(descripcion.equals(descripcionResultado));   
            
            
            
            descripcion = descripcion+ i;
        }
    }
    
    @Test
    public void testSetStock(){
        String codigoProducto = "CC112244A";
        String descripcion = "Portatil Asus AST-45";
        int stock = 4;
        double precio = 499;
        int stockResultado = -500;
        for(int i=0;i<1000;i++){           
            
            Producto p = new Producto (codigoProducto,descripcion,precio,stock);
            
            p.changeStock(stockResultado);
            int stockFinal = p.getStock();
            if(stock + stockResultado < 0){
                assertTrue(stock==stockFinal);
            } else {
              assertTrue((stockResultado+stock)==stockFinal);
            }
            
            
            stockResultado +=1;
        }
    }


    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
}