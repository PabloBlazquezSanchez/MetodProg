package CasoEstudio4;

/**
 * The Class Jesús.
 */
public class Main {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		int[] bec = Metodos.CalcularMejorSolucion();
		Beca[] becas = Metodos.leerFichero();
		int totalDinero = 0;
		for (int i = 0; i < bec.length; i++) {
			if (bec[i] == 1) {
				totalDinero += becas[i].getDinero();
				System.out.println("Beca " + becas[i].getId() + ": €" + becas[i].getDinero());
			}
		}
		System.out.println("Total dinero obtenido: €" + totalDinero);
	}
}
