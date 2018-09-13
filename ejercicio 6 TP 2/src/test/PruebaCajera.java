package test;
import clases.Cliente;
import clases.CajeraIncisoB;
public class PruebaCajera {

	public static void main(String[] args) {
		long initialTime = System.currentTimeMillis();
		
		Cliente cliente1 = new Cliente("Cliente 1" , new int[] {2,2,1,5,2,3});
		Cliente cliente2 = new Cliente("Cliente 2" , new int[] {1,3,5,1,1});
		
		//Tiempo inicial de referencia
		
		CajeraIncisoB cajera1 = new CajeraIncisoB("Cajera1" , 25 , cliente1 ,initialTime);
		CajeraIncisoB cajera2 = new CajeraIncisoB("Cajera2" , 27 , cliente2 , initialTime);
		
		Thread t1 = new Thread(cajera1);
		Thread t2 = new Thread(cajera2);
		
		
		t1.start();
		t2.start();
		
	}
	
}
