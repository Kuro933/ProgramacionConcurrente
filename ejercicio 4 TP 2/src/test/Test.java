package test;

import clases.*;

public class Test {

	public static void main(String[] args) {
		Dato dato = new Dato();
		Tarea tarea1 = new Tarea(1, dato);
		Tarea tarea2 = new Tarea(2, dato);

		Thread t1 = new Thread(tarea1);
		Thread t2 = new Thread(tarea2);

		try {
			t1.start();
			t2.start();
			t1.join();
			t2.join();
			
			System.out.println(dato.getVALOR());
		} catch (InterruptedException e) {

		}
	}
}
