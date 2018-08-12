package test;
import clases.Velero;
import clases.Cliente;
import clases.Barco;
import clases.Deportivo;
import clases.Yate;
import utiles.TecladoIn;
import clases.Alquiler;
import clases.Puerto;

public class Test {

public static void main (String[] args) {
	
	Puerto puerto= new Puerto(200);	

	System.out.println("el monto del alquiler sera de: " + registrarAlquiler(puerto,cargarCliente(),cargarVelero()));
	
	System.out.println("el alquiler tendra los datos siguientes: " + "\n" + puerto.buscarAlquiler(1).obtenerDatos());
	
}

public static Cliente cargarCliente() {
	//cambiar para que se pregunte y se cree muchos clientes distintos
	String nombre,apellido,dni;
	
	nombre = "Federico";
	apellido = "Gonzalez";
	dni = "37869308";
	
	Cliente unCliente = new Cliente(nombre,apellido,dni);
	
	return unCliente;
}

public static Velero cargarVelero() {
	//cambiar para que se pregunte y se cree muchos barcos distintos
	
	String matricula="ab de 21";
	int anio = 1936 , mastil = 3;
	double eslora = 30;
	
	Velero velerito = new Velero(mastil, matricula,anio,eslora);
	
	return velerito;
}

public static double registrarAlquiler(Puerto puerto,Cliente unCliente,Barco unBarco) {
	int valor = puerto.getValor() , pos = puerto.buscarAmarreDisp(),cantDias =0;
	double montoTotal = 0;	
	char respuesta;
	Alquiler alquiler = new Alquiler();
	
		System.out.print("¿Cuantos dias sera alquilado?: ");
		cantDias = TecladoIn.readLineInt();	
		
		
		montoTotal = (alquiler.registarAlquiler(pos, unBarco, unCliente, cantDias) + valor);
		
		System.out.println("el monto seria: " + montoTotal + "\n" + "¿Desea registar el alquiler?: ");
		respuesta = TecladoIn.readNonwhiteChar();
		
		if(respuesta == 'y') {
		puerto.getAlquiler().insertar(alquiler,puerto.getAlquiler().longitud()+1 );
		}else {
			
		}
		
		return montoTotal;
}
	
}
