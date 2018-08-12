package clases;

public class Barco {

	protected  String matricula;
	protected int anioF;
	protected double eslora;
	
	public Barco() {
		this.matricula = null;
		this.anioF = 0;
		this.eslora = 0;
	}
	
	public Barco (String matricula, int anio, double eslora) {
		this.matricula = matricula;
		this.anioF = anio;
		this.eslora = eslora;		
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getAnioF() {
		return anioF;
	}

	public void setAnioF(int anioF) {
		this.anioF = anioF;
	}

	public double getEslora() {
		return eslora;
	}

	public void setEslora(double eslora) {
		this.eslora = eslora;
	}
	
	public double calcularModulo() {
		double valor = 0;
		int multi = 10;
		
		valor = this.eslora * multi;
		
		return valor;
	}
	
	public String obtenerDatos() {
		String s="";
		
		s+= "Matricula: " + this.matricula + "\n" + "Anio Fabricacion: " + this.anioF + "\n" +  "Eslora: " + this.eslora;
		
		return s;
	}
	
	
}
