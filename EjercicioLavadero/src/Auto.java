import java.util.Random;

public class Auto implements Runnable {

	private Lavadero carWash;
	private Random rnd;
	private int id;

	public Auto(Lavadero lavadero, int id) {
		this.carWash = lavadero;
		rnd = new Random();
		this.id = id;
	}

	public void run() {
		carWash.entrarBoxLavado();
		this.lavar();
		carWash.salirBoxLavado();
		
		
		if ((rnd.nextInt(2)) == 1) { // random para ver si va quiere aspirar o no, si da 1 quiere aspirado, sino se
										// va
			if (carWash.entrarBoxEspera()) {
				System.out.println("AUTO " + id + " EN BOX DE ESPERA");
				int estacionAccedida = carWash.entrarEstacionAspiradora();
				System.out.println("auto " + id + "ha ingresado a la estacion " + estacionAccedida);
				switch (estacionAccedida) {
			
				case 1:
					carWash.aspirarEstacion1();
					this.aspirar();
					System.out.println("AUTO "+id+" esta por salir de la estacion 1");
					carWash.salirEstacion1();
					break;
				
				case 2:
					carWash.aspirarEstacion2();
					this.aspirar();
					System.out.println("AUTO "+id+" esta por salir de la estacion 2");
					carWash.salirEstacion2();
					break;
				
				case 3:
					carWash.aspirarEstacion3();
					this.aspirar();
					System.out.println("AUTO "+id+" esta por salir de la estacion 3");
					carWash.salirEstacion3();
					break;
				}

			} else {
				System.out.println("AUTO " + id + " NO HA PODIDO INGRESAR AL BOX, SE FUE");
			}
		}else {
			System.out.println("auto "+id+" NO SE LE CANTO ASPIRAR");
		}
		this.irseLavadero();
	}

	private void lavar() {
		System.out.println("Auto " + id + " lavandose");
		try {
			Thread.sleep((rnd.nextInt(7) + 3) * 1000);
			System.out.println("El auto " + id + " termino de lavarse");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void irseLavadero() {
		System.out.println("AUTO : " +id + " BYE BYE");
	}

	private void aspirar() {

		System.out.println("Auto "+id+" aspirando");
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}