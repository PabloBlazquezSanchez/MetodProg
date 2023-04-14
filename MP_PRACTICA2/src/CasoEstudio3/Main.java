package CasoEstudio3;

public class Main {
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

	private static void imprimirResultado(int[][] resultadoMatriz) {
		for (int i = 0; i < resultadoMatriz.length; i++) {
			for (int j = 0; j < resultadoMatriz[i].length; j++) {
				System.out.print(resultadoMatriz[i][j] + " ");
			}
			System.out.println();
		}
	}

}
