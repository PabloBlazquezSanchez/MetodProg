package CasoEstudio1;

import java.time.Clock;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Esta clase contiene los m�todos necesarios para el c�lculo del n-�simo n�mero
 * Hexagonal y para la medici�n del tiempo de ejecuci�n.
 */
public class Metodos {

	/**
	 * 
	 * Este m�todo aplica la expresi�n para calcular el n-�simo n�mero Hexagonal
	 * gracias al uso f�rmula cerrada.
	 * 
	 * El algoritmo tiene una complejidad de tiempo constante O(1) debido a que el
	 * tiempo de ejecuci�n del algoritmo es independiente del tama�o de entrada y
	 * siempre ser� el mismo. La causa de esto es que el algoritmo realiza solo una
	 * operaci�n matem�tica que no depende de ninguna iteraci�n o recursi�n que
	 * involucre a n.
	 *
	 * @param n El n�mero a partir del cu�l se desea calcular el n-�simo n�mero Hexagonal
	 * @return r - El resultado que se produce tras haber realizado las operaciones del m�todo
	 */
	public static long hexFormulaCerrada(long n) {
		return ((2 * n - 1) * n);
	}

	/**
	 * Este m�todo aplica la expresi�n para calcular el n-�simo n�mero Hexagonal de
	 * la serie H(n) = Sumatorio desde i=0 hasta n-1 (4i+1) gracias al uso de
	 * iteraciones.
	 * 
	 * El algoritmo presenta una complejidad de O(n) deducido a trav�s del modelo
	 * RAM cuyo resultado es 8n+5 tras aplicar la notaci�n Big-Oh.
	 * 
	 *
	 * @param n El n�mero a partir del cu�l se desea calcular el n-�simo n�mero Hexagonal
	 * @return r - El resultado que se produce tras haber realizado las operaciones del m�todo.
	 */
	public static long hexIterativo(long n) {
		long r = 0;// 1 asignacion
		for (long i = 0; i <= n - 1; i = i + 1) { // 1 asignacion, 2(n+1) comparaciones, 2n incrementos
			r += (4 * i + 1); // 4n (3 operaciones aritmeticas y una asignacion)
		}
		return r; // Operacion de retorno (1)
	}

	/**
	 * Este m�todo aplica la expresi�n para calcular el n-�simo n�mero Hexagonal
	 * gracias al uso de la recursividad.
	 * 
	 * Para conocer la relaci�n de recurrencia del algoritmo recursivo usado para
	 * calcular el n�mero hexagonal n-�simo, es decir, de Sumatorio {desde i=0 hasta
	 * n-1} (4i+1), vamos a quitar una iteraci�n al sumatorio, de forma que queda:
	 * Sumatorio {desde i=0 hasta n-2} (4i+1). Para que el resultado no se vea
	 * alterado, tambi�n le sumamos el resultado residual del t�rmino "n-1", de
	 * manera que queda: Sumatorio {desde i=0 hasta n-2} (4i+1) + [4(n-1)+1]. Este
	 * nuevo sumatorio realmente es la funci�n H_n con la iteraci�n que hemos
	 * quitado, de manera que lo sustituimos como H_{n-1}. Y si simplificamos
	 * [4(n-1)+1] nos queda 4n - 4 + 1 = 4n - 3. Nos queda finalmente H_n = H_{n-1}
	 * + 4n - 3. Esta relaci�n de recurrencia la interpretaremos como quitar un
	 * t�rmino de la entrada m�s una operaci�n aritm�tica residual. Este algoritmo
	 * presenta una complejidad de O(n) la cual se ha deducido a trav�s del m�todo
	 * de sustituci�n hacia atr�s.
	 * 
	 * T(n) = T(n-1) +1 con T(1) = 1 T(n) = (T(n-2) +1) + 1 = T(n-2) + 2 = ... =
	 * T(n-(n-1)) + (n-1) = T(1) +n -1 = n
	 *
	 * @param n El n�mero a partir del cu�l se desea calcular el n-�simo n�mero Hexagonal
	 * @return r - El resultado que se produce tras haber realizado las operaciones del m�todo.
	 */
	public static long hexRecursivo(long n) {
		long r = 1;
		if (n > 1)
			r = hexRecursivo(n - 1) + 4 * n - 3;
		return r;
	}

	/**
	 * Este m�todo calcula el tiempo de ejecuci�n de hexFormulaCerrada.
	 * 
	 * Se utiliza la funci�n nanoTime() para obtener en nanosegundos la fecha y hora
	 * actual del sistema. Se realizan dos observaciones, una antes de aplicar el
	 * m�todo y otra una vez se ha terminado de ejecutar. La diferencia de estos
	 * ser� el tiempo en nanosegundos que le ha tomado al computador en calcular o
	 * aplicar la f�rmula cerrada.
	 *
	 * @param n1 El n�mero a partir del cu�l se desea calcular el n-�simo n�mero
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
	 * Este m�todo calcula el tiempo de ejecuci�n de hexIterativo.
	 * 
	 * De nuevo, empleamos la funci�n nanoTime() para obtener en nanosegundos la
	 * fecha y hora actual del sistema. Se realizan dos observaciones, una antes de
	 * aplicar el m�todo y otra una vez se ha terminado de ejecutar. La diferencia
	 * de estos ser� el tiempo en nanosegundos que le ha tomado al computador en
	 * ejecutar el algoritmo iterativo.
	 *
	 * @param n2 El n�mero a partir del cu�l se desea calcular el n-�simo n�mero
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
	 * Este m�todo calcula el tiempo de ejecuci�n de hexRecursivo.
	 *
	 * Una vez m�s, se emplea la funci�n nanoTime() para obtener en nanosegundos la
	 * fecha y hora actual del sistema. Se realizan dos observaciones, una antes de
	 * aplicar el m�todo y otra una vez se ha terminado de ejecutar. La diferencia
	 * de estos ser� el tiempo en nanosegundos que le ha tomado al computador en
	 * ejecutar el algoritmo recursivo.
	 * 
	 * Se controla la StackOverflowError debido a que si el usuario introduce un
	 * n�mero demasiado grande, habr� un desbordamiento de la pila.
	 * 
	 * @param n3 El n�mero a partir del cu�l se desea calcular el n-�simo n�mero
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
					"Error. El n�mero introducido es demasiado grande para ser calculado a trav�s de este m�todo.");
		}
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
