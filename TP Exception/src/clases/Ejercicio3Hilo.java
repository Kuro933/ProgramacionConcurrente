package clases;

public class Ejercicio3Hilo {
	
	public static void main(String[] args) {
		
		Thread miHilo = new MiEjecucion();
		miHilo.start();
		
		System.out.println("En el main");
	}
}
