package tema3Ejercicios13;

import java.util.Scanner;

public class Ejecutable {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Vamos a crear una fracción.\nIntroduce el numerador: ");
		int num = entrada.nextInt();
		System.out.print("Introduce ahora el denominador: ");
		int den = entrada.nextInt();

		//Creo el objeto fracción
		Fraccion fraccion1 = new Fraccion(num,den);
		System.out.println("\nEl signo es: "+fraccion1.getSigno());
		
		//Para probar creo una segunda fraccion
		System.out.println();
		System.out.print("\nVamos a otra fracción.\nIntroduce el numerador: ");
		num = entrada.nextInt();
		System.out.print("Introduce ahora el denominador: ");
		den = entrada.nextInt();
		Fraccion fraccion2 = new Fraccion(num,den);
		System.out.println("\nEl signo es: "+fraccion2.getSigno());
		
		//Ahora pruebo las operaciones pasandole al primer objeto lo del segundo. Hago suma y resta primero para no cambiar los denominadores
		fraccion1.suma(fraccion2);
		fraccion1.resta(fraccion2);
		fraccion1.multiplicacion(fraccion2);
		fraccion1.division(fraccion2);
		

		entrada.close();
	}

}
