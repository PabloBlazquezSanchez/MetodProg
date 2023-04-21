package CasoEstudio4;

/**
 * The Class España.
 */
public class Main {

	/**
	 * The main method.
	 * En el método, main lo primero que vamos hacer es crear un array bec y otro array de tipo Beca llamado becas.
	 * A bec le vamos a pasar la función de mejor solución de la clase Metodos y a becas la funcion de Leerfichero de la clase 
	 * Metodos que contine todos los datos a usar.
	 * Inicializamos una variable de tipo entero llamado totalDinero en el cual vamos almacenar el dinero total.
	 * Creamos un bucle if que va a tener dos opciones la primera en el cual de si la longitud de bec 
	 * es distinto de 0 vamos a imprimir un mensaje que diga la seleccion de las becas y crear un bucle for interno en el cual 
	 * vamos a recorrer el array bec y añadimos otro bucle if interno que si cacda posicion es igual a 1 entonces a totalDinero 
	 * le sumamos lo que tiene + el contenido del array becas en esa posicion el dinero y lo imprimos cerramos todos los bucles 
	 * excepto el primer if y ahi imprimos el dinero total que hemos obtenido con esto acabariamos la primera opcion.
	 * La segunda opcion que tenermos es si es igual 0 en ese caso solo imprimiremos un mensaje que diga que no se ha considerado 
	 * seleccionar ninguna beca que se encuentra ofertada. 
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
