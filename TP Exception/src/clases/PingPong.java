package clases;

public class PingPong extends Thread{

	private String cadena;
	private int delay;
	
	public PingPong(String cartel, int ms) {
		
		this.cadena = cartel;
		this.delay = ms;
	}
	
	public void run() {
		for(int i=1; i<delay*10;i++) {
			System.out.println(cadena + " ");
			try {
				Thread.sleep(delay);
			}catch(InterruptedException e) {
				System.out.println("Osea. Que pedo man");
			}
		}
	}
	
}
