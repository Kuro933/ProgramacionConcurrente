package clases;

public class Yate extends Barco {

	private int numCamarote, poteCV;
	
	public Yate() {
		super();
		this.numCamarote = 0;
		this.poteCV = 0;
	}
	public Yate(int numeCamarote, int CV, String matricula, int anio, double eslora) {
		super(matricula,anio,eslora);
		this.numCamarote = numeCamarote;
		this.poteCV = CV;
	}
	
	public void setNumCamarote(int numeCamarote) {
		this.numCamarote = numeCamarote;
	}
	
	public int getCamarote() {
		return this.numCamarote;
	}
	
	public void setPotencia(int CV) {
		this.poteCV = CV;
	}
	
	public int getPotencia() {
		return this.poteCV;
	}
	
	public double calcularModulo() {
		double valor = 0;
		
		valor = super.calcularModulo() + (this.numCamarote + this.poteCV);
		
		return valor;
	}
	
	public String obtenerDatos() {
		String s="";
		
		
		s+= super.obtenerDatos() + "\n" + "Potencia de vapor: " + this.poteCV + "\n" + "Cantidad de Camarotes: " + this.numCamarote +
				"\n" + "El barco es un: " + this.getClass().getSimpleName();;
		
		
		return s;
	}
	
}
