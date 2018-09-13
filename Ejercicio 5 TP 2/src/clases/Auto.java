package clases;

import utiles.Aleatorio;
import utiles.TecladoIn;

public class Auto extends Vehiculo implements Runnable {

	private String color;
	private Estacion est;
	private double KmActual, tanque, reserva;

	/*constructor de varias variables para instanciar cada una de los atributos del auto*/
	public Auto(String matricula, String model, String marca, double service, String color, double KmActual,
			Estacion estacion) {
		
		super(matricula, model, marca, service);
		this.color = color;
		this.KmActual = KmActual;
		this.reserva = 75;
		this.tanque = 500;
		this.est = estacion;
	}

	public void run() {
		int km = 0;
		/*un while(true) para que se mantenga en constante movimiento el algoritmo y hace andar a los autos cierta cantidad
		 * de kilometros que en este caso es random */
		String resp;
		try {
			while (true) {
				
					km = Aleatorio.intAleatorio(1, ((int) tanque));
					this.andar(km);
			}
		} catch (Exception e) {

		}
	}

	
	public void andar(double cantKm) throws InterruptedException {
		String resp = "";
/*Metodo andar que pone en marcha y hace recorrer cierta distancia establecida por parametro 
 * en caso de que disponga de poco combustible el auto lo hace ir a cargar combustible a una estacion*/
		this.KmActual += cantKm;
		this.tanque -= cantKm;
		Thread.sleep((long) (cantKm*10));
		if (this.tanque <= this.reserva) {

			System.out.println(
					"a recorrido " + (int) this.getKmActual() + " Km el auto: " + this.getPatente() + "\n");
			
			System.out.println("En el tanque le queda " + (int) this.getTanque() + " combustible al auto: "
					+ this.getPatente() + "\n");
			
			if (this.tanque < 20) {
				this.est.cargarCombus(this);
			}
			
			
		}
		if ((this.getKmService() - cantKm) <= 0) {
			System.out.println("Es hora de un service");
		}
	}

	/* Metodos de observacion y modificacion */
	public double getTanque() {
		return this.tanque;
	}

	public void setTanque(double tanque) {
		this.tanque = tanque;
	}

	public double getReserva() {
		return this.reserva;
	}

	public void setReserva(double reserva) {
		this.reserva = reserva;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getKmActual() {
		return this.KmActual;
	}

	public void setKmActual(double kmActual) {
		KmActual = kmActual;
	}

	public void setEst(Estacion est) {
		this.est = est;
	}

	public Estacion getEst() {
		return this.est;
	}
	/*fin de metodos de observacion y modificacion*/
}
