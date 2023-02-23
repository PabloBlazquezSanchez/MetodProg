package CasoEstudio1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("Introduce el valor para calcular el n-ésimo número hexagonal:");
		int numero = filtrarNumero();

	}

	
	// Método que captura el dato introducido por teclado y comprueba si es un
	// número o un caracter
	/**
	 * 
	 * Este método captura el dato introducido por teclado y analiza si se ha
	 * introducido un caracter o un número. Si se introduce un caracter lanza un
	 * mensaje de error, a través de la excepción incluida en la API de Java "Input
	 * Mismatch Exception".
	 * 
	 * @author Pablo Blázquez Sánchez, Jesús Fernández López, Raúl Jiménez de la
	 *         Cruz
	 * @version 1.0
	 *
	 * @return numero El número escrito por el usuario
	 */
	
	public static int filtrarNumero() {
		int numero = 0;
		Scanner lectura = new Scanner(System.in);
		try {
			numero = lectura.nextInt();
		} catch (InputMismatchException ime) { // Detecta si el dato introducido no es un número y lanza un mensaje de
												// error
			System.out.println("Sólo puede escribir números. Inténtelo de nuevo: ");
			numero = filtrarNumero(); // Vuelve a solicitar el dato
		}
		return numero;
	}
}

//Clase: Main
//Metodo: pruebaEjemplo
//Variable: persona
