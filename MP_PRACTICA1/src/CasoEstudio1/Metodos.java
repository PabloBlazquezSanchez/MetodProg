package CasoEstudio1;

import java.time.Clock;

public class Metodos {

	// El algoritmo tiene una complejidad de tiempo constante O(1) debido a que el
	// tiempo de ejecución del algoritmo es independiente del tamaño de entrada y
	// siempre será el mismo. La causa de esto es que el algoritmo realiza solo una
	// operación matemática que no depende de ninguna iteración o recursión que
	// involucre a n.

	public static long hexFormulaCerrada(long n) {
		return ((2 * n - 1) * n);
	}

	public static long hexIterativo(long n) {
		long r = 0;
		for (long i = 0; i <= n - 1; i = i + 1) {
			r += (4 * i + 1);
		}
		return r;
	}

	public static long hexRecursivo(long n) {
		long r = 1;
		if (n > 1)
			r = hexRecursivo(n - 1) + 4 * n - 3;
		return r;
	}
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
