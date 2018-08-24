package clases;

public class CajeraIncisoA implements Runnable{
	private String nombre;
	private int idCajera;

	public void run(){
		
	}
	
	public CajeraIncisoA(String nomb, int iD) {
		this.nombre = nomb;
		this.idCajera = iD;
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

	public void procesarCompra(Cliente clien, long timeStamp) {
		System.out.println(
				"La cajera: " + this.nombre + " comienza a procesar la compra del cliente: " + clien.getNombre()
						+ " en el tiempo: " + (System.currentTimeMillis() - timeStamp) / 1000 + " Seg" + "\n");

		synchronized(this){
			for (int i = 0; i < clien.getCarrito().length; i++) {
			this.esperarXSegundos(clien.getCarrito()[i]);
			System.out.println("Procesado el producto " + (i + 1) + " -> Tiempo: "
					+ (System.currentTimeMillis() - timeStamp) / 1000 + " Seg");
		}
	}

		System.out.println("La cajera " + this.nombre + " Ha terminado de procesar " + clien.getNombre()
				+ " en el tiempo: " + (System.currentTimeMillis() - timeStamp) / 1000 + " Seg" + "\n");
	}

	private void esperarXSegundos(int seg) {
			try {
				Thread.sleep(seg*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
}