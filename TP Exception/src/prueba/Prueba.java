package prueba;
import java.io.*;

public class Prueba {

	
	public static void main(String[] args) {
		
		try {
			System.out.println(metodo());
		}catch(Exception e) {
			System.err.println("Exception en metodo()" + "\n");
			e.printStackTrace();
		}
		
	}
	
	private static int metodo()  {
		int valor=0;
		
		try {
			valor = valor + 1;
			valor = valor + Integer.parseInt("42");
			valor = valor + 1;
			System.out.println("valor al final del bloque try: " + valor);
			
		}catch(Exception e){
			valor = valor + Integer.parseInt("42");
			System.out.println("valor al final del bloque catch: " + valor);
		}finally {
			valor = valor + 1;
			System.out.println("Valor al final del bloque finally: " + valor);
		}
		valor = valor + 1;
		System.out.println("Valor antes del valor return: " + valor);
		
		return valor;
	}
}
	