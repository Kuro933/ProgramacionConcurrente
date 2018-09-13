package clases;
import java.util.concurrent.Semaphore;
public class Dato {
	
	private int VALOR;
	private Semaphore sem = new Semaphore(1,true);
	public Dato() {
		this.VALOR = 3;
	}

	public int getVALOR() {
		int valor=0; 
		try {
		sem.acquire();
		valor = this.VALOR;
		sem.release();
		}catch(InterruptedException e) {
			System.err.println("ocurrio un suceso inesperado");
		}
	
		return valor;
	}

	public void setVALOR(int val) {
		
		VALOR = val;
	}
}
