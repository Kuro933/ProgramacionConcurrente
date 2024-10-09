package clases;

public class Consumidor implements Runnable
{
    private final Contenedor contenedor;
    private final int idconsumidor;
 
    public Consumidor(Contenedor contenedor, int idconsumidor) 
    {
        this.contenedor = contenedor;
        this.idconsumidor = idconsumidor;
    }

    public void run() 
    {
        while(Boolean.TRUE)
        {
            try {
				System.out.println("El consumidor " + idconsumidor + " consume: " + contenedor.consumir());
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println("Hubo un error al consumir");
			}
        }
    }
}