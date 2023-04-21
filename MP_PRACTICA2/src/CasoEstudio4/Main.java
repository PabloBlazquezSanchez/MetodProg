package CasoEstudio4;

/**
 * The Class España.
 */
public class Main {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		int[] bec = Metodos.mejorSolucion();
		Beca[] becas = Metodos.leerFichero();
		int totalDinero = 0;
		if (bec.length != 0) {
			System.out.println("Selección de las becas:");
			for (int i = 0; i < bec.length; i++) {
				if (bec[i] == 1) {
					totalDinero += becas[i].getDinero();
					System.out.println("Beca " + becas[i].getId() + ": " + becas[i].getDinero() + "");
				}
			}
			System.out.println("Total dinero obtenido: " + totalDinero + "");
		} else {
			System.out.println(
					"Se ha considerado adecuado no seleccionar ninguna beca de las ofertadas con los criterios establecidos.");
		}
	}
}
