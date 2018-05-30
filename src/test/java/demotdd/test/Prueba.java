package demotdd.test;

import demotdd.Operaciones;
import org.junit.*;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

public class Prueba {

	@BeforeClass
	public static void entorno() {
		System.out.println("Entorno...");
	}

	@Before
	public void antesDe() {
		System.out.println("Antes de...");
	}

	@After
	public void despuesDe() {
		System.out.println("Despues de...");
	}

	@AfterClass
	public static void cierre() {
		System.out.println("Cierre...");
	}

	@Test
	public void testSuma() {
		Assert.assertEquals(
			"La suma no dio",
			8,
			Operaciones.sumar(5, 3)
		);
	}

	@Test
	public void testDivision() {
		Assert.assertEquals(
			2,
			Operaciones.dividir(10, 5)
		);

	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testExcepcionDivision() {
		thrown.expect(ArithmeticException.class);
		thrown.expectMessage("División por cero");
		Assert.assertEquals(
			2,
			Operaciones.dividir(10, 0)
		);
	}

	@Test
	public void testEncontrarPares() {
		Assert.assertEquals(
			"No son iguales",
			Arrays.asList(2,4,6,8,10),
			Operaciones.pares(1, 10)
		);
	}
}
