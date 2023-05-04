package CasoEstudio3Hito;

/**
 * Es la clase principal del programa encargada de interactuar con el usuario,
 * es decir, de pedirle los detalles del solar y el número de baldosas distintas
 * que se van a utilizar junto con sus dimensiones. Luego, utiliza el algoritmo
 * correspondiente para encontrar la solución y la imprime en la consola. En
 * caso de que no sea posible encontrar una solución, la clase principal
 * mostrará un mensaje de error.
 */
public class Main {

	/**
	 * Este es el método principal de la clase donde se realiza la interacción con
	 * el usuario para pedirle los detalles del solar y las baldosas a utilizar. En
	 * primer lugar, se pide al usuario el tamaño del solar mediante la función
	 * filtrarNumero() de la clase Metodos. Luego, se pide el número de baldosas
	 * distintas y sus dimensiones mediante un bucle for que solicita el tamaño de
	 * cada tipo de baldosa. Después de que el usuario haya introducido todos los
	 * datos, se muestran un resumen de los datos introducidos y se ordena el array
	 * de tamaños de baldosas de menor a mayor mediante la función ordenarArray() de
	 * la clase Metodos. Finalmente, se resuelve la colocación de las baldosas en el
	 * solar mediante la función resolverColocacion() de la clase Metodos, y se
	 * comprueba si la solución es válida mediante la función comprobacion(). Si la
	 * solución es válida, se imprime en consola mediante la función
	 * imprimirResultado(). En caso de que no se pueda encontrar una solución, no se
	 * imprimirá nada en consola. Se utiliza Metodos.lectura.close() para cerrar el
	 * objeto de lectura de datos en la clase Metodos después de haberlo utilizado.
	 *
	 * 
	 * @param args Argumentos del programa
	 */
	public static void main(String[] args) {
		System.out.println("Introduce el valor de N para cacular el tamaño del solar de dimensiones NxN:");
		int tamSolar = Metodos.filtrarNumero();
		System.out.println("Introduce el número de baldosas diferentes: ");
		int[] tamBaldosas = new int[Metodos.filtrarNumero()];

		System.out.println("Introduzca el tamaño de las baldosas:");
		for (int i = 0; i < tamBaldosas.length; i++) {
			System.out.println("Escribe el tamaño del tipo de baldosa " + (i + 1) + " de dimensiones NxN:");
			tamBaldosas[i] = Metodos.filtrarNumero();
		}
		Metodos.lectura.close();

		System.out.println("\n\nDATOS INTRODUCIDOS:");
		System.out.println("Tamaño del solar: " + tamSolar + " x " + tamSolar);
		System.out.println("Tipos de baldosas distintas: " + tamBaldosas.length);
		for (int i = 0; i < tamBaldosas.length; i++) {
			System.out.println("\tBalsosa " + (i + 1) + ": " + tamBaldosas[i] + "x" + tamBaldosas[i]);
		}
		Metodos.ordenarArray(tamBaldosas);
		System.out.println("\n\nSOLUCION:");
		int[][] solucion = Metodos.resolverColocacion(tamSolar, tamBaldosas);
		if (comprobacion(solucion)) {
			imprimirResultado(solucion);
		}
		// imprimirResultado(Metodos.resolverColocacion(tamSolar, tamBaldosas));
	}

	/**
	 * Este método se encarga de comprobar si la solución encontrada para la
	 * colocación de las baldosas en el solar es válida o no. Para ello, recorre la
	 * matrizResultado mediante dos bucles for. Si en algún momento encuentra una
	 * celda con valor 0, significa que no se ha logrado colocar todas las baldosas
	 * en el solar y la solución no es válida. En este caso, se muestra un mensaje
	 * de error en la consola indicando que no se ha completado el solar y se
	 * establece la variable correcto a false.
	 *
	 * 
	 * @param matrizResultado Matriz bidimensional con la solución dada por el
	 *                        algoritmo
	 * @return true - Si todos los elementos de la matriz tienen un valor distinto
	 *         de 0
	 */
	public static boolean comprobacion(int[][] matrizResultado) {
		boolean correcto = true;
		for (int i = 0; i < matrizResultado.length && correcto; i++) {
			for (int j = 0; j < matrizResultado[i].length && correcto; j++) {
				if (matrizResultado[i][j] == 0) {
					System.out.println("No se ha completado el solar por lo que el resultado es imposible.\n"
							+ "Finalizando el programa por imposibilidad de resolución.");
					correcto = false;
				}
			}
		}
		return correcto;
	}

	/**
	 * Este método se encarga de imprimir en consola la matriz bidimensional que
	 * representa el solar con las baldosas colocadas por el algoritmo. Para lograr
	 * esto, utiliza dos bucles for para recorrer los elementos de la matriz por
	 * filas y columnas. En cada iteración, se imprime el elemento correspondiente
	 * de la matriz utilizando la función System.out.print(). Luego, cuando se llega
	 * al final de una fila, se utiliza la función System.out.println() para
	 * imprimir un salto de línea y así pasar a la siguiente fila.
	 *
	 * @param resultadoMatriz Matriz bidimensional con la solución dada por el
	 *                        algoritmo
	 */
	private static void imprimirResultado(int[][] resultadoMatriz) {
		for (int i = 0; i < resultadoMatriz.length; i++) {
			for (int j = 0; j < resultadoMatriz[i].length; j++) {
				System.out.print(resultadoMatriz[i][j] + " ");
			}
			System.out.println();
		}
	}

	
	public static void imprimirCoord(int ci, int c, int tamano) {
		System.out.println("Coordenadas de la última baldosa:("  + ci + "," + ci+") (" + c + "," + c + ") de tamaño " + tamano);
	}

}
