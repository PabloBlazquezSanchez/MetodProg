package CasoEstudio3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Metodos {

	public static int filtrarNumero() {
		int numero = 0;
		boolean comprobacion;
		Scanner lectura = new Scanner(System.in);
		try {
			do {
				comprobacion = false;
				numero = lectura.nextInt();

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
		//lectura.close();
		return numero;
	}
}
