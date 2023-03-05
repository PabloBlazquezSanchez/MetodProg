package CasoEstudio1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Esta clase es la principal que se encarga de preguntar al usuario el valor para calcular el n-�simo n�mero hexagonal
 */
public class Main {

	/**
	 * 
	 * Este es el m�todo principal en el cual se pregunta el n�mero a partir del
	 * cual se desea calcular el n-�simo n�mero hexagonal. Para ello se muestra por
	 * pantalla un mensaje preguntando el n�mero que se desea lo almacenamos en una
	 * variable de tipo long. Posteriormente, llamamos a los m�todos introduciendo
	 * como entrada el n�mero ejecutado anteriormente.
	 * 
	 * @author Pablo Bl�zquez S�nchez, Jes�s Fern�ndez L�pez, Ra�l Jim�nez de la
	 *         Cruz, Andrea Ordo�o Pe�a
	 * @version 1.0
	 *
	 */

	public static void main(String[] args) {
		System.out.println("Introduce el valor para calcular el n-�simo n�mero hexagonal:");
		long numero = filtrarNumero();
		Metodos.tiempoEjecucionMetodo1(numero);
		Metodos.tiempoEjecucionMetodo2(numero);
		Metodos.tiempoEjecucionMetodo3(numero);
	}

	/**
	 * 
	 * Este m�todo captura el dato introducido por teclado y analiza si se ha
	 * introducido un caracter o un n�mero. Si se introduce un caracter lanza un
	 * mensaje de error y pide al usuario introducir un n�mero positivo, a trav�s de
	 * la excepci�n incluida en la API de Java "Input Mismatch Exception". Lo mismo
	 * ocurre si el n�mero introducido es igual o menor a cero, aunque en este caso
	 * concreto no aparecer� la excepci�n.
	 * 
	 * @author Pablo Bl�zquez S�nchez, Jes�s Fern�ndez L�pez, Ra�l Jim�nez de la
	 *         Cruz, Andrea Ordo�o Pe�a
	 * @version 1.0
	 *
	 * @return numero El n�mero escrito por el usuario
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
					System.out.println("Error. Introduce n�meros mayores que 0:");
					comprobacion = true;
				}
			} while (comprobacion);

		} catch (InputMismatchException ime) { // Detecta si el dato introducido no es un n�mero y lanza un mensaje de
												// error
			System.out.println("S�lo puede escribir n�meros. Int�ntelo de nuevo: ");
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