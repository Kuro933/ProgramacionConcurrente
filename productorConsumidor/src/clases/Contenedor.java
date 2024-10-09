package clases;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Contenedor {
    private final ArrayList<Integer> lista = new ArrayList<Integer>();
    private final int TAM;
    private final Semaphore poderProducir;
    private final Semaphore poderConsumir;
    private final Semaphore mutex;

    public Contenedor(int TAM) {
        this.TAM = TAM;
        this.poderProducir= new Semaphore(TAM);
        this.poderConsumir = new Semaphore(0);
        this.mutex = new Semaphore(1);
    }

    public void producir(int value) throws InterruptedException {
    	poderProducir.acquire();
        mutex.acquire();

        lista.add(value);
//        System.out.println("Producido: " + lista.toString());
        mutex.release();
        poderConsumir.release();
    }

    public int consumir() throws InterruptedException {
    	poderConsumir.acquire();
        mutex.acquire();

        int value = lista.getFirst();
        lista.removeFirst();
//        System.out.println("Consumido: " + lista.toString());

        mutex.release();
        poderProducir.release();

        return value;
    }

	public int getTAM() {
		return TAM;
	}
}