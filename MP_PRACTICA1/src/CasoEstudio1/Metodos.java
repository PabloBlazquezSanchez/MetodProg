package CasoEstudio1;

public class Metodos {

	// El algoritmo tiene una complejidad de tiempo constante O(1) debido a que el
	// tiempo de ejecución del algoritmo es independiente del tamaño de entrada y
	// siempre será el mismo. La causa de esto es que el algoritmo realiza solo una
	// operación matemática que no depende de ninguna iteración o recursión que
	// involucre a n.
	
	
	public static int HexF(int n) {
		return ((2 * n - 1) * n);
	}
	
	

	public static int HexI(int n) {
		int r = 0;
		for (int i = 0; i <= n - 1; i = i + 1) {
			r += (4 * i + 1);
		}
		return r;
	}

	public static int HexR(int n) {
		int r = 1;
		if (n > 1)
			r = HexR(n - 1) + 4 * n - 3;
		return r;
	}

}
