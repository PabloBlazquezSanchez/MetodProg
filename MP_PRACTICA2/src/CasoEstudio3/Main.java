package CasoEstudio3;

public class Main {

	public static void main(String[] args) {
		System.out.println("Introduce el n�mero de baldosas diferentes: ");
		int[] baldosas = new int[Metodos.filtrarNumero()];
		
		for (int i=0;i<baldosas.length;i++) {
			System.out.println("Escribe el tama�o del tipo de baldosa "+i);
			baldosas[i]=Metodos.filtrarNumero();
			
		}

	}

}
