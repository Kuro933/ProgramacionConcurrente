package test;
import clases.Escritor;

public class Test {

	public static void main(String[] args) {
		
		Escritor letterA = new Escritor('A', 0);
		Thread t1 = new Thread(letterA);
		Escritor letterB = new Escritor('B' , 1);
		Thread t2 = new Thread(letterB);
		Escritor letterC = new Escritor('C' , 2);
		Thread t3 = new Thread(letterC);
		
			t1.start();
			t2.start();
			t3.start();
		
	}
}
