package ar.edu.unlp.info.oo1.ejercicio18;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SistemaTest {
	private Sistema empresa;
	
	@BeforeEach
	void setUp() {
		empresa = new Sistema();
		empresa.agregarEmpleado("Juan", "Tarrio", "2213456", LocalDate.of(2004, 11, 2), false, false);
		empresa.agregarEmpleado("Veronica", "Suarez", "3324567", LocalDate.of(1975, 2, 19), true, true);
		empresa.cargarContratoDePlanta(empresa.getEmpleado(0), LocalDate.of(2020, 10, 10), 2000d, 0d, 0d);
		empresa.cargarContratoPorHoras(empresa.getEmpleado(0), LocalDate.of(1992, 11, 11), 400d, 6, LocalDate.of(1995, 11, 11));
		empresa.cargarContratoPorHoras(empresa.getEmpleado(0), LocalDate.of(1997, 11, 11), 400d, 6, LocalDate.of(2003, 10, 10));
	}
	
	@Test
	void testBuscarEmpleado() {
		assertEquals("Juan", empresa.buscarEmpleado("2213456").getNombre());
	}
	
	@Test
	void testGenerarRecibos() {
		assertEquals(2, empresa.generarRecibos().size());
	}
	
	@Test
	void testObtenerEmpleadosConContratoVencido() {
		assertEquals(1, empresa.obtenerEmpleadosConContratoVencido().size());
	}
}