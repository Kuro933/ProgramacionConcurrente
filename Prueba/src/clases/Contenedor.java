package clases;

public class Contenedor 
{
    private int contenido=0;
    private boolean contenedorlleno = Boolean.FALSE;
    private Cola cola = new Cola();
    /**
     * Obtiene de forma concurrente o síncrona el elemento que hay en el contenedor
     * @return Contenido el contenedor
     */
    public synchronized int get()
    {
        while (contenido==0)
        {
            try
            {
                wait();
            } 
            catch (InterruptedException e) 
            {
                System.err.println("Contenedor: Error en get -> " + e.getMessage());
            }
        }
        int elemento = cola.obtenerFrente();
        cola.sacar();
        contenido--;
        notify();
        return elemento;
    }
 
    /**
     * Introduce de forma concurrente o síncrona un elemento en el contenedor
     * @param value Elemento a introducir en el contenedor
     */
    public synchronized void put(int value) 
    {
        while (contenido>=3) 
        {
            try
            {
                wait();
            } 
            catch (InterruptedException e) 
            {
                System.err.println("Contenedor: Error en put -> " + e.getMessage());
            }
        }
        cola.poner(value);
        contenido++;
        notify();
    }
}