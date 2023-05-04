package CasoEstudio3Hito;

/**
 * Es la clase principal del programa encargada de interactuar con el usuario,
 * es decir, de pedirle los detalles del solar y el n�mero de baldosas distintas
 * que se van a utilizar junto con sus dimensiones. Luego, utiliza el algoritmo
 * correspondiente para encontrar la soluci�n y la imprime en la consola. En
 * caso de que no sea posible encontrar una soluci�n, la clase principal
 * mostrar� un mensaje de error.
 */
public class Main {

	/**
	 * Este es el m�todo principal de la clase donde se realiza la interacci�n con
	 * el usuario para pedirle los detalles del solar y las baldosas a utilizar. En
	 * primer lugar, se pide al usuario el tama�o del solar mediante la funci�n
	 * filtrarNumero() de la clase Metodos. Luego, se pide el n�mero de baldosas
	 * distintas y sus dimensiones mediante un bucle for que solicita el tama�o de
	 * cada tipo de baldosa. Despu�s de que el usuario haya introducido todos los
	 * datos, se muestran un resumen de los datos introducidos y se ordena el array
	 * de tama�os de baldosas de menor a mayor mediante la funci�n ordenarArray() de
	 * la clase Metodos. Finalmente, se resuelve la colocaci�n de las baldosas en el
	 * solar mediante la funci�n resolverColocacion() de la clase Metodos, y se
	 * comprueba si la soluci�n es v�lida mediante la funci�n comprobacion(). Si la
	 * soluci�n es v�lida, se imprime en consola mediante la funci�n
	 * imprimirResultado(). En caso de que no se pueda encontrar una soluci�n, no se
	 * imprimir� nada en consola. Se utiliza Metodos.lectura.close() para cerrar el
	 * objeto de lectura de datos en la clase Metodos despu�s de haberlo utilizado.
	 *
	 * 
	 * @param args Argumentos del programa
	 */
	public static void main(String[] args) {
		System.out.println("Introduce el valor de N para cacular el tama�o del solar de dimensiones NxN:");
		int tamSolar = Metodos.filtrarNumero();
		System.out.println("Introduce el n�mero de baldosas diferentes: ");
		int[] tamBaldosas = new int[Metodos.filtrarNumero()];

		System.out.println("Introduzca el tama�o de las baldosas:");
		for (int i = 0; i < tamBaldosas.length; i++) {
			System.out.println("Escribe el tama�o del tipo de baldosa " + (i + 1) + " de dimensiones NxN:");
			tamBaldosas[i] = Metodos.filtrarNumero();
		}
		Metodos.lectura.close();

		System.out.println("\n\nDATOS INTRODUCIDOS:");
		System.out.println("Tama�o del solar: " + tamSolar + " x " + tamSolar);
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
	 * Este m�todo se encarga de comprobar si la soluci�n encontrada para la
	 * colocaci�n de las baldosas en el solar es v�lida o no. Para ello, recorre la
	 * matrizResultado mediante dos bucles for. Si en alg�n momento encuentra una
	 * celda con valor 0, significa que no se ha logrado colocar todas las baldosas
	 * en el solar y la soluci�n no es v�lida. En este caso, se muestra un mensaje
	 * de error en la consola indicando que no se ha completado el solar y se
	 * establece la variable correcto a false.
	 *
	 * 
	 * @param matrizResultado Matriz bidimensional con la soluci�n dada por el
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
							+ "Finalizando el programa por imposibilidad de resoluci�n.");
					correcto = false;
				}
			}
		}
		return correcto;
	}

	/**
	 * Este m�todo se encarga de imprimir en consola la matriz bidimensional que
	 * representa el solar con las baldosas colocadas por el algoritmo. Para lograr
	 * esto, utiliza dos bucles for para recorrer los elementos de la matriz por
	 * filas y columnas. En cada iteraci�n, se imprime el elemento correspondiente
	 * de la matriz utilizando la funci�n System.out.print(). Luego, cuando se llega
	 * al final de una fila, se utiliza la funci�n System.out.println() para
	 * imprimir un salto de l�nea y as� pasar a la siguiente fila.
	 *
	 * @param resultadoMatriz Matriz bidimensional con la soluci�n dada por el
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
		System.out.println("Coordenadas de la �ltima baldosa:("  + ci + "," + ci+") (" + c + "," + c + ") de tama�o " + tamano);
	}

}
