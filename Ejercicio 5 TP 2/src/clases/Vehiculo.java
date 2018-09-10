package clases;

public class Vehiculo {
	
	private String patente,modelo,marca;
	private double KmService;
	
	public Vehiculo(String matricula, String model, String marca, double service) {
		this.patente= matricula;
		this.modelo = model;
		this.marca = marca;
		this.KmService = service;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getKmService() {
		return KmService;
	}

	public void setKmService(double kmService) {
		KmService = kmService;
	}
	
	

}
