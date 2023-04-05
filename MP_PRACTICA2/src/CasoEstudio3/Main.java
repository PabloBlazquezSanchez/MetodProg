package CasoEstudio3;

public class Main {

	public static void main(String[] args) {
		System.out.println("Introduce el valor de N para cacular el tamaño del solar de dimensiones NxN:");
		int tamSolar=Metodos.filtrarNumero();
		System.out.println("Introduce el número de baldosas diferentes: ");
		int[] tamBaldosas = new int[Metodos.filtrarNumero()];
		
		System.out.println("Introduzca el tamaño de las baldosas ordenadas de mayor a menor");
		for (int i=0;i<tamBaldosas.length;i++) {
			System.out.println("Escribe el tamaño del tipo de baldosa "+(i+1)+" de dimensiones NxN:");
			tamBaldosas[i]=Metodos.filtrarNumero();
		}
		
		System.out.println("\n\nDATOS INTRODUCIDOS:");
		System.out.println("Tamaño del solar: "+tamSolar+" x "+tamSolar);
		System.out.println("Tipos de baldosas distintas: "+tamBaldosas.length);
		for(int i=0; i<tamBaldosas.length;i++){
			System.out.println("\tBalsosa "+(i+1)+": "+tamBaldosas[i] +"x"+tamBaldosas[i]);
		}
		
		System.out.println("\n\nSOLUCION:");	
		imprimirMatriz(Metodos.resolverColocacion(tamSolar,tamBaldosas));
	}

	private static void imprimirMatriz(int[][] resultadoMatriz) {
		for (int i=0;i<resultadoMatriz.length;i++){
			for(int j=0;j<resultadoMatriz[i].length;j++){
				System.out.print(resultadoMatriz[i][j]+" ");
			}
			System.out.println();
		}
	}

	
}
