package CasoEstudio2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try {
			Scanner read = new Scanner(new File("InversionsTest_6.dat"));
			int nCases = read.nextInt(); // El primer valor es el número de casos
			double[] a = new double[nCases];
			for (int i = 0; i < nCases; i++) {
				a[i] = read.nextInt();
			}
		} catch (IOException e) {
			System.out.println("ERROR");

		}

	}
}
