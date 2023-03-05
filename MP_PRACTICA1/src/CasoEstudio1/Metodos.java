package CasoEstudio1;

import java.time.Clock;

// TODO: Auto-generated Javadoc
/**
 * The Class Metodos.
 */
public class Metodos {

	/**
	 * Hex formula cerrada.
	 * 
	 * Este metodo aplica la expresion para calcular el n-esimo numero Hexagonal.
	 * 
	 * El algoritmo tiene una complejidad de tiempo constante O˜(1) debido a que el
	 * tiempo de ejecucion del algoritmo es independiente del tamaño de entrada y
	 * siempre sera el mismo. La causa de esto es que el algoritmo realiza solo una
	 * operacion matematica que no depende de ninguna iteracion o recursion que
	 * involucre a n.
	 *
	 * @param n the n
	 * @return the long
	 */
	public static long hexFormulaCerrada(long n) {
		return ((2 * n - 1) * n);
	}

	/**
	 * Hex iterativo.
	 * 
	 * Este metodo aplica la expresion para la obtencion del n-esimo numero de la
	 * serie H(n) = Sumatorio desde i=0 hasta n-1 (4i+1).
	 * 
	 * El algoritmo presenta una complejidad de O˜(n) deducido a traves del modelo
	 * RAM cuyo resultado es 8n+5 tras aplicar la notacion Big-Oh.
	 * 
	 *
	 * @param n the n
	 * @return the long
	 */
	public static long hexIterativo(long n) {
		long r = 0;// 1 asignacion
		for (long i = 0; i <= n - 1; i = i + 1) { // 1 asignacion, 2(n+1) comparaciones, 2n incrementos
			r += (4 * i + 1); // 4n (3 operaciones aritmeticas y una asignacion)
		}
		return r; // Operacion de retorno (1)
	}

	/**
	 * Hex recursivo.
	 * 
	 * Para conocer la relacion de recurrencia del algoritmo recursivo usado para
	 * calcular el numero hexagonal n-esimo, es decir, de Sumatorio {desde i=0 hasta n-1}
	 * (4i+1), vamos a quitar una iteracion al sumatorio, de forma que queda: Sumatorio
	 * {desde i=0 hasta n-2} (4i+1). Para que el resultado no se vea alterado,
	 * tambien le sumamos el resultado residual del termino "n-1", de manera que
	 * queda: Sumatorio {desde i=0 hasta n-2} (4i+1) + [4(n-1)+1]. Este nuevo sumatorio
	 * realmente es la funcion H_n con la iteracion que hemos quitado, de manera que
	 * lo sustituimos como H_{n-1}. Y si simplificamos [4(n-1)+1] nos queda 4n - 4 +
	 * 1 = 4n - 3. Nos queda finalmente H_n = H_{n-1} + 4n - 3. Esta relacion de
	 * recurrencia la interpretaremos como quitar un termino de la entrada más una
	 * operacien aritmetica residual.
	 * 
	 * Este algoritmo presenta una complejidad de O(n) la cual se ha deducido a
	 * traves del metodo de sustitucion hacia atras.
	 * 
	 * T(n) = T(n-1) +1 con T(1) = 1 T(n) = (T(n-2) +1) + 1 = T(n-2) + 2 = ... =
	 * T(n-(n-1)) + (n-1) = T(1) +n -1 = n
	 *
	 * @param n the n
	 * @return the long
	 */
	public static long hexRecursivo(long n) {
		long r = 1;
		if (n > 1)
			r = hexRecursivo(n - 1) + 4 * n - 3;
		return r;
	}

	/**
	 * Tiempo ejecucion metodo 1.
	 * 
	 * Se utiliza la funcion nanoTime() para obtener en nanosegundos la fecha y hora
	 * actual del sistema. Se realizan dos observaciones, una antes de aplicar el
	 * metodo y otra una vez se ha terminado de ejecutar. La diferencia de estos
	 * sera el tiempo en nanosegundos que le ha tomado al computador en calcular o
	 * aplicar la formula cerrada.
	 *
	 * @param n1 the n 1
	 */
	public static void tiempoEjecucionMetodo1(long n1) {
		long m1;
		long t1 = System.nanoTime();
		// System.out.println(Long.toString(t1));
		m1 = Metodos.hexFormulaCerrada(n1);
		long t2 = System.nanoTime();
		long result = t2 - t1;
		System.out.println(
				"Resultado aplicando la formula cerrada: " + Long.toString(m1) + " | Tiempo empleado: " + result);
		// System.out.println(Long.toString(t2));
		// Tiempo que ha tardado en ejecutarlo
	}

	/**
	 * Tiempo ejecucion metodo 2.
	 * 
	 * De nuevo, empleamos la funcion nanoTime() para obtener en nanosegundos la
	 * fecha y hora actual del sistema. Se realizan dos observaciones, una antes de
	 * aplicar el metodo y otra una vez se ha terminado de ejecutar. La diferencia
	 * de estos sera el tiempo en nanosegundos que le ha tomado al computador en
	 * ejecutar el algoritmo iterativo.
	 *
	 * @param n2 the n 2
	 */
	public static void tiempoEjecucionMetodo2(long n2) {
		long m2;
		long t3 = System.nanoTime();
		// System.out.println(Long.toString(t3));
		m2 = Metodos.hexIterativo(n2);
		long t4 = System.nanoTime();
		// System.out.println(Long.toString(t4));
		long result = (t4 - t3); // Tiempo que ha tardado en ejecutarlo
		System.out.println(
				"Resultado aplicando la formula iterativa es: " + Long.toString(m2) + " | Tiempo empleado: " + result);

	}

	/**
	 * Tiempo ejecucion metodo 3.
	 *
	 * Una vez mas, se emplea la funcion nanoTime() para obtener en nanosegundos la fecha y hora
	 * actual del sistema. Se realizan dos observaciones, una antes de aplicar el
	 * metodo y otra una vez se ha terminado de ejecutar. La diferencia de estos
	 * sera el tiempo en nanosegundos que le ha tomado al computador en ejecutar el
	 * algoritmo recursivo.
	 * 
	 * @param n3 the n 3
	 */
	public static void tiempoEjecucionMetodo3(long n3) {
		long m3;
		long t5 = System.nanoTime();
//		System.out.println(Long.toString(t5));
		m3 = Metodos.hexRecursivo(n3);
		long t6 = System.nanoTime();
//		System.out.println(Long.toString(t6));
		long result = (t6 - t5); // Tiempo que ha tardado en ejecutarlo
		System.out.println(
				"Resultado aplicando la formula recursiva es: " + Long.toString(m3) + " | Tiempo empleado: " + result);

	}
}
