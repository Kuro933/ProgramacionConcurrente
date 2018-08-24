package clases;
import java.util.Scanner;


public class PruebaExcep {
	
	private final static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int edad=0;
	do {	
		System.out.print("edad?: ");
		edad = sc.nextInt();
		try {
		menorEdad(edad);
		System.out.println("usted es mayor de edad");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}while(edad < 18);
	}
	
	
	private static void menorEdad(int edad) throws Exception {
		if(edad<18) {
			throw new Exception("Es menor de edad");
		}		
	}
	
}
