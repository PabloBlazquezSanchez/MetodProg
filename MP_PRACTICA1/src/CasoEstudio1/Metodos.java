package CasoEstudio1;

import java.time.Clock;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Esta clase contiene los métodos necesarios para el cálculo del n-ésimo número
 * Hexagonal y para la medición del tiempo de ejecución.
 */
public class Metodos {

	/**
	 * 
	 * Este método aplica la expresión para calcular el n-ésimo número Hexagonal
	 * gracias al uso fórmula cerrada.
	 * 
	 * El algoritmo tiene una complejidad de tiempo constante O(1) debido a que el
	 * tiempo de ejecución del algoritmo es independiente del tamaño de entrada y
	 * siempre será el mismo. La causa de esto es que el algoritmo realiza solo una
	 * operación matemática que no depende de ninguna iteración o recursión que
	 * involucre a n.
	 *
	 * @param n El número a partir del cuál se desea calcular el n-ésimo número Hexagonal
	 * @return r - El resultado que se produce tras haber realizado las operaciones del método
	 */
	public static long hexFormulaCerrada(long n) {
		return ((2 * n - 1) * n);
	}

	/**
	 * Este método aplica la expresión para calcular el n-ésimo número Hexagonal de
	 * la serie H(n) = Sumatorio desde i=0 hasta n-1 (4i+1) gracias al uso de
	 * iteraciones.
	 * 
	 * El algoritmo presenta una complejidad de O(n) deducido a través del modelo
	 * RAM cuyo resultado es 8n+5 tras aplicar la notación Big-Oh.
	 * 
	 *
	 * @param n El número a partir del cuál se desea calcular el n-ésimo número Hexagonal
	 * @return r - El resultado que se produce tras haber realizado las operaciones del método.
	 */
	public static long hexIterativo(long n) {
		long r = 0;// 1 asignacion
		for (long i = 0; i <= n - 1; i = i + 1) { // 1 asignacion, 2(n+1) comparaciones, 2n incrementos
			r += (4 * i + 1); // 4n (3 operaciones aritmeticas y una asignacion)
		}
		return r; // Operacion de retorno (1)
	}

	/**
	 * Este método aplica la expresión para calcular el n-ésimo número Hexagonal
	 * gracias al uso de la recursividad.
	 * 
	 * Para conocer la relación de recurrencia del algoritmo recursivo usado para
	 * calcular el número hexagonal n-ésimo, es decir, de Sumatorio {desde i=0 hasta
	 * n-1} (4i+1), vamos a quitar una iteración al sumatorio, de forma que queda:
	 * Sumatorio {desde i=0 hasta n-2} (4i+1). Para que el resultado no se vea
	 * alterado, también le sumamos el resultado residual del término "n-1", de
	 * manera que queda: Sumatorio {desde i=0 hasta n-2} (4i+1) + [4(n-1)+1]. Este
	 * nuevo sumatorio realmente es la función H_n con la iteración que hemos
	 * quitado, de manera que lo sustituimos como H_{n-1}. Y si simplificamos
	 * [4(n-1)+1] nos queda 4n - 4 + 1 = 4n - 3. Nos queda finalmente H_n = H_{n-1}
	 * + 4n - 3. Esta relación de recurrencia la interpretaremos como quitar un
	 * término de la entrada más una operación aritmética residual. Este algoritmo
	 * presenta una complejidad de O(n) la cual se ha deducido a través del método
	 * de sustitución hacia atrás.
	 * 
	 * T(n) = T(n-1) +1 con T(1) = 1 T(n) = (T(n-2) +1) + 1 = T(n-2) + 2 = ... =
	 * T(n-(n-1)) + (n-1) = T(1) +n -1 = n
	 *
	 * @param n El número a partir del cuál se desea calcular el n-ésimo número Hexagonal
	 * @return r - El resultado que se produce tras haber realizado las operaciones del método.
	 */
	public static long hexRecursivo(long n) {
		long r = 1;
		if (n > 1)
			r = hexRecursivo(n - 1) + 4 * n - 3;
		return r;
	}

	/**
	 * Este método calcula el tiempo de ejecución de hexFormulaCerrada.
	 * 
	 * Se utiliza la función nanoTime() para obtener en nanosegundos la fecha y hora
	 * actual del sistema. Se realizan dos observaciones, una antes de aplicar el
	 * método y otra una vez se ha terminado de ejecutar. La diferencia de estos
	 * será el tiempo en nanosegundos que le ha tomado al computador en calcular o
	 * aplicar la fórmula cerrada.
	 *
	 * @param n1 El número a partir del cuál se desea calcular el n-ésimo número
	 *           Hexagonal
	 */
	public static void tiempoEjecucionMetodo1(long n1) {
		long m1;
		long t1 = System.nanoTime();
		m1 = Metodos.hexFormulaCerrada(n1);
		long t2 = System.nanoTime();
		long result = t2 - t1;
		System.out.println(
				"Resultado aplicando la formula cerrada: " + Long.toString(m1) + " | Tiempo empleado: " + result);

	}

	/**
	 * Este método calcula el tiempo de ejecución de hexIterativo.
	 * 
	 * De nuevo, empleamos la función nanoTime() para obtener en nanosegundos la
	 * fecha y hora actual del sistema. Se realizan dos observaciones, una antes de
	 * aplicar el método y otra una vez se ha terminado de ejecutar. La diferencia
	 * de estos será el tiempo en nanosegundos que le ha tomado al computador en
	 * ejecutar el algoritmo iterativo.
	 *
	 * @param n2 El número a partir del cuál se desea calcular el n-ésimo número
	 *           Hexagonal
	 */
	public static void tiempoEjecucionMetodo2(long n2) {
		long m2;
		long t3 = System.nanoTime();
		m2 = Metodos.hexIterativo(n2);
		long t4 = System.nanoTime();
		long result = (t4 - t3); // Tiempo que ha tardado en ejecutarlo
		System.out.println(
				"Resultado aplicando la formula iterativa es: " + Long.toString(m2) + " | Tiempo empleado: " + result);

	}

	/**
	 * Este método calcula el tiempo de ejecución de hexRecursivo.
	 *
	 * Una vez más, se emplea la función nanoTime() para obtener en nanosegundos la
	 * fecha y hora actual del sistema. Se realizan dos observaciones, una antes de
	 * aplicar el método y otra una vez se ha terminado de ejecutar. La diferencia
	 * de estos será el tiempo en nanosegundos que le ha tomado al computador en
	 * ejecutar el algoritmo recursivo.
	 * 
	 * Se controla la StackOverflowError debido a que si el usuario introduce un
	 * número demasiado grande, habrá un desbordamiento de la pila.
	 * 
	 * @param n3 El número a partir del cuál se desea calcular el n-ésimo número
	 *           Hexagonal
	 */
	public static void tiempoEjecucionMetodo3(long n3) {
		try {
			long m3;
			long t5 = System.nanoTime();
			m3 = Metodos.hexRecursivo(n3);
			long t6 = System.nanoTime();
			long result = (t6 - t5); // Tiempo que ha tardado en ejecutarlo
			System.out.println("Resultado aplicando la formula recursiva es: " + Long.toString(m3)
					+ " | Tiempo empleado: " + result);
		} catch (StackOverflowError e) {
			System.out.println(
					"Error. El número introducido es demasiado grande para ser calculado a través de este método.");
		}
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
