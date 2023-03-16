package CasoEstudio2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * The Class Main.
 */
public class Main {
	static double[] b;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		openFile();
		System.out.println(Metodos.countInversions(b, 0, b.length-1));
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
	}
}
