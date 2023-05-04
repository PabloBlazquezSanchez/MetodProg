package CasoEstudio4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Esta clase contiene los métodos necesarios para la implementación del
 * algoritmo de backtracking que nos permita resolver el problema.
 */
public class Metodos {

	/**
	 * El objetivo de este método es buscar la mejor solución que existe.
	 * 
	 * Para calcular mejorSolucion, creamos una método estático array de tipo
	 * entero, lo primero que vamos hacer es crear un array becas de tipo Beca en el
	 * cual le pasamos el método de LeerFichero, creamos otro array solucion de tipo
	 * entero el cual esta inicializado con la longitud del array becas.
	 * 
	 * Llamamos al método de selección al cuál le pasamos la longitud del array, el
	 * array solucion, el nivel (inicialmente en 0) y el array becas. Para finalizar
	 * el método retornamos el array solucion.
	 * 
	 * @return solucion Array de unos y ceros que representan la solución al
	 *         problema
	 */
	public static int[] mejorSolucion() {
		Beca becas[] = leerFichero();
		int[] solucion = new int[becas.length];
		seleccion(new int[becas.length], solucion, 0, becas);
		return solucion;
	}

	/**
	 * Seleccion.
	 * 
	 * El siguiente algoritmo es el principal motor del programa, el algoritmo de
	 * tipo Back-tracking. Consiste en que iremos recorriendo nuestro "árbol
	 * virtual" de becas para obtener la mejor combinación, probando (y desechando)
	 * de por medio numerosas soluciones parciales.
	 * 
	 * Este algoritmo se divide en dos partes, en el caso base o posible
	 * finalización y en el caso recursivo de Back-tracking.
	 * 
	 * En la primera parte verificamos si nuestra variable entera iteradura level ha
	 * llegado al final del sistema de becas (equivale a longitud del array de
	 * estas). Si es así, procedemos a comparar la solución parcial con la actual
	 * que es actualmente óptima (que se puede desechar, ver método esMejor()). Si
	 * la solución x resulta ser más óptima, se reemplazará a la solución
	 * persistente.
	 * 
	 * Si alguna de estas dos condiciones no se cumple, es cuando pasamos a volver
	 * hacia atrás. Nuestra condición de viabilidad ("feasibility condition") es
	 * verificar si un nodo beca es compatible con las demás (ver esCompatible()).
	 * Si es compatible, la incluimos en nuestra solución temporal X con un 1, a
	 * través del iterador level, que nos ayuda a determinar la posición exacta de
	 * la beca, y llamamos recursivamente al método para repetir lo anterior y
	 * seguir con la búsqueda ideal de becas. Cuando acabe dicha ejecución recursiva
	 * (o cuando no es compatible), descartamos la beca, estableciendo un 0.
	 * Posteriormente, llamamos al método recursivo para que se puedan seguir
	 * buscando otras becas más óptimas.
	 * 
	 * La ejecución termina cuando se ha alcanzado y aprobado la condición de
	 * finalización, como hemos comentado anteriormente. Por lo que quedará
	 * determinado el array de enteros (unos y ceros) de la solución, para poder
	 * interpretarlo y representar más adelante las becas a elegir por pantalla.
	 * 
	 * @param x        Solución temporal
	 * @param solucion Solución final del problema
	 * @param level    Nivel o iterador de becas
	 * @param becas    Array de objetos de tipo beca, donde se hallan todas las
	 *                 becas (del .dat)
	 */
	public static void seleccion(int[] x, int[] solucion, int level, Beca[] becas) {
		if (level == becas.length) { // Máximo nivel alcanzado
			if (esMejor(x, solucion, becas)) { // Caso base o test de finalización
				for (int i = 0; i < solucion.length; i++) {
					solucion[i] = x[i];
				}
			}
		} else { // Backtracking
			if (esCompatible(becas[level], x, level, becas)) { // Condición de viabilidad (Solución parcial?)
				x[level] = 1; // Incluye la beca
				seleccion(x, solucion, level + 1, becas);
			}
			x[level] = 0; // No incluye la beca
			seleccion(x, solucion, level + 1, becas);
		}
	}

