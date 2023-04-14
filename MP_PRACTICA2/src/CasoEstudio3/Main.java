package CasoEstudio3;

/**
 * Es la clase principal del programa donde se encarga de interactuar con el
 * usuario, preguntando los detalles del solar, así como el número de baldosas
 * distintas que se van a utilizar junto con sus dimensiones. Además, imprime la
 * solución dada por el algoritmo o en caso de que no sea posible encontrarla
 * mostrará un mensaje de error.
 */
public class Main {

	/**
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
	 * Comprobacion.
	 *
	 * @param matrizResultado Matriz bidimensional con la solución dada por el algoritmo
	 * @return true, if successful
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
	 * @param resultadoMatriz Matriz bidimensional con la solución dada por el algoritmo
	 */
	private static void imprimirResultado(int[][] resultadoMatriz) {
		for (int i = 0; i < resultadoMatriz.length; i++) {
			for (int j = 0; j < resultadoMatriz[i].length; j++) {
				System.out.print(resultadoMatriz[i][j] + " ");
			}
			System.out.println();
		}
	}

}
