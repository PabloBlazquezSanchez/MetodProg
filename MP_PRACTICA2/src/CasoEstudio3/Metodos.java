package CasoEstudio3;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Metodos {

	public static int filtrarNumero() {
		int numero = 0;
		boolean comprobacion;
		Scanner lectura = new Scanner(System.in);
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
		//lectura.close();
		return numero;
	}

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

	private static boolean cabeBaldosa(int tamano, int i, int j, int[][] resultado, int lado) {
		boolean cabe = i + tamano <= lado && j +tamano <= lado;
			if (cabe) {
				for (int fila = i; cabe && fila < i+tamano; fila++) {
					for (int columna = j; cabe && columna < j+tamano; columna++) {
						if (resultado [fila][columna] != 0) {
							cabe=false;
						}
					}
				}
			}
		return false;
	}
}
