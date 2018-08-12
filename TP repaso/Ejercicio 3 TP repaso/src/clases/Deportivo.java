package clases;

public class Deportivo extends Barco{


	private int poteCV;
	
	public Deportivo() {
		super();
		this.poteCV = 0;
	}
	public Deportivo (int CV, String matricula, int anio, double eslora) {
		super(matricula,anio,eslora);
		this.poteCV = CV;
	}
	
	public void setPotencia(int CV) {
		this.poteCV = CV;
	}
	
	public int getPotencia() {
		return this.poteCV;
	}
	
	public double calcularModulo() {
		double valor = 0;
		
		valor = super.calcularModulo() + this.poteCV;
		
		return valor;
	}

	public String obtenerDatos() {
		String s="";
		
		
		s+= super.obtenerDatos() + "\n" + "Potencia de vapor: " + this.poteCV + "\n" + "El barco es un: " + this.getClass().getSimpleName();;
		
		
		return s;
	}
	
	
}
