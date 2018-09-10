package clases;

import utiles.Aleatorio;
import utiles.TecladoIn;

public class Auto extends Vehiculo implements Runnable {

	private String color;
	private Estacion est;
	private double KmActual, tanque, reserva;

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
		String resp;
		try {
			while (true) {
				if (tanque > 20) {
//				System.out.println("cuanto andara el auto " + this.getPatente() + ": ");
					km = Aleatorio.intAleatorio(1, ((int) tanque));
					this.andar(km);
//				System.out.print("¿Desea saber cuantos kilometros tiene?: ");
//				resp = TecladoIn.readLine();
//				if (resp.equals("si")) {
					System.out.println(
							"a recorrido " + (int) this.getKmActual() + " Km el auto: " + this.getPatente() + "\n");
//				}

					System.out.println("En el tanque le queda " + (int) this.getTanque() + " combustible al auto: "
							+ this.getPatente() + "\n");
				}
			}
		} catch (Exception e) {

		}
	}

	public void andar(double cantKm) throws InterruptedException {
		String resp = "";

		this.KmActual += cantKm;
		this.tanque -= cantKm;
		Thread.sleep((long) (cantKm * 100));
		if (this.tanque <= this.reserva) {
//			System.out.println("Esta utilizando la parte de reserva del tanque. ¿Desea cargar combustible?");
//			resp = TecladoIn.readLine();
			if (this.tanque < 20) {
				this.est.cargarCombus(this);
//			} else {
//				System.out.println("le queda poco combustible");
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
}
