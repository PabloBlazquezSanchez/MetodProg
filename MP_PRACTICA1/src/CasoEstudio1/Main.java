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