package demotdd;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Operaciones {

	private Operaciones() {

	}

	public static int sumar(int v1, int v2) {
		return v1 + v2;
	}

	/**
	 * Hace la división de dos numeros y entrega el resultado
	 * @param dividendo dividendo de la operación
	 * @param divisor divisor de la operación
	 * @return el cociente entero de la división
	 * @throws ArithmeticException cuando se realiza una división por cero
	 */
	public static int dividir(int dividendo, int divisor) {
		if(divisor == 0) {
			throw new ArithmeticException("División por cero");
		}

		return dividendo / divisor;
	}

	public static List<Integer> pares(int inferior, int superior) {
		return IntStream.rangeClosed(inferior, superior).boxed().filter(i -> i % 2 == 0).collect(Collectors.toList());
	}
}
