package clases;

public class CajeraIncisoB implements Runnable {
	private String nombre;
	private int idCajera;
	private Cliente clien;
	private long initialTime;

	public CajeraIncisoB(String nomb, int iD, Cliente cliente, long iniTime) {
		this.nombre = nomb;
		this.idCajera = iD;
		this.clien = cliente;
		this.initialTime = iniTime;
	}

	public void run() {
		System.out.println("La cajera: " + this.nombre
				+ " comienza a procesar la compra del cliente: "
				+ this.clien.getNombre() + " en el tiempo: "
				+ (System.currentTimeMillis() - initialTime) / 1000 + " Seg"
				+ "\n");

		for (int i = 0; i < this.clien.getCarrito().length; i++) {
			this.esperarXSegundos(this.clien.getCarrito()[i]);
			System.out.println("Procesado el producto " + (i + 1)
					+ "del cliente: " + this.clien.getNombre() + " -> Tiempo: "
					+ (System.currentTimeMillis() - initialTime) / 1000
					+ " Seg");
		}

		System.out.println("La cajera " + this.nombre
				+ " Ha terminado de procesar " + this.clien.getNombre()
				+ " en el tiempo: "
				+ (System.currentTimeMillis() - initialTime) / 1000 + " Seg"
				+ "\n");
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIdCajera() {
		return idCajera;
	}

	public void setIdCajera(int idCajera) {
		this.idCajera = idCajera;
	}

	private void esperarXSegundos(int seg) {
		try {
			Thread.sleep(seg * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}