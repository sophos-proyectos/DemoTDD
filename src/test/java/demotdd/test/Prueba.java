package demotdd.test;

import demotdd.Operaciones;
import org.hamcrest.CoreMatchers;
import org.junit.*;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

public class Prueba {

	@BeforeClass
	public static void entorno() {
		System.out.println("Inicio...");
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
			"La suma no es correcta",
			8,
			Operaciones.sumar(5, 3)
		);
	}

	@Test
	public void testDivision() {
		Assert.assertEquals(
			"El cociente entero no es correcto",
			2,
			Operaciones.dividir(10, 5)
		);
	}

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void testExcepcionDivision() {
		expectedException.expect(ArithmeticException.class);
		expectedException.expectMessage("División por cero");
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

	@Test
	public void testNoHayPares() {
		Assert.assertTrue(
			"Debe ser vacío",
			Operaciones.pares(0, 1).isEmpty()
		);

		Assert.assertFalse(
			"Debe tener datos",
			Operaciones.pares(2, 10).isEmpty()
		);
	}

	@Test
	public void testEsPar() {
		Assert.assertThat(
			"No es correcto",
			"Si",
			CoreMatchers.is(Operaciones.esPar(2))
		);
		Assert.assertThat(
			"No es correcto",
			"No",
			CoreMatchers.is(Operaciones.esPar(5))
		);
	}

	@Test
	public void testPromedio() {
		final int[] numeros = new int[] {1,2,3,4,5,6,7,8,9,10};
		Assert.assertEquals(
			"Promedio errado",
			5.5D,
			Operaciones.promedio(numeros),
			0
		);
	}

	@Test
	public void testPromedioImpares() {
		Assert.assertEquals(
			"Promedio de impares no coincide",
			5D,
			Operaciones.promedioImpares(1,2,3,4,5,6,7,8,9,10),
			0
		);
	}

	@Test
	public void testSuperiorA5() {
		Assert.assertThat(
			Operaciones.superiorA5(20),
			CoreMatchers.allOf(CoreMatchers.containsString("20"), CoreMatchers.containsString("mayor"))
		);

		Assert.assertThat(
			Operaciones.superiorA5(5),
			CoreMatchers.allOf(CoreMatchers.containsString("5"), CoreMatchers.containsString("igual"))
		);

		Assert.assertThat(
			Operaciones.superiorA5(2),
			CoreMatchers.allOf(CoreMatchers.containsString("2"), CoreMatchers.containsString("menor"))
		);

	}

}
