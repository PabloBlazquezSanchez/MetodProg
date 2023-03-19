package CasoEstudio2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Esta clase contiene los métodos necesarios para contar el número de inversiones usando el patrón divide y vencerás.
 */

public class Metodos {

	/**
	 * Este método realiza una llamada recursiva a sí misma donde se va dividiendo el array
	 * por la mitad hasta que solo quede un elemento en el mismo.
	 * Una vez tenemos todos los elementos separados procedemos a ordenarlos a través del método mergeandCount, donde
	 * se contará el número de inversiones.
	 *
	 * @param a      Array de números que se va a ordenar.
	 * @param left   Índice del primer elemento del primer subarray que se está fusionando.
	 * @param middle Índice del último elemento del primer subarray que se está fusionando.
	 * @param right  Índice del último elemento del segundo subarray que se está fusionando.
	 * @return count Número de inversiones
	 */
	public static int countInversions(double[] a, int left, int right) {//mergesort
		int middle = (left + right) / 2; // Floor operator
		//int middle = (int) Math.floor((left + right) / 2);
		int count = 0;

		if (left < right) {
			count = countInversions(a, left, middle);
			count = count + countInversions(a, middle + 1, right);
			count = count + mergeAndCount(a, left, middle, right);
		}
		return count;
	}

	/**
	 * Este método se va a encargar de ordenar el array a apoyándose en un array auxiliar
	 * del tamaño de la mitad que nos llega. 
	 * 
	 * Entonces, en este se copia el contenido de a que se requiere ordenar. 
	 * A partir de aquí se escribe en a el elemento más grande aplicándose inversiones 
	 * si fuese el de la mitad izquierda, hasta agotar la mitad
	 * izquierda del array, para que así se pueda incluir la mitad derecha.
	 * 
	 * RELACIÓN DE RECURRENCIA PARA UN T(n):
	 * 
	 * Para un array monodimensional, lo primero que hacemos en countInversions es dividir
	 * el array, es decir, calcular la mitad de la longitud del mismo. Esta
	 * operación no depende de la entrada, es un operación aritmética. Por esto que
	 * su tiempo de ejecución es O(1).
	 * 
	 * Para vencer, vamos a resolver la ordenación de las dos subcadenas resultantes
	 * de la división, por lo que se requieren dos soluciones para los dos métodos
	 * mergesort() a los que llamo, uno para cada mitad. Es decir, 2*T(n/2)
	 * 
	 * Una vez ya se han resuelto los subproblemas, toca unir las cadenas divididas.
	 * Esto ya sí depende de la entrada "n", ya que 1- se crea el array de tamaño
	 * "n" 2- voy ordenando las dos mitades n/2 Resultaría en una complejidad 2n,
	 * quedando en notación big-Oh O(n).
	 * 
	 * En total quedaría T(n)= O(1) + 2*T(n/2) + O(n). Caso Base -> n=1 -> O(1) Caso
	 * Inductivo -> n>1 -> 2*T(n/2) + O(n)
	 * 
	 * Emplearemos el método maestro, idóneo para divide y vencerás:
	 * 
	 * La forma básica del método maestro es T(n) = aT(n/b) + f(n), siendo f(n) de
	 * la forma O(n^d), siempre que d>=0 Para nuestro T(n)=2*T(n/2) + O(n), vemos
	 * que a=2, b=2 y d=1 => b^d=2^1=2 En este caso a=b^d (2=2). Entonces es el
	 * segundo caso del método maestro. Significa que la relación de recurrencia de
	 * nuestro algoritmo tendrá una recurrencia del orden O(n^d*log n) => O(n^1*log n)
	 * =O(n log n)
	 * 
	 * 
	 *
	 * @param a      Array de números que se va a ordenar.
	 * @param left   Índice del primer elemento del primer subarray que se está fusionando.
	 * @param middle Índice del último elemento del primer subarray que se está fusionando.
	 * @param right  Índice del último elemento del segundo subarray que se está fusionando.
	 * @return count Número de inversiones
	 */

	public static int mergeAndCount(double[] a, int left, int middle, int right) {//merge
		int count = 0; // Maintain a variable Count for the number of inversions, initialized to 0
		int i = left, j = middle + 1, k = left; // Maintain a pointer into each subarray, pointing to the front elements
		double[] current = new double[right - left + 1]; // Creamos el array auxiliar
		for (int f = left; f <= right; f++) // copiamos las dos mitades del array en el array auxiliar
			current[f - left] = a[f];
		while (i <= middle && j <= right) { // copia el siguiente elemento que sea más grande
			if (current[i - left] <= current[j - left]) {
				a[k] = current[i - left];
				i++;
			} else {
				a[k] = current[j - left];
				j++;
				count = count + (middle - left) + 1;
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
