package CasoEstudio3;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Esta clase contiene los métodos necesarios para la implementación del
 * algoritmo voraz que nos permita resolver el problema. El algoritmo no es
 * óptimo. Por ejemplo, si tenemos un solar de 4 metros y baldosas de tamaños 3,
 * 2 y 1 metros, el algoritmo pondrá una baldosa de 3x3 y quedarán 7 huecos para
 * baldosas de 1x1 (tres huecos estarán distribuidos horizontalmente y los otros
 * cuatro lo estarán verticalmente), esto haría que en total se tuviesen que
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
	 * Este método ordena un array de enteros de manera descendente. Primero, se
	 * utiliza el método sort de Arrays para ordenar el array de menor a mayor.
	 * Después, se intercambian los elementos del array, empezando por los extremos
	 * (el primero con el último, el segundo con el penúltimo, y así sucesivamente)
	 * hasta llegar al centro, utilizando un bucle for.
	 * 
	 *
	 * @param tamanosBaldosas Array con los tamaños de las baldosas sin ordenar
	 * @return tamanosBaldosas Array con los tamaños de las baldosas ordenado de
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
	 * El siguiente método es el corazón de nuestro programa, el algoritmo de la
	 * resolución de la colocación de baldosas en el solar. A este método le pasamos
	 * el lado de nuestro solar cuadrado y el array ordenado (orden decreciente) de
	 * los tamaños de baldosas. Lo primero que hará el método será hacer una copia
	 * del lado del solar, para usarla en diferentes bucles y como argumento para el
	 * método cabeBaldosa. También se define un entero de índice actual de tamaño de
	 * baldosa, en conjunto con la variable que guarda el tamaño de la baldosa, en
	 * función de la posición actual (proveniente del array). Por último se crea una
	 * matriz bidimensional, que será la solución a nuestro problema: floor o suelo.
	 * Su tamaño será el lado del solar en x e y (tamSolar^2)
	 * 
	 * Una vez se han inicializado las variables anteriores, el algoritmo recorrerá
	 * el suelo del solar, usando dos bucles for. Mientras que la coordenada ij del
	 * solar no esté ocupada (representada con un 0) y la baldosa actual
	 * seleccionada esté dentro del array del tamaño de las baldosas, redefinimos el
	 * tamaño de la baldosa. Esto lo hacemos para comprobar en este momento si la
	 * baldosa cabe en la posición actual del solar (ver método cabeBaldosa).
	 * 
	 * De ser así, a través de otros dos bucles for, estableceremos con el número
	 * del tamaño de baldosa la baldosa, ocupando así su en el solar. Nótese que
	 * estos dos for recorren únicamente la longitud del tamaño de baldosa
	 * correspondiente, empezando desde las coordenadas determinadas por i y j (fila
	 * y columna). Si no cabe, pasamos a un tamaño de baldosa menor, representado
	 * como un aumento de la posición actual del array de baldosas. Esté método
	 * cuando finalice devolverá la matriz solución.
	 * 
	 * --COMPLEJIDAD--
	 * 
	 * La complejidad de este algoritmo depende principalmente del lado del solar,
	 * sin despreciar los diferentes tamaños de baldosa que se introduzcan. Por
	 * ello, empleando notación Big-Theta, el algoritmo posee una complejidad de
	 * O(n^2).
	 *
	 * @param tamSolar the tam solar
	 * 
	 * @param tamBaldosas the tam baldosas
	 * 
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
					} else {
						actual++;
					}
				}
			}
		}
		return floor;
	}

	/**
	 * Este método verifica si es posible colocar una baldosa en una posición dada
	 * dentro de la matriz resultado. Primero, se verifica que la baldosa no se
	 * salga del solar. Si esto sucede, se devuelve false, indicando que no cabe la
	 * baldosa. Luego, se recorren las casillas de la submatriz donde se intentará
	 * colocar la baldosa, verificando que todas estén libres (su valor en la matriz
	 * resultado es 0). Si alguna de ellas ya tiene una baldosa colocada, se
	 * devuelve false. Si se recorren todas las casillas sin encontrar ninguna
	 * ocupada, se devuelve true, indicando que cabe la baldosa en esa posición.
	 *
	 * 
	 * @param tamano    Tamaño de la baldosa a colocar
	 * @param i         Coordenada 'x' donde se intentará colocar la baldosa
	 * @param j         Coordenada 'y' donde se intentará colocar la baldosa
	 * @param resultado Representa el estado actual del solar
	 * @param lado      Tamaño del lado del solar.
	 * @return true - Si cabe la baldosa en esa posición
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
