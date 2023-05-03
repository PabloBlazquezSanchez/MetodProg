package CasoEstudio3;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Esta clase contiene los m�todos necesarios para la implementaci�n del
 * algoritmo voraz que nos permita resolver el problema. El algoritmo no es
 * �ptimo. Por ejemplo, si tenemos un solar de 4 metros y baldosas de tama�os 3,
 * 2 y 1 metros, el algoritmo pondr� una baldosa de 3x3 y quedar�n 7 huecos para
 * baldosas de 1x1 (tres huecos estar�n distribuidos horizontalmente y los otros
 * cuatro lo estar�n verticalmente), esto har�a que en total se tuviesen que
 * utilizar 7 baldosas. Lo optimo hubiese sido que se hubiesen usado cuatro
 * baldosas de 2x2, ya que en total se hubiesen cuatro baldosas.
 */
public class Metodos {

	/**
	 * Objeto de la clase Scanner que se utiliza para leer la entrada de datos desde
	 * la consola del usuario.
	 */
	static Scanner lectura = new Scanner(System.in);

	/**
	 * 
	 * Este m�todo captura el dato introducido por teclado y analiza si se ha
	 * introducido un caracter o un n�mero. Si se introduce un caracter lanza un
	 * mensaje de error y pide al usuario introducir un n�mero positivo, a trav�s de
	 * la excepci�n incluida en la API de Java "Input Mismatch Exception". Lo mismo
	 * ocurre si el n�mero introducido es igual o menor a cero, aunque en este caso
	 * concreto no aparecer� la excepci�n.
	 * 
	 * @return numero El n�mero escrito por el usuario
	 */

	public static int filtrarNumero() {
		int numero = 0;
		boolean comprobacion;
		try {
			do {
				comprobacion = false;
				numero = lectura.nextInt();

				if (numero <= 0) {
					System.out.println("Error. Introduce n�meros mayores que 0:");
					comprobacion = true;
				}
			} while (comprobacion);

		} catch (InputMismatchException ime) { // Detecta si el dato introducido no es un n�mero y lanza un mensaje de
												// error
			System.out.println("S�lo puede escribir n�meros. Int�ntelo de nuevo: ");
			lectura.next();
			numero = filtrarNumero(); // Vuelve a solicitar el dato
		}
		return numero;
	}

	/**
	 * Este m�todo ordena un array de enteros de manera descendente. Primero, se
	 * utiliza el m�todo sort de Arrays para ordenar el array de menor a mayor.
	 * Despu�s, se intercambian los elementos del array, empezando por los extremos
	 * (el primero con el �ltimo, el segundo con el pen�ltimo, y as� sucesivamente)
	 * hasta llegar al centro, utilizando un bucle for.
	 * 
	 *
	 * @param tamanosBaldosas Array con los tama�os de las baldosas sin ordenar
	 * @return tamanosBaldosas Array con los tama�os de las baldosas ordenado de
	 *         manera descendente
	 */
	public static int[] ordenarArray(int[] tamanosBaldosas) {
		Arrays.sort(tamanosBaldosas);
		for (int i = 0, j = tamanosBaldosas.length - 1, tmp; i < j; i++, j--) {
			tmp = tamanosBaldosas[i];
			tamanosBaldosas[i] = tamanosBaldosas[j];
			tamanosBaldosas[j] = tmp;
		}
		return tamanosBaldosas;
	}

