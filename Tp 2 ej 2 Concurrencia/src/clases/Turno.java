package clases;
import java.util.concurrent.Semaphore;

public class Turno {

	private int numero;
	private Semaphore sem = new Semaphore(1,true);
	
	public Turno() {
	this.numero = 0;
	}
	
		
	public void aumentarTurno() {
		this.numero = ((numero + 1) % 3);
	}

	public int getTurno() throws InterruptedException {
		int num;
		sem.acquire();
	
		num = this.numero;
		Thread.sleep(5);
		
		this.aumentarTurno();
		sem.release();
		
		return num;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
}
