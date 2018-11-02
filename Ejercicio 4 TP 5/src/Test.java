import java.util.Random;

public class Test {
	private static Random rnd = new Random();

	public static void main(String[] args){
		Auto[] colAuto = new Auto[20];
		Puente puente = new Puente();
		
		for(int i=0; i<20;i++){
			colAuto[i] = new Auto(i, direccion(), puente);
		}
		
		for(int j=0; j<20; j++){
			Thread hilo = new Thread(colAuto[j]);
			hilo.start();
		}
	}
	
	
	public static String direccion(){
		String s=" ";
		
		int opcion = rnd.nextInt(2) ;
		
		if(opcion == 1){
			s = "norte";
		}else{
			s= "sur";
		}
		
		return s;
	}
}
