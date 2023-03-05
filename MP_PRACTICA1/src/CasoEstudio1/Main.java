package CasoEstudio1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Esta clase es la principal que se encarga de preguntar al usuario el valor para calcular el n-ésimo número hexagonal
 */
public class Main {

	/**
	 * 
	 * Este es el método principal en el cual se pregunta el número a partir del
	 * cual se desea calcular el n-ésimo número hexagonal. Para ello se muestra por
	 * pantalla un mensaje preguntando el número que se desea lo almacenamos en una
	 * variable de tipo long. Posteriormente, llamamos a los métodos introduciendo
	 * como entrada el número ejecutado anteriormente.
	 * 
	 * @author Pablo Blázquez Sánchez, Jesús Fernández López, Raúl Jiménez de la
	 *         Cruz, Andrea Ordoño Peña
	 * @version 1.0
	 *
	 */

	public static void main(String[] args) {
		System.out.println("Introduce el valor para calcular el n-ésimo número hexagonal:");
		long numero = filtrarNumero();
		Metodos.tiempoEjecucionMetodo1(numero);
		Metodos.tiempoEjecucionMetodo2(numero);
		Metodos.tiempoEjecucionMetodo3(numero);
	}

	/**
	 * 
	 * Este método captura el dato introducido por teclado y analiza si se ha
	 * introducido un caracter o un número. Si se introduce un caracter lanza un
	 * mensaje de error y pide al usuario introducir un número positivo, a través de
	 * la excepción incluida en la API de Java "Input Mismatch Exception". Lo mismo
	 * ocurre si el número introducido es igual o menor a cero, aunque en este caso
	 * concreto no aparecerá la excepción.
	 * 
	 * @author Pablo Blázquez Sánchez, Jesús Fernández López, Raúl Jiménez de la
	 *         Cruz, Andrea Ordoño Peña
	 * @version 1.0
	 *
	 * @return numero El número escrito por el usuario
	 */

	public static long filtrarNumero() {
		long numero = 0;
		Scanner lectura = new Scanner(System.in);
		boolean comprobacion;
		try {
			do {
				comprobacion = false;
				numero = lectura.nextLong();

				if (numero <= 0) {
					System.out.println("Error. Introduce números mayores que 0:");
					comprobacion = true;
				}
			} while (comprobacion);

		} catch (InputMismatchException ime) { // Detecta si el dato introducido no es un número y lanza un mensaje de
												// error
			System.out.println("Sólo puede escribir números. Inténtelo de nuevo: ");
			numero = filtrarNumero(); // Vuelve a solicitar el dato
		}
		return numero;
	}
}

//Clase: MainPuebas
//Metodo: pruebaEjemplo
//Variable: persona

//ERRORES:
// Da error 99999