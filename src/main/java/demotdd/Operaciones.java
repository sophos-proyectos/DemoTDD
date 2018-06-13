package demotdd;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Operaciones {

	private Operaciones() {

	}

	public static int sumar(int p1, int p2) {
		return p1 + p2;
	}

	public static int dividir(int dividendo, int divisor) {
		if(divisor == 0) {
			throw new ArithmeticException("División por cero");
		}
		return dividendo / divisor;
	}

	public static List<Integer> pares(int inferior, int superior) {
		return IntStream.rangeClosed(inferior, superior)
	       .filter(i -> i != 0 && i % 2 == 0)
	       .boxed()
	       .collect(Collectors.toList())
		;
	}

	public static String esPar(int numero) {
		return numero % 2 == 0 ? "Si" : "No";
	}

	public static double promedio(int... numeros) {
		double suma = 0;
		for (int numero : numeros) {
			suma += numero;
		}
		return suma / numeros.length;
	}

	public static double promedioImpares(int... numeros) {
		return Arrays.stream(numeros).asDoubleStream().filter(d -> d % 2 != 0).average().orElse(0);
	}

	public static String superiorA5(int numero) {
		String rango;
		if(numero > 5) {
			rango = "mayor";
		} else if (numero < 5) {
			rango = "menor";
		} else {
			rango = "igual";
		}
		return "El número " + numero + " es " + rango + " a 5";
	}

}
