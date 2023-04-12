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
					System.out.println("Error. Introduce n�meros mayores que 0:");
					comprobacion = true;
				}
			} while (comprobacion);

		} catch (InputMismatchException ime) { // Detecta si el dato introducido no es un n�mero y lanza un mensaje de
												// error
			System.out.println("S�lo puede escribir n�meros. Int�ntelo de nuevo: ");
			numero = filtrarNumero(); // Vuelve a solicitar el dato
		}
		// lectura.close();
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
	 * Algorithm tileFloor (tiles, n)
	 * current = 0
	 * set empty solution
	 * sort tiles in decreasing order
	 * while there is room for whole tiles do
	 * if room for size tile(current) then
	 * 		place tile of size tile(current)
	 * 		reduce available floor surface
	 * 		add one tile of size tile(current) to solution
	 * else
	 * 		current = current +1
	 * end_if
	 * 
	 * end_while
	 * return solution
	 */

	public static int[][] resolverColocacion(int tamSolar, int[] tamBaldosas) {
		int current = 0;
		int lado = tamSolar;
		int actual = 0;
		int tamano = tamBaldosas[actual];
		int resultado[][] = new int[tamSolar][tamSolar];
		for (int i = 0; i < resultado.length; i++) {
			for (int j = 0; j < resultado[i].length; j++) {
				while (resultado[i][j] == 0 && actual <= tamBaldosas.length - 1) {
					tamano = tamBaldosas[actual];
					if (cabeBaldosa(tamano, i, j, resultado, lado)) {
						for (int f = i; f < i + tamano; f++) {
							for (int c = j; c < j + tamano; c++) {
								resultado[f][c] = tamano;
							}
						}
						//puestas[actual]++;
					}else {
						actual++;
					}
				}
			}
		}
		while (current < resultado.length - 1) {

		}
		return resultado;
	}

	private static boolean cabeBaldosa(int tamano, int i, int j, int[][] resultado, int lado) {
		// TODO Auto-generated method stub
		return false;
	}
}
