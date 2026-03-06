package drones;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DronMaritimoTest {

	private static DronMaritimo dm;

	private int distanciaMision;
	private double tiempoRespuesta;

	public DronMaritimoTest(int distanciaMision, double tiempoRespuesta) {
		this.distanciaMision = distanciaMision;
		this.tiempoRespuesta = tiempoRespuesta;
	}

	@Parameters
	public static Collection<Object[]> datos() {
		return Arrays.asList(new Object[][] { { 10, 1.0 }, { 20, 2.0 }, { 5, 0.5 } });
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dm = new DronMaritimo("DM1", 120, 10, false, 80);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dm = null;
	}

	@Before
	public void setUp() throws Exception {
		dm.setEstaOperativo(true);
	}

	@After
	public void tearDown() throws Exception {
		dm.setEstaOperativo(false);
	}

	@Test(timeout = 2000)
	public void calculoTiempoRespuesta() {
		assertEquals(tiempoRespuesta, dm.calcularTiempoRespuesta(distanciaMision), 0.01);
	}

	@Ignore
	@Test(timeout = 2000)
	public void testResistenciaBaja() {

	}

	@Test(timeout = 2000)
	public void calculoTiempoRespuestaExcepcion1() {
		Exception errorAtrapado = assertThrows(IllegalArgumentException.class, () -> dm.calcularTiempoRespuesta(-5));
		assertEquals("La distancia de la mision no puede ser negativa", errorAtrapado.getMessage());
	}

	@Test(timeout = 2000)
	public void calculoTiempoRespuestaExcepcion2() {
		Exception errorAtrapado = assertThrows(IllegalArgumentException.class, () -> dm.calcularTiempoRespuesta(900));
		assertEquals("El tiempo de respuesta supera la autonomia del dron", errorAtrapado.getMessage());
	}

	@Test(timeout = 2000)
	public void calculoTiempoRespuestaExcepcion3() {
		dm.setEstaOperativo(false);
		Exception errorAtrapado = assertThrows(IllegalStateException.class, () -> dm.calcularTiempoRespuesta(10));
		assertEquals("El dron no se encuentra operativo", errorAtrapado.getMessage());
	}

}