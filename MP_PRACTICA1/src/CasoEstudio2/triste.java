package CasoEstudio2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class triste {
	static double[] b;
	private static long merge(long arr[], int left, int mid, int right) {
        int i = left, j = mid, k = 0;
        long invCount = 0;
        long temp[] = new long[(right - left + 1)];
 
        while ((i < mid) && (j <= right)) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                ++k;
                ++i;
            } 
            else {
                temp[k] = arr[j];
                invCount += (mid - i);
                ++k;
                ++j;
            }
        }
 
        while (i < mid) {
            temp[k] = arr[i];
            ++k;
            ++i;
        }
 
        while (j <= right) {
            temp[k] = arr[j];
            ++k;
            ++j;
        }
 
        for (i = left, k = 0; i <= right; i++, k++) {
            arr[i] = temp[k];
        }
 
        return invCount;
    }
    private static long mergeSort(long arr[], int left, int right) {
        long invCount = 0;
 
        if (right > left) {
            int mid = (right + left) / 2;
 
            invCount = mergeSort(arr, left, mid);
            invCount += mergeSort(arr, mid + 1, right);
            invCount += merge(arr, left, mid + 1, right);
        }
        return invCount;
    }
 
    public static void main(String[] args) {
		openFile();
		System.out.println("El número de inversiones usando el patrón divide y vencerás es "+Metodos.countInversions(b, 0, b.length-1));

	}

	/**
	 * Open file.
	 */
	public static void openFile() {
		try {
			Scanner read = new Scanner(new File("InversionsTest_12.dat"));
			int nCases = read.nextInt(); // El primer valor es el número de casos
			double[] a = new double[nCases];
			for (int i = 0; i < nCases; i++) {
				a[i] = read.nextInt();
			}
			b = a;
		} catch (FileNotFoundException e) { // Si el fichero a buscar no existe lanza este mensaje de error y finaliza
											// el programa
			System.out.println("El fichero no existe en el directorio de búsqueda.\n"
					+ "El programa no puede continuar ejecutándose. Fin del Programa.");
			System.exit(0); // Finaliza el programa
		} catch (IOException e) { // Detecta otros errores
			e.printStackTrace();
		}
	}}

