package utiles;


public class Busqueda {

	public static int busquedaSecuencial(boolean[] a) {
		int pos = -1, i = 0, longitud = a.length;
		boolean encontrado = false;

		while (!encontrado && i < longitud) {
			if (a[i] == false) {
				encontrado = true;
				pos = i;
			} else
				i++;
		}

		return pos;
	}
}
