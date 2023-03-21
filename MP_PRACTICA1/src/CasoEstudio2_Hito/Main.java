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
	 * Este es el m�todo principal donde se llamar� al m�todo openFile() para extraer los datos del fichero
	 * y almacenarlos en un array global b. Posteriormente, se imprimir� por pantalla el resultado de llamar
	 * al m�todo countInversions(b, 0, b.length - 1) situado en la clase Metodos.java.
	 */
	public static void main(String[] args) {	
		openFile();
		System.out.println("El n�mero de inversiones usando el patr�n divide y vencer�s es "+Metodos.countInversions(b, 0, b.length - 1)+".");
	}

	/**
	 * Este m�todo se encarga de recorrer el fichero el cual se pasa como par�metro
	 * en la llamada. 
	 * Una funci�n caracter�stica del m�todo es que va a detectar si
	 * el fichero se encuentra en el directorio. En caso afirmativo proceder� a
	 * recorrerlo. En caso contrario saltar� una excepci�n en la que notificar� que
	 * el fichero no se encuentra en el directorio de b�squeda y finalizar� el
	 * programa.
	 */

	public static void openFile() {
		try {
			Scanner read = new Scanner(new File("prueba.dat"));
			int nCases = read.nextInt(); // El primer valor es el n�mero de casos
			double[] a = new double[nCases];
			for (int i = 0; i < nCases; i++) {
				a[i] = read.nextInt();
			}
			b = a;
		} catch (FileNotFoundException e) { // Si el fichero a buscar no existe lanza este mensaje de error y finaliza
											// el programa
			System.out.println("El fichero no existe en el directorio de b�squeda.\n"
					+ "El programa no puede continuar ejecut�ndose. Fin del Programa.");
			System.exit(0); // Finaliza el programa
		} catch (IOException e) { // Detecta otros errores
			e.printStackTrace();
		}
	}
}
