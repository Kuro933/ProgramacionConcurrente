package Test;
import clases.*;
public class ProductorConsumidor 
{
    private static Contenedor contenedor;
    private static Thread[] productores;
    private static Thread[] consumidores;
    private static final int CANTIDADCONSUMIDORES = 0;
    private static final int CANTIDADPRODUCTORES= 1;

    public static void main(String[] args) 
    {
        contenedor = new Contenedor(2);
        consumidores = new Thread[CANTIDADCONSUMIDORES];
        productores = new Thread[CANTIDADPRODUCTORES];

 
        for(int i = 0; i < CANTIDADCONSUMIDORES; i++)
        {
            consumidores[i] = new Thread(new Consumidor(contenedor, i));
            consumidores[i].start();
        }
        
        for(int i = 0; i < CANTIDADPRODUCTORES; i++)
        {
            productores[i] = new Thread(new Productor(contenedor, i));
            productores[i].start();
        }
         
    }    
}
