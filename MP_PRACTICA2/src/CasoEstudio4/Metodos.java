package CasoEstudio4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * The Class España2.
 */
public class Metodos {

	/**
	 * Calcular mejor solucion.
	 *
	 * @return the int[]
	 */
	public static int[] mejorSolucion() {
		Beca becas[] = leerFichero();
		int[] solucion = new int[becas.length];
		seleccion(new int[becas.length], solucion, 0, becas);
		return solucion;
	}

	/**
	 * Selection.
	 *
	 * @param x the x
	 * @param solucion the solucion
	 * @param level the level
	 * @param becas the becas
	 */
	public static void seleccion(int[] x, int[] solucion, int level, Beca[] becas) {
		if (level == becas.length) {
			if (esMejor(x, solucion, becas)) { // Caso base
				for (int i = 0; i < solucion.length; i++) {
					solucion[i] = x[i];
				}
			}
		} else {
			if (esCompatible(becas[level], x, level, becas)) {
				x[level] = 1; // Incluye la beca
				seleccion(x, solucion, level + 1, becas);
			}
			x[level] = 0; // No incluye la beca
			seleccion(x, solucion, level + 1, becas);
		}
	}

	/**
	 * Leer fichero.
	 *
	 * @return the beca[]
	 */
	public static Beca[] leerFichero() {
		String fichero = "Fellowships3400.dat";
		try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
			int longitud = Integer.parseInt(br.readLine());
			Beca becas[] = new Beca[longitud];
			for (int i = 0; i < longitud; i++) {
				String[] data = br.readLine().split("\t");
				int id = Integer.parseInt(data[0]);
				int inicio = Integer.parseInt(data[1]);
				int fin = Integer.parseInt(data[2]);
				int dinero = Integer.parseInt(data[3]);
				becas[i] = new Beca(id, inicio, fin, dinero); // inicializar la beca en la posición i del array
			}
			return becas;

		} catch (FileNotFoundException e) { // Si el fichero a buscar no existe lanza este mensaje de error y finaliza
											// el programa
			System.out.println("El fichero no existe en el directorio de búsqueda.\n"
					+ "El programa no puede continuar ejecutándose. Fin del Programa.");
			System.exit(0); // Finaliza el programa
		} catch (@SuppressWarnings("hiding") IOException e) { // Detecta otros errores
			System.out.println("El programa no puede continuar ejecutándose. Fin del Programa.");
			System.exit(0); // Finaliza el programa
		} catch (NumberFormatException e) {
			System.out.println("El archivo no se encuentra separado por '\\t' o tiene alguna letra.");
			System.exit(0); // Finaliza el programa

		}
		return null;
	}

	/**
	 * Checks if is compatible.
	 *
	 * @param becaProv the provisional
	 * @param x the x
	 * @param level the level
	 * @param becas the fellowships
	 * @return true, if is compatible
	 */
	public static boolean esCompatible(Beca becaProv, int[] x, int level, Beca[] becas) {
		boolean comp = true;
		for (int i = 0; i < level && comp; i++) {
			if (x[i] == 1) {
				Beca becaInd = becas[i];
				if (becaProv.getfInicio() <= becaInd.getfFin() && becaProv.getfFin() >= becaInd.getfInicio()) {
					comp = false;
				}
			}
		}
		return comp;
	}

	/**
	 * Checks if is best.
	 *
	 * @param x the x
	 * @param solucion the solution
	 * @param becas the fellowships
	 * @return true, if is best
	 */
	public static boolean esMejor(int[] x, int[] solucion, Beca[] becas) {
		int sx = 0, ss = 0;
		for (int i = 0; i < x.length; i++) {
			if (x[i] == 1) {
				sx += becas[i].getDinero();
			}
			if (solucion[i] == 1) {
				ss += becas[i].getDinero();
			}
		}
		return sx > ss;

	}
}
