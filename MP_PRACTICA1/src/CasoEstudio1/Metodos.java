package CasoEstudio1;

import java.time.Clock;

// TODO: Auto-generated Javadoc
/**
 * The Class Metodos.
 */
public class Metodos {

	// El algoritmo tiene una complejidad de tiempo constante O(1) debido a que el
	// tiempo de ejecución del algoritmo es independiente del tamaño de entrada y
	// siempre será el mismo. La causa de esto es que el algoritmo realiza solo una
	// operación matemática que no depende de ninguna iteración o recursión que
	// involucre a n.

	/**
	 * Hex formula cerrada.
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
	 * @param n the n
	 * @return the long
	 */
	public static long hexIterativo(long n) {
		long r = 0;
		for (long i = 0; i <= n - 1; i = i + 1) {
			r += (4 * i + 1);
		}
		return r;
	}

	/**
	 * Hex recursivo.
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
	 * @param n1 the n 1
	 */
	public static void  tiempoEjecucionMetodo1(long n1) {
		long m1;
		long t1 = System.nanoTime();
		//System.out.println(Long.toString(t1));
		m1=Metodos.hexFormulaCerrada(n1);
		long t2 = System.nanoTime();
		long result= t2-t1;
		System.out.println("Resultado aplicando la formula cerrada: "+Long.toString(m1)+" | Tiempo empleado: " +result);
		//System.out.println(Long.toString(t2));
		//Tiempo que ha tardado en ejecutarlo
	}
	
	/**
	 * Tiempo ejecucion metodo 2.
	 *
	 * @param n2 the n 2
	 */
	public static void tiempoEjecucionMetodo2(long n2) {
		long m2;
		long t3 = System.nanoTime();
		//System.out.println(Long.toString(t3));
		m2=Metodos.hexIterativo(n2);
		long t4 = System.nanoTime();
		//System.out.println(Long.toString(t4)); 
		long result= (t4 - t3); //Tiempo que ha tardado en ejecutarlo
		System.out.println("Resultado aplicando la formula iterativa es: "+Long.toString(m2)+" | Tiempo empleado: " +result);

	}
	
	/**
	 * Tiempo ejecucion metodo 3.
	 *
	 * @param n3 the n 3
	 */
	public static void tiempoEjecucionMetodo3(long n3) {
		long m3;
		long t5 = System.nanoTime();
//		System.out.println(Long.toString(t5));
		m3=Metodos.hexRecursivo(n3);
		long t6 = System.nanoTime();
//		System.out.println(Long.toString(t6));
		long result= (t6 - t5); //Tiempo que ha tardado en ejecutarlo
		System.out.println("Resultado aplicando la formula recursiva es: "+Long.toString(m3)+" | Tiempo empleado: " +result);

	}
}
