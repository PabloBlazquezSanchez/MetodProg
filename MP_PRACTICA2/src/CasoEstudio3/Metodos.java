package CasoEstudio3;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Esta clase contiene los m�todos necesarios para la implementaci�n del
 * algoritmo voraz que nos permita resolver el problema. El algoritmo no es
 * �ptimo. Por ejemplo, si tenemos un solar de 4 metros y baldosas de tama�os 3,
 * 2 y 1 metros, el algoritmo pondr� una baldosa de 3x3 y quedar�n 7 huecos para
 * baldosas de 1x1 (tres huecos estar�n distribuidos horizontalmente y los otros
 * cuatro lo estar�n verticalmente), esto har�a que en total se tuviesen que
 * utilizar 7 baldosas. Lo optimo hubiese sido que se hubiesen usado cuatro
 * baldosas de 2x2, ya que en total se hubiesen cuatro baldosas.
 */
public class Metodos {

	/**
	 * Objeto de la clase Scanner que se utiliza para leer la entrada de datos desde
	 * la consola del usuario.
	 */
	static Scanner lectura = new Scanner(System.in);

	/**
	 * 
	 * Este m�todo captura el dato introducido por teclado y analiza si se ha
	 * introducido un caracter o un n�mero. Si se introduce un caracter lanza un
	 * mensaje de error y pide al usuario introducir un n�mero positivo, a trav�s de
	 * la excepci�n incluida en la API de Java "Input Mismatch Exception". Lo mismo
	 * ocurre si el n�mero introducido es igual o menor a cero, aunque en este caso
	 * concreto no aparecer� la excepci�n.
	 * 
	 * @return numero El n�mero escrito por el usuario
	 */

	public static int filtrarNumero() {
		int numero = 0;
		boolean comprobacion;
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
		return numero;
	}

	/**
	 * Este m�todo ordena un array de enteros de manera descendente. Primero, se
	 * utiliza el m�todo sort de Arrays para ordenar el array de menor a mayor.
	 * Despu�s, se intercambian los elementos del array, empezando por los extremos
	 * (el primero con el �ltimo, el segundo con el pen�ltimo, y as� sucesivamente)
	 * hasta llegar al centro, utilizando un bucle for.
	 * 
	 *
	 * @param tamanosBaldosas Array con los tama�os de las baldosas sin ordenar
	 * @return tamanosBaldosas Array con los tama�os de las baldosas ordenado de
	 *         manera descendente
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
	 * Este m�todo verifica si es posible colocar una baldosa en una posici�n dada
	 * dentro de la matriz resultado. Primero, se verifica que la baldosa no se
	 * salga del solar. Si esto sucede, se devuelve false, indicando que no cabe la
	 * baldosa. Luego, se recorren las casillas de la submatriz donde se intentar�
	 * colocar la baldosa, verificando que todas est�n libres (su valor en la matriz
	 * resultado es 0). Si alguna de ellas ya tiene una baldosa colocada, se
	 * devuelve false. Si se recorren todas las casillas sin encontrar ninguna
	 * ocupada, se devuelve true, indicando que cabe la baldosa en esa posici�n.
	 *
	 * 
	 * @param tamano    Tama�o de la baldosa a colocar
	 * @param i         Coordenada 'x' donde se intentar� colocar la baldosa
	 * @param j         Coordenada 'y' donde se intentar� colocar la baldosa
	 * @param resultado Representa el estado actual del solar
	 * @param lado      Tama�o del lado del solar.
	 * @return true - Si cabe la baldosa en esa posici�n
	 */
	private static boolean cabeBaldosa(int tamano, int i, int j, int[][] resultado, int lado) {
		boolean cabe = false;
		if (i + tamano <= lado && j + tamano <= lado) { // primero verifico que la baldosa est� dentro del solar
			cabe = true;
			for (int f = i; cabe && f < i + tamano; f++) {
				for (int c = j; cabe && c < j + tamano; c++) {
					if (resultado[f][c] != 0) {
						cabe = false; // miro que todas casillas candidatas est�n libres. En el momento que una no lo
										// est�, no cabe (condici�n extra de parada)
					}
				}
			}
		}
		return cabe;
	}
}
