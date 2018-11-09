
public class TestLE {

	public static void main(String[] args){
		
		Libro libro = new Libro();
		
		for(int i = 0 ; i < 5 ; i++){
			Lector lect = new Lector(i,libro);
			Thread lector = new Thread(lect);
			lector.start();
		}
		
		for(int j = 0 ; j < 5 ; j++){
			Escritor escri = new Escritor(j,libro);
			Thread escritor = new Thread(escri);
			escritor.start();
		}
		
		
	}
}
