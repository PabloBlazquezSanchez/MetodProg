package CasoEstudio4;

/**
 * Es la clase principal del programa encargada de interactuar con el usuario,
 * es decir, en este caso vamos a mostrar la mejor opción de becas a solicitar
 * durante un curso. Para ello vamos a usar los métodos mejorSolucion y el
 * método LeerFichero y la imprime en la consola. En caso de que no sea posible
 * mostrar la mejor opción de becas, la clase principal mostrará un mensaje de
 * que no hay una opción adecuada con los criterios establecidos.
 */
public class Main {

	/**
	 * Este es el método principal de la clase donde se realiza la interacción con
	 * el usuario. En el método main, creamos un array bec y otro array de tipo Beca
	 * llamado becas.
	 * 
	 * A bec le pasamos el método de mejor solución de la clase Metodos y a becas el
	 * método de Leerfichero de la clase Metodos que contine todos los datos a usar.
	 * Inicializamos la variable totalDinero de tipo entero en el cual vamos
	 * almacenar el dinero total.
	 * 
	 * Creamos un bucle if que va a tener el if y el else; en el if si la longitud
	 * de bec es distinto de 0 vamos a imprimir un mensaje que diga la selección de
	 * las becas, y crear un bucle for interno en el cual, vamos a recorrer el array
	 * bec y añadimos otro bucle if interno que si cada posicion es igual a 1
	 * entonces, a totalDinero le sumamos lo que tiene + el contenido del array
	 * becas en esa posicion el dinero y lo imprimos cerramos todos los bucles
	 * excepto el primer if y ahí se imprime el dinero total que hemos obtenido con
	 * esto acabaríamos la primera opción.
	 * 
	 * En el else del primer if que tenemos, si es igual 0 en ese caso solo
	 * imprimiremos un mensaje que diga que no se ha considerado seleccionar ninguna
	 * beca que se encuentra ofertada.
	 * 
	 * 
	 * 
	 * @param args Argumentos del programa
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
