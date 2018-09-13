package clases;

import java.util.concurrent.Semaphore;

public class Estacion {
	private Semaphore sem = new Semaphore(1, true);
	private double cantCombus;
	private double cantAutos;

	/*Constructor con una variable que indica la cantidad de combustible que puede almacenar la Estacion*/
	public Estacion(double cantCombus) {
		this.cantAutos = 0;
		this.cantCombus = cantCombus;
	}

	public void cargarCombus(Auto auto) {
/*Carga combustible en los autos que circulan, deberia "reiniciar" la variable de tanque llenarla con la cantidad 
 * que el auto deberia soporta como solo es simulacion todos los autos tienen exactamente 500 en los tanques
 * deberia cambiarse para ser una simulacion mas raalista*/
		
		
		try {
			sem.acquire();
			System.out.println("Cargando combustible en el auto: " + auto.getPatente() + " se tardara 5 seg" + "\n");
			auto.setTanque(500);
			Thread.sleep(5000);
			System.out.println("Carga finalizada en: " + auto.getPatente() + " ahora dispone de "
					+ (int) auto.getTanque() + " de km" + "\n");
			sem.release();
		} catch (InterruptedException e) {

		}
	}

	/*Metodos de observacion y modificacion*/
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
