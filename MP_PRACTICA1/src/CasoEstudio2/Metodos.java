package CasoEstudio2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class Metodos.
 */
public class Metodos {
	
	/**
	 * Count inversions.
	 *
	 * @param a the a
	 * @param left the left
	 * @param right the right
	 * @return the int
	 */
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

//	public static void merge (int [ ] a, int left, int middle, int right) {
//		int i = left, j = middle+1, k = left;
//		int [] aux = new int[right-left+1]; // Creamos el array auxiliar
//		for (int f = left; f <= right; f++) // copiamos las dos mitades del array en el array auxiliar
//			aux[f-left] = a[f];
//		while (i <= middle && j <= right) {  //copia el siguiente elemento que sea más grande
//			if (aux[i-left] <= aux[j-left]) {
//				a[k] = aux[i-left];
//				i++;
//			} else {
//				a[k] = aux[j-left];
//				j++;
//			}
//			k++;
//		}
//		if (j-1 == right) {  // copia lo que queda del array de la primera mitad
//			while (i<= middle) {
//				a[k] = aux[i-left];
//				k++;
//				i++;
//			}
//		}
//	}

	/**
 * Mergesort.
 *
 * @param array the array
 * @param left the left
 * @param right the right
 */
public static void mergesort(int[] array, int left, int right) { //faltaba este metodo
		if (left < right) {
			int mid = (int) Math.floor((left + right) / 2); //me aseguro de que se trunque / función suelo
			//int mid = (left + right) / 2;
			mergesort(array, left, mid);
			mergesort(array, mid + 1, right);
			mergeAndCount(array, left, mid, right);
		}
	}

	/**
	 * Merge and count.
	 *
	 * @param a the a
	 * @param left the left
	 * @param middle the middle
	 * @param right the right
	 * @return the int
	 */
	public static int mergeAndCount(int[] a, int left, int middle, int right) {
		// Maintain a pointer into each subarray, pointing to the front elements
		int count = 0; // Maintain a variable Count for the number of inversions, initialized to 0
		int i = left, j = middle + 1, k = left;
		// int[] current = new int[a.length]; NO SE UTILIZA
		int[] aux = new int[right - left + 1]; // Creamos el array auxiliar
		for (int f = left; f <= right; f++) // copiamos las dos mitades del array en el array auxiliar
			aux[f - left] = a[f];
		while (i <= middle && j <= right) { // copia el siguiente elemento que sea más grande
			if (aux[i - left] <= aux[j - left]) {
				a[k] = aux[i - left];
				i++;
				count = 1 + aux[j-left]; 
			} else {
				a[k] = aux[j - left];
				j++;
				count = count + (middle - left);
			}
			k++;
		}
		if (j - 1 == right) { // copia lo que queda del array de la primera mitad
			while (i <= middle) {
				a[k] = aux[i - left];
				k++;
				i++;
			}
		}

		return count;
	}

	/**
	 * Open file.
	 */
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
