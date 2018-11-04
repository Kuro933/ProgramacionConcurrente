public class TestLavadero {

	
	public static void main(String [] args) {
				
		
		Lavadero carWash=new Lavadero(4,2,2,6);
		try{
			generarAutos(carWash);
		}catch(InterruptedException e) {
			
		}
		
	}
	
	
	public static void generarAutos(Lavadero carWash) throws InterruptedException{
		int i;
		Auto [] arrAutos=new Auto[10];
		for(int j=0;j<arrAutos.length;j++) {
			arrAutos[j]=new Auto(carWash,j);
		}
		for(int k=0;k<arrAutos.length;k++) {
			Thread hilo=new Thread(arrAutos[k]);
			hilo.start();
		}
		i=arrAutos.length;
		while(true) {
			Auto car=new Auto(carWash,i);
			Thread hilo=new Thread(car);
			hilo.start();
			Thread.sleep(5000);
			i++;
		}
	}
}