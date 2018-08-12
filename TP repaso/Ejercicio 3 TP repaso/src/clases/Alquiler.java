package clases;

import clases.Barco;


public class Alquiler {
	
	private Cliente unCliente;
	private int cantDias,posAmarre;
	private Barco unBarco;
	private double monto;
	
	public Alquiler() {
		this.unCliente = null;
		this.cantDias = 0;
		this.posAmarre = 0;
		this.unBarco = null;
		this.monto = 0;
	}
	
	public Alquiler(Cliente person, int cantDias,int posAma , Barco unBarco, double monto) {
		this.unCliente = person;
		this.cantDias = cantDias;
		this.posAmarre = posAma;
		this.unBarco = unBarco;
		this.monto = monto;
	}

	public Cliente getUnCliente() {
		return unCliente;
	}

	public void setUnCliente(Cliente unCliente) {
		this.unCliente = unCliente;
	}

	public int getCantDias() {
		return cantDias;
	}

	public void setCantDias(int cantDias) {
		this.cantDias = cantDias;
	}

	public int getPosAmarre() {
		return posAmarre;
	}

	public void setPosAmarre(int posAmarre) {
		this.posAmarre = posAmarre;
	}

	public Barco getUnBarco() {
		return unBarco;
	}

	public void setUnBarco(Barco unBarco) {
		this.unBarco = unBarco;
	}
	public void setMonto(double monto) {
		this.monto=monto;
	}
	public double getMonto() {
		return this.monto;
	}
	
	public double registarAlquiler(int nroAmarre, Barco unBarco, Cliente unCliente, int cantDias) {
		boolean exito= false;
		
		this.posAmarre = nroAmarre;
		this.unBarco = unBarco;
		this.unCliente = unCliente;
		this.cantDias = cantDias;
		
		this.monto = unBarco.calcularModulo() * cantDias;
			
		
		return this.monto;
	}
	
	public double calcularValor(int valorPuerto) {
		double valor=0;
		
		valor = ((this.unBarco.calcularModulo() * this.cantDias) + valorPuerto);
		
		return valor;
	}
	
	
	
	public String obtenerDatos() {
		String s="";
		
		s+= "Cliente" + "\n" +  this.unCliente.obtenerDatos() + "\n" + "Cantidad de dias: " + this.cantDias + "\n" + "Posicion Amarre: " + 
		this.posAmarre +"\n" + "Barco" + "\n" + this.unBarco.obtenerDatos();
	
		return s;
	}

}
