package clases;
import java.util.concurrent.Semaphore;
public class Estacion {
	private Semaphore sem = new Semaphore(1,true);
	private double cantCombus;
	private double cantAutos;
	
	public Estacion(double cantCombus) {
		this.cantAutos = 0;
		this.cantCombus = cantCombus;
	}
	
	public void cargarCombus(Auto auto) {
		
		try {
		sem.acquire();
		System.out.println("Cargando combustible en el auto: " + auto.getPatente() + "se tardara 5 seg" + "\n");
		auto.setTanque(500);
		Thread.sleep(5000);
		sem.release();
		}catch(InterruptedException e) {
			
		}
	}

	public double getCantCombus() {
		return cantCombus;
	}

	public void setCantCombus(double cantCombus) {
		this.cantCombus = cantCombus;
	}

	public double getCantAutos() {
		return cantAutos;
	}

	public void setCantAutos(double cantAutos) {
		this.cantAutos = cantAutos;
	}
}
