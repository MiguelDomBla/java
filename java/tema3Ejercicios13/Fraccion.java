package tema3Ejercicios13;
import java.util.Scanner;

public class Fraccion {
	Scanner sc = new Scanner(System.in);	//Si declaro scanner aquí ya no hace falta que lo declare en los métodos
	/* Crea una clase llamada Fracción. El numerador y el denominador de la fracción se almacenarán en sendos atributos, que serán números enteros y 
	 * los declararemos del tipo envoltorio correspondiente.*/
	private Integer numerador, denominador;
	private PosiNega signo;

	
	/* Al crear un objeto Fracción, siempre deben inicializarsesus atributos. 
	 * La única forma de asignar valores al numerador y denominador de un objeto Fracción debe ser al crearse el objeto. --> no hay setter*/
		//Solo hay un constructor con los dos atributos
	public Fraccion(int numerador, int denominador) {
		this.numerador = Integer.valueOf(numerador);		//Lo hago de la "forma" formal
		this.denominador = Integer.valueOf(denominador);
			/*No debe admitirse el valor 0 para el denominador. Si, alcrearse la fracción, se recibe un 0 para el denominador,
			 * debe mostrarse un mensaje advirtiendo del error y solicitarque se introduzca otro valor por teclado (e insistir hastaque así se haga).*/
		while (this.denominador.equals(0)) {	//si el denominador es cero le decimos que lo introduzca
			System.out.println("El denominador no puede ser 0, la fracción sería una indeterminación.\nPor favor, introduce un denominador distinto de cero.");
			this.denominador = Integer.valueOf(sc.nextInt());
		}
		//Deberíamos poder sumar fracciones con el mismo denominador pero con el signo cambiado, para ello si el denominador es negativo cambio el signo al numerado (además visualmente queda mejor)
		if (denominador<0) {
			this.denominador*=-1;
			this.numerador*=-1;
		}
		
		//Muestro la fracción.
		System.out.printf("Has introducido %s", toString(this.numerador, this.denominador));
		
		//Al crear el objeto llamo al método signo para que ya me quede almacenado
		signo=signo();
	}


	/* Implementa la encapsulación y los métodos que permitan consultar el valor de los atributos. --> getter */
	public Integer getNumerador() {
		return numerador;
	}
	public Integer getDenominador() {
		return denominador;
	}
	
	/* La clase Fracción debe tener métodos para sumar, restar, multiplicar y dividir fracciones. 
	 * Cualquiera de ellos, al ser invocado desde un objeto Fracción, recibirá por parámetro otro objeto Fracción, 
	 * con el que debe hacer la operación que sea. El resultado de la operación se almacenará en los atributos del objeto que invocó al método. */
	 		//Creo un atributo que sea el objeto Fraccion
//	private Fraccion fraccion2;		No hace falta hacer esto en este caso
	
	void multiplicacion (Fraccion fraccion2) {		//Para multiplicar le paso los datos de la nueva fracción
		System.out.printf("\nEl resultado de multiplicar: %s", toString(numerador, denominador));
		this.numerador = this.numerador*fraccion2.numerador;
		this.denominador = this.denominador*fraccion2.denominador;
		
		//Muestro el resultado de la multiplicacion.
		System.out.printf("*%s= %s", toString(fraccion2.numerador, fraccion2.denominador), toString(this.numerador, this.denominador));	
	}
	void suma (Fraccion fraccion2) {
		/* Si los denominadores no son iguales, no se puederealizar la operación.*/
		//Primero compruebo esto
		if (this.denominador.equals(fraccion2.denominador)) {	//Si los denominadores coinciden, los sumo
			System.out.printf("\nEl resultado de sumar: %s", toString(numerador, denominador));
			this.numerador = this.numerador+fraccion2.numerador;	
			System.out.printf("+%s= %s", toString(fraccion2.numerador, fraccion2.denominador), toString(this.numerador, this.denominador));
		}
		else {
			System.out.println("\nLo siento, tu nivel actual no te permite sumar dos fracciones con diferente denominador.");
		}
	}
	void resta (Fraccion fraccion2) {
		/* Si los denominadores no son iguales, no se puede realizar la operación.*/
		//Primero compruebo esto
		if (this.denominador.equals(fraccion2.denominador)) {	//Si los denominadores coinciden, los sumo
			System.out.printf("\nEl resultado de restar: %s", toString(numerador, denominador));
			this.numerador = this.numerador-fraccion2.numerador;	
			System.out.printf("-%s= %s", toString(fraccion2.numerador, fraccion2.denominador), toString(this.numerador, this.denominador));
		}
		else {
			System.out.println("\nLo siento, tu nivel actual no te permite restar dos fracciones con diferente denominador.");
		}
	}
	void division (Fraccion fraccion2) {
		System.out.printf("\nEl resultado de dividir: %s", toString(numerador, denominador));
		this.numerador = this.numerador*fraccion2.denominador;
		this.denominador = this.denominador*fraccion2.numerador;
		
		//Muestro el resultado de la multiplicacion.
		System.out.printf(":%s= %s", toString(fraccion2.numerador, fraccion2.denominador), toString(this.numerador, this.denominador));	
	}
	
	/* Habrá un atributo más que servirá para indicar si la fracción es positiva o negativa y esos serán los dos únicos valores que podrá tomar dicho atributo,
	 * que hay que declararlo de un tipo enumerado que también debes implementar. El valor de este atributo debe asignarse al crear el objeto 
	 * (según sean los valores de los otrosatributos), y deberá modificarse (o no, según proceda)cada vez que cambien los valores de los atributos.*/
		private PosiNega signo () {
		//tambien podría haber usado el método signum: Integer.signum(numerador*denominador) si era -1 era negativo, si sale 0 o 1 positivo
		if (numerador<0&&denominador<0 || numerador>0&&denominador>0) {
			signo=PosiNega.POSITIVO;			//Si tienen el mismo signo es positivo
		}
		else {
			signo=PosiNega.NEGATIVO;
		}
		return signo;
	}


	/* También para este último atributo hay que implementar laencapsulación y crear un método que permita consultar su valor.*/
		public PosiNega getSigno() {
			return signo;
		}
	
	/* La clase contará, además, con un método llamado toString que devolverá un String en el que esté representada la
	 * fracción con el formato numerador/denominador.*/
		public String toString(Integer numerador, Integer denominador) {		//como toString es un método public que ya existe y aquí lo sobrecargo, por eso tiene que ser public
			String devuelve = "("+Integer.toString(numerador)+"/"+Integer.toString(denominador)+")";
			return devuelve;
		}

}