	/**
	 * El siguiente m�todo es el coraz�n de nuestro programa, el algoritmo de la
	 * resoluci�n de la colocaci�n de baldosas en el solar. A este m�todo le pasamos
	 * el lado de nuestro solar cuadrado y el array ordenado (orden decreciente) de
	 * los tama�os de baldosas. Lo primero que har� el m�todo ser� hacer una copia
	 * del lado del solar, para usarla en diferentes bucles y como argumento para el
	 * m�todo cabeBaldosa. Tambi�n se define un entero de �ndice actual de tama�o de
	 * baldosa, en conjunto con la variable que guarda el tama�o de la baldosa, en
	 * funci�n de la posici�n actual (proveniente del array). Por �ltimo se crea una
	 * matriz bidimensional, que ser� la soluci�n a nuestro problema: floor o suelo.
	 * Su tama�o ser� el lado del solar en x e y (tamSolar^2)<br>
	 * 
	 * Una vez se han inicializado las variables anteriores, el algoritmo recorrer�
	 * el suelo del solar, usando dos bucles for. N�tese que el algoritmo reinicia 
	 * la baldosa elegida (iterador posicion y variable tamano) para garantizar que 
	 * siempre que sea posible se emplee la baldosa de tama�o superior. Mientras que la 
	 * coordenada ij del solar no est� ocupada (representada con un 0) y la baldosa actual
	 * seleccionada est� dentro del array del tama�o de las baldosas, redefinimos el
	 * tama�o de la baldosa. Esto lo hacemos para comprobar en este momento si la
	 * baldosa cabe en la posici�n actual del solar (ver m�todo cabeBaldosa).<br>
	 * 
	 * De ser as�, a trav�s de otros dos bucles for, estableceremos con el n�mero
	 * del tama�o de baldosa la baldosa, ocupando as� su en el solar. N�tese que
	 * estos dos for recorren �nicamente la longitud del tama�o de baldosa
	 * correspondiente, empezando desde las coordenadas determinadas por i y j (fila
	 * y columna). Si no cabe, pasamos a un tama�o de baldosa menor, representado
	 * como un aumento de la posici�n actual del array de baldosas. Est� m�todo
	 * cuando finalice devolver� la matriz soluci�n.<br><br>
	 * 
	 * --COMPLEJIDAD--<br>
	 * <br>
	 * La complejidad del algoritmo voraz es de la forma: O(algorithm) =
	 * O(preprocesado) + O(m_bucle_principal)�O(soluci�n)<br>
	 * 
	 * La complejidad del preprocesado es la de la ordenaci�n en orden decreciente
	 * del array del tama�o de baldosas. Como comentamos en el caso de estudio 2,
	 * esta es de O(n�logn).<br>
	 * 
	 * Sin embargo, para determinar la del bucle principal y selecci�n de la
	 * soluci�n, debemos considerar las diferentes entradas a nuestro programa para
	 * poder entender cu�nto puede aumentar su tiempo de ejecuci�n:<br><br>
	 * 
	 * 1. El lado del solar. Principalmente el algoritmo se encarga de rellenar con
	 * baldosas un solar cuadrado de lado n, lo que implica bucles anidados de n
	 * iteraciones cada uno. <br>2. La longitud del array de los tipos de baldosa, m.
	 * Cuando va recorriendo el solar, nuestro algoritmo va comprobando si la
	 * baldosa cabe en la coordenada ij. Cuando no sucede esto, se cambia el tipo de
	 * baldosa a uno de tama�o menor. Entonces, a m�s tipos de baldosa, m�s veces se
	 * tendr� que comprobarse si entra, y en caso afirmativo (peor caso), colocarla.
	 * <br>3. El tama�o t de baldosa. Cuando comprobamos de manera iterativa si en un
	 * determinado espacio cabe una baldosa o cuando la estamos colocando, se
	 * emplean dos bucles para ir comprobando coordenada a coordenada. Estos bucles
	 * dependen de los dos primeros, pues marcan la posici�n de inicio para poder
	 * iterar sobre el solar, y el n�mero de iteraciones que hacen depende del lado
	 * de la baldosa que se est� empleando.<br><br>
	 * 
	 * Como nuestro peor caso es: "Recorrer el suelo -> �Cabe la baldosa? -> S� ->
	 * Coloco la baldosa (Y en alg�n momento hay que cambiar de baldosa y repetir
	 * los dos �ltimos sucesos)", tenemos en total 6 sumatorios, 4 de ellos
	 * influenciados por nuestra longitud m:<br><br>
	 * 
	 * Sumatorio{i=0 hasta n-1}de(Sumatorio{j=0 hasta n-1}de(m*[Sumatorio{f=i hasta
	 * i+t-1}de(Sumatorio{c=j hasta j+t-1}de(Sumatorio{g=i hasta
	 * i+t-1}de(Sumatorio{k=j hasta j+t-1}de(1))))])), considerando como constante =
	 * 1 la operaci�n b�sica.
	 * 
	 * Desenvolviendo todos los sumatorios nos resulta en t^4*n^2*m (mayor a nlogn,
	 * lo despreciaremos). Sin embargo, hay que puntualizar un �ltimo detalle: el
	 * tama�o de la baldosa t lo vamos a despreciar para nuestra complejidad en
	 * Big-Theta ya que, principalmente, aunque verifiquemos y coloquemos la baldosa
	 * en el solar, el bucle principal va a seguir recorriendo todo el solar
	 * (nuestro peor caso), independientemente del n�mero del tama�o de baldosa que
	 * se encuentre en cada coordenada del suelo.
	 * 
	 * Finalmente, concretamos que la complejidad del algoritmo en notaci�n
	 * Big-Theta es de O(n^2m)
	 *
	 * @param tamSolar el lado del solar
	 * 
	 * @param tamBaldosas Array de los diferentes tipos de baldosas
	 * 
	 * @return Matriz del suelo del solar resuelto int[][]
	 */
	public static int[][] resolverColocacion(int tamSolar, int[] tamBaldosas) {
		int size = tamSolar;
		int actual = 0;
		int tamano = tamBaldosas[actual];
		int floor[][] = new int[tamSolar][tamSolar];

		for (int i = 0; i < size; i++) {
			actual=0;
			for (int j = 0; j < size; j++) {
				while (floor[i][j] == 0 && actual <= tamBaldosas.length - 1) {
					tamano = tamBaldosas[actual];
					if (cabeBaldosa(tamano, i, j, floor, size)) {
						for (int f = i; f < i + tamano; f++) {
							for (int c = j; c < j + tamano; c++) {
								floor[f][c] = tamano;
							}
						}
					} else {
						actual++;
					}
				}
			}
		}
		return floor;
	}

