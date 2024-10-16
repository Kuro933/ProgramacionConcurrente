package clases;
import java.util.Random;
public class Productor implements Runnable
{
    private final Random aleatorio;
    private final Contenedor contenedor;
    private final int idproductor;
    private final int TIEMPOESPERA = 1500;
 
    public Productor(Contenedor contenedor, int idproductor) 
    {
        this.contenedor = contenedor;
        this.idproductor = idproductor;
        aleatorio = new Random();
    }
 
    public void run() 
    {
        while(Boolean.TRUE)
        {
        	try
        	{
            int producto = aleatorio.nextInt(300);
            contenedor.producir(producto);
            System.out.println("El productor " + idproductor + " pone: " + producto);
                Thread.sleep(TIEMPOESPERA);
            } 
            catch (InterruptedException e) 
            {
                System.err.println("Productor " + idproductor + ": Error en run -> " + e.getMessage());
            }
        }
    }
}