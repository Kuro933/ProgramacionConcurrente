package clases;

public class Escritor implements Runnable {

	private char letter;
	private Turno turn;
	private int numero;
	private double tiempo;

	public Escritor(char letra, int num) {
		this.letter = letra;
		this.turn = new Turno();
		this.numero = num;
		this.tiempo = System.currentTimeMillis();
	}

	public void run() {
		int veces = 0, cont = 0, cant = 0;

		String s = "";

		try {
			while (cont < 9) {
				if (this.numero == this.turn.getTurno()) {
					while (cant <= this.numero) {
						s += this.getLetter();
						cant++;
					}
					System.out.print(s);
				}
				s = "";
				cont++;
				cant = 0;
			}
		} catch (Exception e) {
		}

	}

	public Turno getTurn() {
		return turn;
	}

	public void setTurn(Turno turn) {
		this.turn = turn;
	}

	public char getLetter() {
		return letter;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}
}
