package clases;

public class Cliente extends Thread{

	private String nombre;
	private int[] carrito;
	
	public Cliente(String nomb, int[] arr) {
		this.nombre = nomb;
		this.carrito = arr;
	}
		 
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int[] getCarrito() {
		return carrito;
	}

	public void setCarrito(int[] carrito) {
		this.carrito = carrito;
	}
	
	public String toString() {
		String s="";
		
		for(int j=0; j<carrito.length;j++) {
			s += carrito[j] + " ";
		}
		
		return s;
	}
	
}
