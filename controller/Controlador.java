package controller;
import model.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class Controlador
{
    // instance variables
    //ProductosA son mis productos activos
    private List <Producto> misProductosA;
    
    //ProductosR son mis producots retirados
    private List <Producto> misProductosR;
    
    //Singleton
    //poner aquí
    private static Controlador singleton;
    
    /**
     * Constructor for objects of class Controlador
     */
    private Controlador()
    {
        List<Producto> listaDeProductosInicial = DataAccess.loadData();    
        //Poner código aquí para que la lista inicial de productos esté
        //siempre disponible cuando se arranca el programa.
        misProductosA = new ArrayList<Producto>();
        misProductosR = new ArrayList<Producto>();
    }

    
    public static Controlador getSingleton()
    {
        // put your code here
        if(singleton==null) singleton = new Controlador();
        return singleton;
        // Modificado por Chiebuka return null;
    }
    
    //Crud Productos
    
    //Listar por Comparable Ascendente
    public String listarProductoComAsc(int opcion){
        String resultado="";
        List<Producto> misProductos = new ArrayList<Producto>();
        
        for (Producto p: misProductosA){
            misProductos.add(p);
        }
        
        for (Producto p: misProductosR){
            misProductos.add(p);
        }
        
        //Segun opcion
        switch (opcion){
            case 1:
                Collections.sort(misProductos, new CoProductoxCodigo());
                break;
            case 2:
                Collections.sort(misProductos, new CoProductoxPrecio());
                break;
            case 3:
                Collections.sort(misProductos, new CoProductoxStock());                
                break;
        }
        
        
        for (Producto p: misProductos){
            resultado += p.toString() + "\n";
        }
        
        return Producto.getCsvFormato() + "\n" + resultado;
    }
    //Listar por Comparable Descendente
    public String listarProductoComDes(int opcion){
        String resultado="";
        List<Producto> misProductos = new ArrayList<Producto>();
        
        for (Producto p: misProductosA){
            misProductos.add(p);
        }
        
        for (Producto p: misProductosR){
            misProductos.add(p);
        }
        
        //Segun opcion
        switch (opcion){
            case 1:
                Collections.sort(misProductos, new CoProductoxCodigo(){
                    @Override
                    public int compare(Producto p1, Producto p2){
                        return p2.getCodigoProducto().compareTo(p1.getCodigoProducto());
                    }
                });
                break;
            case 2:
                Collections.sort(misProductos, new CoProductoxPrecio(){
                    @Override
                    public int compare(Producto p1,Producto p2){
                        return (int)(p2.getPrecio()-p1.getPrecio());
                    }
                });
                break;
            case 3:
                Collections.sort(misProductos, new CoProductoxStock(){
                    @Override
                    public int compare(Producto p1,Producto p2){
                        return (p1.getStock()-p2.getStock());
                    }
                });                
                break;
        }
        
        
        for (Producto p: misProductos){
            resultado += p.toString() + "\n";
        }
        
        return Producto.getCsvFormato() + "\n" + resultado;
    }
    
    public String listarProductoSpire(String fecha){
        String resultado="";
        List<Producto> misProductos = new ArrayList<Producto>();
        
        int fechaInt = Integer.parseInt(fecha);
        
        for (Producto p : misProductosA) {
            if (p instanceof ProductoPerecedero) {
                ProductoPerecedero pp = (ProductoPerecedero) p;
                if (Integer.parseInt(pp.getFechaCaducidad()) < fechaInt) {
                    misProductos.add(pp);
                }
            }
        }
        
        for (Producto p : misProductosR) {
            if (p instanceof ProductoPerecedero) {
                ProductoPerecedero pp = (ProductoPerecedero) p;
                if (Integer.parseInt(pp.getFechaCaducidad()) < fechaInt) {
                    misProductos.add(pp);
                }
            }
        }
        
        for (Producto p : misProductos) {
            resultado += p.toString() + "\n";
        }
        
        return Producto.getCsvFormato() + "\n" + resultado;
    }
    
    
    public String listarProductos(){
        String resultado="";
        List<Producto> misProductos = new ArrayList<Producto>();
        
        for (Producto p: misProductosA){
            misProductos.add(p);
        }
        
        for (Producto p: misProductosR){
            misProductos.add(p);
        }
        
        Collections.sort(misProductos);
        
        for (Producto p: misProductos){
            resultado += p.toString() + "\n";
        }
        
        return Producto.getCsvFormato() + "\n" + resultado;
    }
    
    public String listarProductosRe(){
        String resultado="";
        List<Producto> misProductos = new ArrayList<Producto>();
        
        for (Producto p: misProductosR){
            misProductos.add(p);
        }
        
        //No se pide que tambien se muestre por orden de descripcion
        //Collections.sort(misProductos);
        
        for (Producto p: misProductos){
            resultado += p.toString() + "\n";
        }
        
        return Producto.getCsvFormato() + "\n" + resultado;
    }
    
    //Listar productos sin Stock
    public String listarProductoSinSt(){
        String resultado="";
        List<Producto> misProductos = new ArrayList<Producto>();
        
        for (Producto p: misProductosA){
            if(p.getStock()==0){
                misProductos.add(p);
            }
            
        }
        
        for (Producto p: misProductosR){
            if(p.getStock()==0){
                misProductos.add(p);
            }
            
        }
        
        Collections.sort(misProductos);
        
        for (Producto p: misProductos){
            resultado += p.toString() + "\n";
        }
        
        return Producto.getCsvFormato() + "\n" + resultado;
    }
    
    //Listar productos por precio
    public String listarProductosPrecio(int minimo, int maximo){
        String resultado="";
        List<Producto> misProductos = new ArrayList<Producto>();
        
        for (Producto p: misProductosA){
            if(p.getPrecio()>=minimo &&  p.getPrecio()<=maximo){
                misProductos.add(p);
            }
            
        }
        
        for (Producto p: misProductosR){
            if(p.getPrecio()>=minimo &&  p.getPrecio()<=maximo){
                misProductos.add(p);
            }
            
        }
        
        Collections.sort(misProductos);
        
        for (Producto p: misProductos){
            resultado += p.toString() + "\n";
        }
        
        return Producto.getCsvFormato() + "\n" + resultado;
    }
    
    public boolean deleteProducto(String codigoP){
        Producto p = getProductoPorCode(codigoP);
        
        if (p==null) return false;
        
        for (Producto pro: misProductosA){
            if(pro.getCodigoProducto().equals(codigoP)){
                misProductosR.add(pro);
                misProductosA.remove(pro);
                return true;
            }
        }
        return false;
    }
    
    public boolean updateStock (String codigoP, int nStock){
        //Cambiar
        Producto p = getProductoPorCode(codigoP);
        if(p!=null){
           p.changeStock(nStock);
           return true;
        }
        return false;  
        
    }
    
    public Producto getProductoPorCode(String codigo){
        for (Producto p: misProductosA){
            if(p.getCodigoProducto().equals(codigo))return p;
        }
        return null;
    }
    
    
    public boolean addProductoN (String csv){
        //String codigoProducto, String descripcion, double precio, int stock
        String[] datos = csv.split(";");
        
        Producto p = new Producto(datos[0],datos[1],Double.parseDouble(datos[2]),Integer.parseInt(datos[3]));
        
        for(Producto pro: misProductosA){
            if(pro.getCodigoProducto().equals(p.getCodigoProducto()))return false;
        }
        
        misProductosA.add(p);
        return true;
    }
    
    public boolean addProductoP (String csv){
        //String codigoProducto, String descripcion, double precio, int stock, String fecha caducidad
        String[] datos = csv.split(";");
        
        ProductoPerecedero p = new ProductoPerecedero
        (datos[0],datos[1],Double.parseDouble(datos[2]),Integer.parseInt(datos[3]),datos[4]);
        
        for(Producto pro: misProductosA){
            if(pro.getCodigoProducto().equals(p.getCodigoProducto()))return false;
        }
        
        misProductosA.add(p);
        return true;
    }
}