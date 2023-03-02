package CasoEstudio1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The Class Main.
 */
public class Main {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
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
	 * mensaje de error, a través de la excepción incluida en la API de Java "Input
	 * Mismatch Exception".
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
//Con 0 da mal el resultado
// Controlar los negativos
// Da error 99999

// Comprobar resultado de tiempo ejecucion con ejercicios resueltos
