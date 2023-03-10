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
		long numero = Metodos.filtrarNumero();
		Metodos.tiempoEjecucionMetodo1(numero);
		Metodos.tiempoEjecucionMetodo2(numero);
		Metodos.tiempoEjecucionMetodo3(numero);
	}

	
}

//Clase: MainPuebas
//Metodo: pruebaEjemplo
//Variable: persona

//ERRORES:
// Da error 99999