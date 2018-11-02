public class Auto implements Runnable {

	private int patente;
	private String direccion;
	private Puente puente;

	public Auto(int patente, String dire, Puente puente) {
		this.patente = patente;
		this.direccion = dire;
		this.puente = puente;
	}

	public void run() {
		try {

			
			if (this.direccion.equals("norte")) {
				System.out.println("auto "+ this.patente + "esta esperando " + this.direccion);
				puente.llegaNorte();
			} else if(this.direccion.equals("sur")){
				System.out.println("auto "+ this.patente + "esta esperando " + this.direccion);
				puente.llegaSur();
				
			}
			
			System.out.println("auto " + this.patente + " esta pasando el puente desde " + this.direccion);
			Thread.sleep(1000);
			
			if (this.direccion.equals("norte")) {
				puente.salirNorte();
			} else if(this.direccion.equals("sur")){
				puente.salirSur();
			}
			
			System.out.println("auto " + this.patente + " salio del puente");
		} catch (InterruptedException e) {

		}
	}
}
