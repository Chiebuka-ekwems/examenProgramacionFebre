package model;
import java.util.Comparator;


/**
 * Write a description of class CoProductoxPrecio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CoProductoxPrecio implements Comparator<Producto>
{
    @Override
    public int compare(Producto p1,Producto p2){
        return (int)(p1.getPrecio()-p2.getPrecio());
    }
}