package CasoEstudio2_Hito;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
	
	/**
	* Esta clase es la principal que se encarga de abrir el fichero y llamar a countInversions.
 	*/
	public class Main {
		static double[] b;

	/**
	 * Este es el método principal donde se llamará al método openFile() para extraer los datos del fichero
	 * y almacenarlos en un array global b. Posteriormente, se imprimirá por pantalla el resultado de llamar
	 * al método countInversions(b, 0, b.length - 1) situado en la clase Metodos.java.
	 */
	public static void main(String[] args) {	
		openFile();
		System.out.println("El número de inversiones usando el patrón divide y vencerás es "+Metodos.countInversions(b, 0, b.length - 1)+".");
	}

	/**
	 * Este método se encarga de recorrer el fichero el cual se pasa como parámetro
	 * en la llamada. 
	 * Una función característica del método es que va a detectar si
	 * el fichero se encuentra en el directorio. En caso afirmativo procederá a
	 * recorrerlo. En caso contrario saltará una excepción en la que notificará que
	 * el fichero no se encuentra en el directorio de búsqueda y finalizará el
	 * programa.
	 */

	public static void openFile() {
		try {
			Scanner read = new Scanner(new File("prueba.dat"));
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
