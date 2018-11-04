import java.util.concurrent.locks.*;

public class Lavadero {

	private int boxEsperaDisp, boxEsperaOcupados, cantEstaciones, cantAutosPorEstacion, autosEst1, autosEst2, autosEst3,
			autoEnBoxLimpieza, autoEnEstacion, autoEnAspiradora1, autoEnAspiradora2, autoEnAspiradora3;

	private Lock cerrojo;
	private Condition boxEntrada, boxEspera, aspiradora1, aspiradora2, aspiradora3;

	public Lavadero(int cantBoxes, int cantEspera, int capacidadEstacion, int cantEstacionesAspirado) {
		this.boxEsperaDisp = cantEspera;
		this.boxEsperaOcupados = 0;
		this.autoEnBoxLimpieza = 0;
		this.cantAutosPorEstacion = capacidadEstacion;
		this.autoEnEstacion = 0;
		this.autosEst1 = 0;
		this.autosEst2 = 0;
		this.autosEst3 = 0;
		this.autoEnAspiradora1 = 0;
		this.autoEnAspiradora2 = 0;
		this.autoEnAspiradora3 = 0;
		this.cantEstaciones = cantEstacionesAspirado;
		this.cerrojo = new ReentrantLock();
		this.boxEntrada = cerrojo.newCondition();
		this.boxEspera = cerrojo.newCondition();
		this.aspiradora1 = cerrojo.newCondition();
		this.aspiradora2 = cerrojo.newCondition();
		this.aspiradora3 = cerrojo.newCondition();
	}

	public void entrarBoxLavado() {
		try {
			cerrojo.lock();
			while (autoEnBoxLimpieza >= 4) {
				boxEntrada.await();
			}
			this.autoEnBoxLimpieza++;
			System.out.println("Auto entró lavadero");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			cerrojo.unlock();
		}
	}

	public void salirBoxLavado() {
		cerrojo.lock();
		autoEnBoxLimpieza--;
		boxEntrada.signal();
		cerrojo.unlock();
	}

	public boolean entrarBoxEspera() {
		boolean exito = false;
		try {
			cerrojo.lock();
			if (boxEsperaOcupados < boxEsperaDisp) {
				boxEsperaOcupados++;
				exito = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cerrojo.unlock();
		}
		return exito;
	}

	public int entrarEstacionAspiradora() {
		int estacionIngresada = 0;
		try {
			cerrojo.lock();
			// una vez que lo obtengo me fijo cual es la estacion

			this.autoEnEstacion++;
			while (autoEnEstacion > this.cantEstaciones) {
				boxEspera.await();
			}

			if (autosEst1 < cantAutosPorEstacion) {
				autosEst1++;
				estacionIngresada = 1;

			} else if (autosEst2 < cantAutosPorEstacion) {
				autosEst2++;
				estacionIngresada = 2;

			} else if (autosEst3 < cantAutosPorEstacion) {
				autosEst3++;
				estacionIngresada = 3;

			}

			boxEsperaOcupados--;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			cerrojo.unlock();
		}

		return estacionIngresada;

	}

	public void aspirarEstacion1() {
		try {
			cerrojo.lock();
			if(this.autoEnAspiradora1 == 1) {
				aspiradora1.await();
			}
			this.autoEnAspiradora1++;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			cerrojo.unlock();
		}
	}

	public void aspirarEstacion2() {
		try {
			cerrojo.lock();
			if(this.autoEnAspiradora2 == 1) {
				aspiradora2.await();
			}
			this.autoEnAspiradora2++;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			cerrojo.unlock();
		}
	}

	public void aspirarEstacion3() {
		try {
			cerrojo.lock();
			if(this.autoEnAspiradora3 == 1) {
				aspiradora3.await();
			}
			this.autoEnAspiradora3++;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			cerrojo.unlock();
		}
	}

	public void salirEstacion1() {

		try {

			cerrojo.lock();

			this.autoEnAspiradora1--;
			this.autosEst1--;
			this.autoEnEstacion--;
			boxEspera.signalAll();
			aspiradora1.signal();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cerrojo.unlock();
		}
	}

	public void salirEstacion2() {

		try {
			cerrojo.lock();

			this.autoEnAspiradora2--;
			this.autoEnEstacion--;
			autosEst2--;
			boxEspera.signalAll();
			aspiradora2.signal();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cerrojo.unlock();
		}
	}

	public void salirEstacion3() {
		try {
			cerrojo.lock();

			this.autoEnAspiradora3--;
			this.autoEnEstacion--;
			autosEst3--;
			boxEspera.signalAll();
			aspiradora3.signal();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cerrojo.unlock();
		}
	}
}