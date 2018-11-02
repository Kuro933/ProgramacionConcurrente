import java.util.concurrent.Semaphore;

public class Puente {

	private int cantNorte, cantSur;
	private Semaphore semNorte, semSur, semPuente;
	
	
	public Puente(){
		this.cantNorte = 0;
		this.cantSur = 0;
		this.semNorte = new Semaphore(1, true);
		this.semSur = new Semaphore(1, true);
		this.semPuente = new Semaphore(1,true);
	}
	
	public void llegaNorte() throws InterruptedException{
		this.semNorte.acquire();
		
		if(this.cantNorte == 0){
			this.semPuente.acquire();
		}
		
		this.cantNorte++;
		this.semNorte.release();
	}
	
	public void llegaSur()throws InterruptedException{
		this.semSur.acquire();
		
		if(this.cantSur == 0){
			this.semPuente.acquire();
		}
		
		this.cantSur++;
		this.semSur.release();
	}
	public void salirSur()throws InterruptedException{
		
		this.semSur.acquire();
		if(this.cantSur == 1){
			this.semPuente.release();
		}
		this.cantSur--;
		this.semSur.release();
	}
	
	public void salirNorte()throws InterruptedException{
		this.semNorte.acquire();
		
		if(this.cantNorte == 1){
			this.semPuente.release();
		}
		
		this.cantNorte--;
		this.semNorte.release();
	}
}
