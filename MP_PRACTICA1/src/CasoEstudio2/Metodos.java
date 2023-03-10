package CasoEstudio2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Metodos {
	public static int countInversions(int[] a, int left, int right) {
		int middle = (left + right) / 2; // Floor operator
		int count = 0;

		if (left < right) {
			count = countInversions(a, left, middle);
			count = count + countInversions(a, middle + 1, right);
			count = count + mergeAndCount(a, left, middle, right);
		}

		return count;
	}

	public static int mergeAndCount(int[] a, int left, int middle, int right) {
		// Maintain a pointer into each subarray, pointing to the front elements

		int count = 0; // Maintain a variable Count for the number of inversions, initialized to 0

		return count;
	}

	public static void openFile() {
		try {
			Scanner read = new Scanner(new File("InversionsTest_6.dat"));
			int nCases = read.nextInt(); // El primer valor es el número de casos
			double[] a = new double[nCases];
			for (int i = 0; i < nCases; i++) {
				a[i] = read.nextInt();
			}
		} catch (FileNotFoundException e) { // Si el fichero a buscar no existe lanza este mensaje de error y finaliza
											// el programa
			System.out.println("El fichero no existe en el directorio de búsqueda.\n"
					+ "El programa no puede continuar ejecutándose. Fin del Programa.");
			System.exit(0); // Finaliza el programa
		} catch (IOException e) { // Detecta otros errores
			e.printStackTrace();
		}
	}
}
