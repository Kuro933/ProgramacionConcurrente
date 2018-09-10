package Test;
import clases.Estacion;
import clases.Auto;
public class test {

	public static void main(String[] args) {
		Estacion ypf= new Estacion(300000);
		Auto auto=new Auto("auto 1", "palio", "Fiat", 10000 ,"Rojo" , 0, ypf);
		Auto auto2=new Auto("auto 2", "GTX", "Audi", 10000, "Blanco", 0, ypf);
		Auto auto3=new Auto("auto 3", "GTX", "Audi", 10000, "Blanco", 0, ypf);
		Auto auto4=new Auto("auto 4", "GTX", "Audi", 10000, "Blanco", 0, ypf);
		Auto auto5=new Auto("auto 5", "GTX", "Audi", 10000, "Blanco", 0, ypf);
		Thread t1 = new Thread(auto); Thread t2 = new Thread(auto2);
		Thread t3 = new Thread(auto3);Thread t4 = new Thread(auto4);
		Thread t5 = new Thread(auto5);
	
		try {
		t1.start();	t2.start();	t3.start();	t4.start();	t5.start();
		t1.join();	t2.join();	t3.join();	t4.join();	t5.join();
		}catch(InterruptedException e) {
			
		}
	
	
		
	}
	
}
