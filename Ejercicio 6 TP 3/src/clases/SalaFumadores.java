package clases;

public class SalaFumadores {

	private boolean listoIngredUno, listoIngredDos,	puedoFumar;
	private boolean ingredienteUno, ingredienteDos, ingredienteTres;
	private int cont = 0, faltante;

	public SalaFumadores() {
		this.ingredienteUno = false;
		this.ingredienteDos = false;
		this.ingredienteTres = false;
		this.listoIngredUno = false;
		this.listoIngredDos = false;
		this.puedoFumar = false;
	}


	public synchronized void entrarFumar(int id) {

		try {
			while (id != this.faltante) {
				System.out.println("fumador " + id + " durmiendo");
				this.wait();
			}
		} catch (InterruptedException e) {
			System.err.println("Ocurrio un error inesperado");
			e.printStackTrace();
		}
		
	}

	public synchronized void colocar(int num) {

		try {
			while (this.cont==2) {
				System.out.println("agente durmiendo");
				System.out.println(cont);
				this.wait();
				this.cont = 0;
				this.limpiarMesa();
			}
		} catch (InterruptedException e) {
			System.err.println("Ocurrio un error inesperado");
			e.printStackTrace();
		}

		this.agregarIngred(num);
		
		if(cont==2){
		this.ingredFaltante();
		notifyAll();
		}
	}
	public synchronized void terminarFumar() {
		notifyAll();
	}

	public void limpiarMesa() {

		this.ingredienteUno = false;
		this.ingredienteDos = false;
		this.ingredienteTres = false;
	}
	
	public void agregarIngred(int num){
		
		/* Agente pone 2 de los 3 ingredentes*/
		if(num==1 && !this.ingredienteUno){
			System.out.println("Agente pone ingrediente 1");
			this.ingredienteUno = true;
			this.cont = this.cont + 1;
		}
		
		if(num==2 && !this.ingredienteDos){
			System.out.println("Agente pone ingrediente 2");
			this.ingredienteDos = true;
			this.cont = this.cont + 1;
		}
		
		if(num==3 && !this.ingredienteTres){
			System.out.println("Agente pone ingrediente 3");
			this.ingredienteTres = true;
			this.cont = this.cont + 1;
		}
		
	}
	
	public void ingredFaltante(){
		/*deberia darle order a quien le toca ¿como?*/
		
		if(this.ingredienteDos && this.ingredienteTres){
			this.faltante = 1;
		}else if(this.ingredienteUno && this.ingredienteTres){
			this.faltante = 2;
		}else if(this.ingredienteDos && this.ingredienteUno){
			this.faltante = 3;
		}
		
	}
}
