package clases;
import utiles.Busqueda;

public class Puerto {
	
	private int valor;
	private Lista alquiler;
	private boolean[] amarres;

	
	public Puerto(int valo) {
		this.valor = valo;
		this.amarres = new boolean[20];
		alquiler = new Lista();
	}


	public int getValor() {
		return valor;
	}


	public void setValor(int valor) {
		this.valor = valor;
	}


	public Lista getAlquiler() {
		return alquiler;
	}


	public void setAlquiler(Lista alquiler) {
		this.alquiler = alquiler;
	}


	public boolean[] getAmarres() {
		return amarres;
	}


	public void setAmarres(boolean[] amarres) {
		this.amarres = amarres;
	}
	
	
	public int buscarAmarreDisp() {
		int pos=Integer.MIN_VALUE;
		
		try {
		pos = Busqueda.busquedaSecuencial(amarres);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("No hay lugar");
		}
		return pos;
	}
	
	public Alquiler buscarAlquiler(int pos) {
		return (Alquiler)alquiler.recuperar(pos);
		
	}
	
	
}
