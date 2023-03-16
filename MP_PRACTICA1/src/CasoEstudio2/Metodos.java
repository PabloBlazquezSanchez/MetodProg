package CasoEstudio2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

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
	public static int countInversions(double [] a, int left, int right) {
		int middle = (left + right) / 2; // Floor operator
		int count = 0;

		if (left < right) {
			count = countInversions(a, left, middle);
			count = count + countInversions(a, middle + 1, right);
			count = count + mergeAndCount(a, left, middle, right);
		}
		return count;
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
	
	public static int mergeAndCount(double[] a, int left, int middle, int right) {
		int count = 0; // Maintain a variable Count for the number of inversions, initialized to 0
		int i = left, j = middle + 1, k = left; // Maintain a pointer into each subarray, pointing to the front elements
		double [] current = new double[right - left + 1]; // Creamos el array auxiliar
		for (int f = left; f <= right; f++) // copiamos las dos mitades del array en el array auxiliar
			current[f - left] = a[f];
		while (i <= middle && j <= right) { // copia el siguiente elemento que sea más grande
			if (current[i - left] <= current[j - left]) {
				a[k] = current[i - left];
				i++;
			} else {
				a[k] = current[j - left];
				j++;
				count = count + (middle - left)+1;
			}
			k++;
		}
		if (j - 1 == right) { // copia lo que queda del array de la primera mitad
			while (i <= middle) {
				a[k] = current[i - left];
				k++;
				i++;
			}
		}

		return count;
	}

}