	/**
	 * Este m�todo verifica si es posible colocar una baldosa en una posici�n dada
	 * dentro de la matriz resultado. Primero, se verifica que la baldosa no se
	 * salga del solar. Si esto sucede, se devuelve false, indicando que no cabe la
	 * baldosa. Luego, se recorren las casillas de la submatriz donde se intentar�
	 * colocar la baldosa, verificando que todas est�n libres (su valor en la matriz
	 * resultado es 0). Si alguna de ellas ya tiene una baldosa colocada, se
	 * devuelve false. Si se recorren todas las casillas sin encontrar ninguna
	 * ocupada, se devuelve true, indicando que cabe la baldosa en esa posici�n.
	 *
	 * 
	 * @param tamano    Tama�o de la baldosa a colocar
	 * @param i         Coordenada 'x' donde se intentar� colocar la baldosa
	 * @param j         Coordenada 'y' donde se intentar� colocar la baldosa
	 * @param resultado Representa el estado actual del solar
	 * @param lado      Tama�o del lado del solar.
	 * @return true - Si cabe la baldosa en esa posici�n
	 */
	private static boolean cabeBaldosa(int tamano, int i, int j, int[][] resultado, int lado) {
		boolean cabe = false;
		if (i + tamano <= lado && j + tamano <= lado) { // primero verifico que la baldosa est� dentro del solar
			cabe = true;
			for (int f = i; cabe && f < i + tamano; f++) {
				for (int c = j; cabe && c < j + tamano; c++) {
					if (resultado[f][c] != 0) {
						cabe = false; // miro que todas casillas candidatas est�n libres. En el momento que una no lo
										// est�, no cabe (condici�n extra de parada)
					}
				}
			}
		}
		return cabe;
	}
}
