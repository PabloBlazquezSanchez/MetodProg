package CasoEstudio4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Beca becas[] = leerFichero("Fellowships3400.dat");
		System.out.println("d");
	}

	public static Beca[] leerFichero(String fichero) {
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

		} catch (FileNotFoundException e) { // Si el fichero a buscar no existe lanza este mensaje de error y finaliza el programa
			System.out.println("El fichero no existe en el directorio de b�squeda.\n"
					+ "El programa no puede continuar ejecut�ndose. Fin del Programa.");
			System.exit(0); // Finaliza el programa
		} catch (@SuppressWarnings("hiding") IOException e) { // Detecta otros errores
			e.printStackTrace();
		}
		return null;
	}

}
