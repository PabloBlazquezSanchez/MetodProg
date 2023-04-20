package CasoEstudio4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		leerFichero();
	}

	public static void leerFichero() {
		try {
			Scanner read = new Scanner(new File("beca.dat"));
			int nFilas = read.nextInt();// El primer valor es el número de filas totales que hay en el fichero
			Beca becas[] = new Beca[nFilas];
			for (int i = 0; i < nFilas; i++) {
				String estructura = read.nextLine();
				String[] data = estructura.split("\t");
				becas[i].setId(Integer.parseInt(data[0]));
				becas[i].setfInicio(Integer.parseInt(data[1]));
				becas[i].setfFin(Integer.parseInt(data[2]));
				becas[i].setDinero(Integer.parseInt(data[3]));
			}
		} catch (FileNotFoundException e) { // Si el fichero a buscar no existe lanza este mensaje de error y finaliza
											// el programa
			System.out.println("El fichero no existe en el directorio de búsqueda.\n"
					+ "El programa no puede continuar ejecutándose. Fin del Programa.");
			System.exit(0); // Finaliza el programa
		} catch (@SuppressWarnings("hiding") IOException e) { // Detecta otros errores
			e.printStackTrace();
		}
	}
}