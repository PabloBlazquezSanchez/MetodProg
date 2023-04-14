package CasoEstudio3;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class Metodos. El algoritmo no es óptimo. Por ejemplo, si
 * tenemos un solar de 4 metros y baldosas de tamaños 3, 2 y 1 metros, el
 * algoritmo pondrá una baldosa de 3x3 y quedarán 7 huecos para baldosas de 1x1
 * (tres huecos estarán distribuidos horizontalmente y los otros cuatro lo
 * estarán verticalmente), esto haría que en total se tuviesen que utilizar 7
 * baldosas. Lo optimo hubiese sido que se hubiesen usado cuatro baldosas de
 * 2x2, ya que en total se hubiesen cuatro baldosas.
 */
public class Metodos {

	/** The lectura. */
	static Scanner lectura = new Scanner(System.in);
	
	/**
	 * 
	 * Este método captura el dato introducido por teclado y analiza si se ha
	 * introducido un caracter o un número. Si se introduce un caracter lanza un
	 * mensaje de error y pide al usuario introducir un número positivo, a través de
	 * la excepción incluida en la API de Java "Input Mismatch Exception". Lo mismo
	 * ocurre si el número introducido es igual o menor a cero, aunque en este caso
	 * concreto no aparecerá la excepción.
	 * 
	 * @return numero El número escrito por el usuario
	 */
	
	public static int filtrarNumero() {
		int numero = 0;
		boolean comprobacion;
		try {
			do {
				comprobacion = false;
				numero = lectura.nextInt();

				if (numero <= 0) {
					System.out.println("Error. Introduce números mayores que 0:");
					comprobacion = true;
				}
			} while (comprobacion);

		} catch (InputMismatchException ime) { // Detecta si el dato introducido no es un número y lanza un mensaje de
												// error
			System.out.println("Sólo puede escribir números. Inténtelo de nuevo: ");
			numero = filtrarNumero(); // Vuelve a solicitar el dato
		}
		return numero;
	}

	/**
	 * Ordenar array.
	 *
	 * @param tamanosBaldosas the tamanos baldosas
	 * @return the int[]
	 */
	public static int[] ordenarArray(int[] tamanosBaldosas) {
		Arrays.sort(tamanosBaldosas);
		for (int i = 0, j = tamanosBaldosas.length - 1, tmp; i < j; i++, j--) {
			tmp = tamanosBaldosas[i];
			tamanosBaldosas[i] = tamanosBaldosas[j];
			tamanosBaldosas[j] = tmp;
		}
		return tamanosBaldosas;
	}

	/*
	 * Algorithm tileFloor (tiles, n) current = 0 set empty solution sort tiles in
	 * decreasing order while there is room for whole tiles do if room for size
	 * tile(current) then place tile of size tile(current) reduce available floor
	 * surface add one tile of size tile(current) to solution else current = current
	 * +1 end_if
	 * 
	 * end_while return solution
	 */

	/**
	 * Resolver colocacion.
	 *
	 * @param tamSolar    the tam solar
	 * @param tamBaldosas the tam baldosas
	 * @return the int[][]
	 */
	public static int[][] resolverColocacion(int tamSolar, int[] tamBaldosas) {
		int size = tamSolar;
		int actual = 0;
		int tamano = tamBaldosas[actual];
		int floor[][] = new int[tamSolar][tamSolar];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				while (floor[i][j] == 0 && actual <= tamBaldosas.length - 1) {
					tamano = tamBaldosas[actual];
					if (cabeBaldosa(tamano, i, j, floor, size)) {
						for (int f = i; f < i + tamano; f++) {
							for (int c = j; c < j + tamano; c++) {
								floor[f][c] = tamano;
							}
						}
						// puestas[actual]++;
					} else {
						actual++;
					}
				}
			}
		}
		return floor;
	}

	/**
	 * Cabe baldosa.
	 *
	 * @param tamano    the tamano
	 * @param i         the i
	 * @param j         the j
	 * @param resultado the resultado
	 * @param lado      the lado
	 * @return true, if successful
	 */
	private static boolean cabeBaldosa(int tamano, int i, int j, int[][] resultado, int lado) {
		boolean cabe = false;
		if (i + tamano <= lado && j + tamano <= lado) { // primero verifico que la baldosa esté dentro del solar
			cabe = true;
			for (int f = i; cabe && f < i + tamano; f++) {
				for (int c = j; cabe && c < j + tamano; c++) {
					if (resultado[f][c] != 0) {
						cabe = false; // miro que todas casillas candidatas estén libres. En el momento que una no lo
										// esté, no cabe (condición extra de parada)
					}
				}
			}
		}
		return cabe;
	}
}