	/**
	 * Leer fichero.
	 * 
	 * El siguiente método tiene como función transformar la información contenida
	 * en el ficher de becas al array de becas que se utilizará para nuestro
	 * algoritmo de Backtracking. Para ello, vamos a controlar tres excepciones: que
	 * el fichero se encuentre dentro del proyecto, que no existan errores de
	 * entrada/salida y que el formato numérico sea válido.
	 * 
	 * A través de la función split, vamos a ir rellenando cada atributo numérico de
	 * una beca (con parseInt). Cada columna implica (del 0 al 3) el número de beca,
	 * mes de inicio, mes de finalización y cuantía. Una vez tenemos los atributos,
	 * generamos objeto beca y lo añadimos al array de becas.
	 * 
	 * @return el array de becas beca[]
	 */
	public static Beca[] leerFichero() {
		String fichero = "FellowshipsN.dat";
		try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
			int longitud = Integer.parseInt(br.readLine());
			Beca becas[] = new Beca[longitud];
			for (int i = 0; i < longitud; i++) {
				String[] data = br.readLine().split("\t");
				int id = Integer.parseInt(data[0]);
				int inicio = Integer.parseInt(data[1]);
				int fin = Integer.parseInt(data[2]);
				int dinero = Integer.parseInt(data[3]);
				becas[i] = new Beca(id, inicio, fin, dinero); // inicializar la beca en la posición i del array
			}
			return becas;

		} catch (FileNotFoundException e) { // Si el fichero a buscar no existe lanza este mensaje de error y finaliza
											// el programa
			System.out.println("El fichero no existe en el directorio de búsqueda.\n"
					+ "El programa no puede continuar ejecutándose. Fin del Programa.");
			System.exit(0); // Finaliza el programa
		} catch (IOException e) { // Detecta otros errores
			System.out.println("El programa no puede continuar ejecutándose. Fin del Programa.");
			System.exit(0); // Finaliza el programa
		} catch (NumberFormatException e) {
			System.out.println("El archivo no se encuentra separado por '\\t' o tiene alguna letra.");
			System.exit(0); // Finaliza el programa

		}
		return null;
	}

	/**
	 * 
	 * El objetivo de este método es saber si becaProv es compatible con las becas
	 * que se encuentran en el array becas.
	 * 
	 * Para ello vamos a crear un método estático esCompatible de tipo booleano en
	 * el cual le pasamos la variable becaProv de tipo Beca, un array x tipo entero,
	 * una variable level de tipo entero y un array becas de tipo Beca.
	 * 
	 * Dentro del método vamos a crear una variable comp de tipo booleano
	 * inicializada a true, como podemos ver después creamos un bucle for en el que
	 * vamos a recorrer todos los elementos del array x hasta el índice level.
	 * Dentro del bucle vamos a crear otro bucle interno pero de tipo if en el cual
	 * vamos a comparar todas las posiciones del array x con 1, es decir, si la
	 * posicion que actualmente se esta comparando es igual a 1 se selecciona esa
	 * beca y si es asi, se obtiene el objeto Beca correspondiente en el array becas
	 * y se comprueba si hay algún solapamiento en las fechas entre becaProv y
	 * becaInd.
	 * 
	 * Si se encuentra solapamiento la variable comp se estable a false y se sale
	 * del bucle. Si no se encuentra ningún solapamiento se sigue iterando.
	 * Finalmente, el método retorna el valor de comp.
	 * 
	 * 
	 * @param becaProv Beca a la que se está evaluando si es compatible
	 * @param x        Solución provisional al problema
	 * @param level    Indica el nivel de profundidad del arbol de Backtracking
	 * @param becas    Array con las becas almacenadas en el archivo .dat
	 * @return verdadero Si la solución nueva es compatible
	 */
	public static boolean esCompatible(Beca becaProv, int[] x, int level, Beca[] becas) {
		boolean comp = true;
		for (int i = 0; i < level && comp; i++) {
			if (x[i] == 1) {
				Beca becaInd = becas[i];
				if (becaProv.getfInicio() <= becaInd.getfFin() && becaProv.getfFin() >= becaInd.getfInicio()) {
					comp = false;
				}
			}
		}
		return comp;
	}

	/**
	 * El objetivo de este método es determinar cuál es la mejor beca a la que se
	 * puede optar.
	 * 
	 * Para ello vamos a crear un método estático esMejor de tipo booleano, en el
	 * cual le vamos a pasar tres arrays, el primero es un array x de tipo entero,
	 * el segundo es un array solución de tipo entero y por último un array becas de
	 * tipo Beca.
	 * 
	 * Dentro del método vamos a crear variables sx y ss de tipo entero inicializado
	 * a 0, creamos un bucle for con el cual vamos a recorrer el array x, dentro
	 * creamos otro bucle de tipo if en el en cual vamos a comparar las posiciones
	 * del array x con 1, es decir, si la posición que actualmente se esta
	 * comparando es igual a 1 se almacena en sx y le sumamos lo que tiene más lo
	 * que hay en el array becas en esas posiciones y cerramos el bucle if.
	 * 
	 * Abrimos el bucle if en el en cual vamos a comparar las posiciones del array
	 * soluciones con 1, es decir, si la posición que actualmente se está comparando
	 * es igual a 1 se almacena en ss y le sumamos lo que tiene más lo que hay en el
	 * array becas en esas posiciones y cerramos el bucle if.
	 * 
	 * Finalmente el método retorna el valor de sx > ss.
	 * 
	 * 
	 * @param x        Solución provisional al problema
	 * @param solucion Solución del problema que podría dejar de serlo en este
	 *                 momento
	 * @param becas    Array con las becas almacenadas en el archivo .dat
	 * @return verdadero Si la solución nueva es mejor que la anterior
	 */
	public static boolean esMejor(int[] x, int[] solucion, Beca[] becas) {
		int sx = 0, ss = 0;
		for (int i = 0; i < x.length; i++) {
			if (x[i] == 1) {
				sx += becas[i].getDinero();
			}
			if (solucion[i] == 1) {
				ss += becas[i].getDinero();
			}
		}
		return sx > ss;

	}
}
