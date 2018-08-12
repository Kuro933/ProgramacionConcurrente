package clases;

public class Velero extends Barco {

	private int numMastil;
	
	public Velero() {
		super();
		this.numMastil = 0;
	}
	public Velero(int nume, String matricula, int anio, double eslora) {
		super(matricula,anio,eslora);
		this.numMastil = nume;
	}
	
	public void setNumMastil(int nume) {
		this.numMastil = nume;
	}
	
	public int getNumMastil() {
		return this.numMastil;
	}
	
	public double calcularModulo(){
		double valor = 0;
		
		valor = super.calcularModulo() + this.numMastil;
		
		
		return valor;
	}
	
	public String obtenerDatos() {
		String s="";
		
		
		s+= super.obtenerDatos() + "\n" + "Numero de mastiles: " + this.numMastil + "\n" + "El barco es un: " + this.getClass().getSimpleName();
		
		
		return s;
	}
	
}
