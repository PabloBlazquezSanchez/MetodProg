package CasoEstudio3;

public class Main {

	public static void main(String[] args) {
		System.out.println("Introduce el valor de N para cacular el tamaño del solar de dimensiones NxN:");
		int tamanoSolar=Metodos.filtrarNumero();
		System.out.println("Introduce el número de baldosas diferentes: ");
		int[] tamanoBaldosas = new int[Metodos.filtrarNumero()];
		
		System.out.println("Introduzca el tamaño de las baldosas ordenadas de mayor a menor");
		for (int i=0;i<tamanoBaldosas.length;i++) {
			System.out.println("Escribe el tamaño del tipo de baldosa "+(i+1)+" de dimensiones NxN:");
			tamanoBaldosas[i]=Metodos.filtrarNumero();
		}
		
		System.out.println("\n\nDATOS INTRODUCIDOS:");
		System.out.println("Tamaño del solar: "+tamanoSolar+" x "+tamanoSolar);
		System.out.println("Tipos de baldosas distintas: "+tamanoBaldosas.length);
		for(int i=0; i<tamanoBaldosas.length;i++){
			System.out.println("\tBalsosa "+(i+1)+": "+tamanoBaldosas[i] +"x"+tamanoBaldosas[i]);
		}
		
		System.out.println("\n\nSOLUCION:");	
		imprimirMatriz(resolverColocacion(tamanoSolar,tamanoBaldosas));
	}

	private static void imprimirMatriz(int[][] resultadoMatriz) {
		for (int i=0;i<resultadoMatriz.length;i++){
			for(int j=0;j<resultadoMatriz[i].length;j++){
				System.out.print(resultadoMatriz[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static int [][] resolverColocacion(int tamanoSolar, int [] tamanosBaldosas){
		return null;
	}
}
