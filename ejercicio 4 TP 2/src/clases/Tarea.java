package clases;

public class Tarea implements Runnable{

	private int operacion;
	private Dato unDato;
	
	public Tarea (int ope, Dato dato) {
		this.operacion = ope;
		this.unDato = dato;
	}
	
	public void run(){
			 if(operacion == 1) {
				this.unDato.setVALOR(this.unDato.getVALOR() + 1);
			 }else {
				 this.unDato.setVALOR(this.unDato.getVALOR() * 2);
				 
			 }
		
	}

	public int getOperacion() {
		return operacion;
	}

	public void setOperacion(int operacion) {
		this.operacion = operacion;
	}

	public Dato getUnDato() {
		return unDato;
	}

	public void setUnDato(Dato unDato) {
		this.unDato = unDato;
	}
	
	
}
