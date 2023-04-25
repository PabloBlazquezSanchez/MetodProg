package CasoEstudio4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Esta clase contiene los m�todos necesarios para la implementaci�n del
 * algoritmo de backtracking que nos permita resolver el problema.
 */
public class Metodos {

	/**
	 * El objetivo de este m�todo es buscar la mejor soluci�n que existe.
	 * 
	 * Para calcular mejorSolucion, creamos una m�todo est�tico array de tipo
	 * entero, lo primero que vamos hacer es crear un array becas de tipo Beca en el
	 * cual le pasamos el m�todo de LeerFichero, creamos otro array solucion de tipo
	 * entero el cual esta inicializado con la longitud del array becas.
	 * 
	 * Llamamos al m�todo de selecci�n al cu�l le pasamos la longitud del array, el
	 * array solucion, el nivel y el array becas.Para finalizar el m�todo retornamos
	 * el array solucion.
	 * 
	 * @return solucion Array de unos y ceros que representan la soluci�n al
	 *         problema
	 */
	public static int[] mejorSolucion() {
		Beca becas[] = leerFichero();
		int[] solucion = new int[becas.length];
		seleccion(new int[becas.length], solucion, 0, becas);
		return solucion;
	}

	/**
	 *
	 * @param x        de x
	 * @param solucion de solucion
	 * @param level    de nivel
	 * @param becas    de becas
	 */
	public static void seleccion(int[] x, int[] solucion, int level, Beca[] becas) {
		if (level == becas.length) {
			if (esMejor(x, solucion, becas)) { // Caso base
				for (int i = 0; i < solucion.length; i++) {
					solucion[i] = x[i];
				}
			}
		} else {
			if (esCompatible(becas[level], x, level, becas)) {
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
	 * @return el array beca[]
	 */
	public static Beca[] leerFichero() {
		String fichero = "Fellowships3400.dat";
		try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
			int longitud = Integer.parseInt(br.readLine());
			Beca becas[] = new Beca[longitud];
			for (int i = 0; i < longitud; i++) {
				String[] data = br.readLine().split("\t");
				int id = Integer.parseInt(data[0]);
				int inicio = Integer.parseInt(data[1]);
				int fin = Integer.parseInt(data[2]);
				int dinero = Integer.parseInt(data[3]);
				becas[i] = new Beca(id, inicio, fin, dinero); // inicializar la beca en la posici�n i del array
			}
			return becas;

		} catch (FileNotFoundException e) { // Si el fichero a buscar no existe lanza este mensaje de error y finaliza
											// el programa
			System.out.println("El fichero no existe en el directorio de b�squeda.\n"
					+ "El programa no puede continuar ejecut�ndose. Fin del Programa.");
			System.exit(0); // Finaliza el programa
		} catch (IOException e) { // Detecta otros errores
			System.out.println("El programa no puede continuar ejecut�ndose. Fin del Programa.");
			System.exit(0); // Finaliza el programa
		} catch (NumberFormatException e) {
			System.out.println("El archivo no se encuentra separado por '\\t' o tiene alguna letra.");
			System.exit(0); // Finaliza el programa

		}
		return null;
	}

	/**
	 * 
	 * El objetivo de este m�todo es saber si becaProv es compatible con las becas
	 * que se encuentran en el array becas.
	 * 
	 * Para ello vamos a crear un m�todo est�tico esCompatible de tipo booleano en
	 * el cual le pasamos la variable becaProv de tipo Beca, un array x tipo entero,
	 * una variable level de tipo entero y un array becas de tipo Beca.
	 * 
	 * Dentro del m�todo vamos a crear una variable comp de tipo booleano
	 * inicializada a true, como podemos ver despu�s creamos un bucle for en el que
	 * vamos a recorrer todos los elementos del array x hasta el �ndice level.
	 * Dentro del bucle vamos a crear otro bucle interno pero de tipo if en el cual
	 * vamos a comparar todas las posiciones del array x con 1, es decir, si la
	 * posicion que actualmente se esta comparando es igual a 1 se selecciona esa
	 * beca y si es asi, se obtiene el objeto Beca correspondiente en el array becas
	 * y se comprueba si hay alg�n solapamiento en las fechas entre becaProv y
	 * becaInd.
	 * 
	 * Si se encuentra solapamiento la variable comp se estable a false y se sale
	 * del bucle. Si no se encuentra ning�n solapamiento se sigue iterando.
	 * Finalmente, el m�todo retorna el valor de comp.
	 * 
	 * 
	 * @param becaProv Beca a la que se est� evaluando si es compatible
	 * @param x        Soluci�n provisional al problema
	 * @param level    Indica el nivel de profundidad del arbol de Backtracking
	 * @param becas    Array con las becas almacenadas en el archivo .dat
	 * @return verdadero Si la soluci�n nueva es compatible
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
	 * El objetivo de este m�todo es la mejor beca que puede optar.
	 * 
	 * Para ello vamos a crear un m�todo est�tico esMejor de tipo booleano, en el
	 * cual le vamos a pasar tres arrays, el primero es un array x de tipo entero,
	 * el segundo es un array soluci�n de tipo entero y por �ltimo un array becas de
	 * tipo Beca.
	 * 
	 * Dentro del m�todo vamos a crear variables sx y ss de tipo entero inicializado
	 * a 0, creamos un bucle for con el cual vamos a recorrer el array x, dentro
	 * creamos otro bucle de tipo if en el en cual vamos a comparar las posiciones
	 * del array x con 1, es decir, si la posici�n que actualmente se esta
	 * comparando es igual a 1 se almacena en sx y le sumamos lo que tiene m�s lo
	 * que hay en el array becas en esas posiciones y cerramos el bucle if.
	 * 
	 * Abrimos el bucle if en el en cual vamos a comparar las posiciones del array
	 * soluciones con 1, es decir, si la posici�n que actualmente se est� comparando
	 * es igual a 1 se almacena en ss y le sumamos lo que tiene m�s lo que hay en el
	 * array becas en esas posiciones y cerramos el bucle if.
	 * 
	 * Finalmente el m�todo retorna el valor de sx > ss.
	 * 
	 * 
	 * @param x        Soluci�n provisional al problema
	 * @param solucion Soluci�n del problema que podr�a dejar de serlo en este
	 *                 momento
	 * @param becas    Array con las becas almacenadas en el archivo .dat
	 * @return verdadero Si la soluci�n nueva es mejor que la anterior
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
