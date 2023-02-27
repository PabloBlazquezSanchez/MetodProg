package CasoEstudio1;

public class Metodos {

	// El algoritmo tiene una complejidad de tiempo constante O(1) debido a que el
	// tiempo de ejecución del algoritmo es independiente del tamaño de entrada y
	// siempre será el mismo. La causa de esto es que el algoritmo realiza solo una
	// operación matemática que no depende de ninguna iteración o recursión que
	// involucre a n.

	public static int hexFormulaCerrada(int n) {
		return ((2 * n - 1) * n);
	}

	public static int hexIterativo(int n) {
		int r = 0;
		for (int i = 0; i <= n - 1; i = i + 1) {
			r += (4 * i + 1);
		}
		return r;
	}

	public static int hexRecursivo(int n) {
		int r = 1;
		if (n > 1)
			r = hexRecursivo(n - 1) + 4 * n - 3;
		return r;
	}
	public static long tiempoEjecucionMetodo1(int n1) {
		long t1, t2, tT1;
		int m1;
		t1=System.currentTimeMillis();
		m1=Metodos.hexFormulaCerrada(n1);
		t2=System.currentTimeMillis();
	//	tT1=t2-t1; //Tiempo que ha tardado en ejecutarlo
		return tT1=t2-t1;
	}
	public static long tiempoEjecucionMetodo2(int n2) {
		long t3, t4, tT2;
		int m2;
		t3=System.currentTimeMillis();
		m2=Metodos.hexIterativo(n2);
		t4=System.currentTimeMillis();
	//	tT2=t4-t3; 
		return tT2=t4-t3; //Tiempo que ha tardado en ejecutarlo
	}
	public static long tiempoEjecucionMetodo3(int n3) {
		long t5, t6, tT3;
		int m3;
		t5=System.currentTimeMillis();
		m3=Metodos.hexRecursivo(n3);
		t6=System.currentTimeMillis();
	//	tT3=t6-t5;
		return tT3=t6-t5; //Tiempo que ha tardado en ejecutarlo
	}
}
