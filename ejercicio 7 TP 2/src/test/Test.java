package test;
import clases.Hamster;
import clases.Jaula;

public class Test {

	public static void main(String[] args) {
		Jaula prision = new Jaula(20);
		
		Hamster hamtaro = new Hamster("Hamtaro","Buena", prision);
		Hamster kile = new Hamster("Kile","Buena", prision);
		Hamster markus = new Hamster("Markus","Buena", prision);
		Hamster pierson = new Hamster("Pierson","Buena", prision);
		
		Thread t1 = new Thread(hamtaro);
		Thread t2 = new Thread(kile);
		Thread t3 = new Thread(markus);
		Thread t4 = new Thread(pierson);
		
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	
	}
}
