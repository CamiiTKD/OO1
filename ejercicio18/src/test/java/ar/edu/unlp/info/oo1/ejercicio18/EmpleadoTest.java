package ar.edu.unlp.info.oo1.ejercicio18;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmpleadoTest {
	private Empleado empleadoConContratos;
	private Empleado empleadoSinContratos;
	
	@BeforeEach
	void setUp() {
		empleadoConContratos = new Empleado("Juan", "Tarrio", "2213456", LocalDate.of(2004, 11, 2), false, false);
		empleadoSinContratos = new Empleado("Veronica", "Suarez", "3324567", LocalDate.of(1975, 2, 19), true, true);
		empleadoConContratos.cargarContratoDePlanta(LocalDate.of(2020, 10, 10), 2000d, 0d, 0d);
		empleadoConContratos.cargarContratoPorHoras(LocalDate.of(1992, 11, 11), 400d, 6, LocalDate.of(1995, 11, 11));
		empleadoConContratos.cargarContratoPorHoras(LocalDate.of(1997, 11, 11), 400d, 6, LocalDate.of(2003, 10, 10));
	}
	
	@Test
	void testTieneContratoVencido() {
		assertFalse(empleadoConContratos.tieneContratoVencido());
		assertTrue(empleadoSinContratos.tieneContratoVencido());
	}
	
	@Test
	void testAntiguedad() {
		assertEquals(11, empleadoConContratos.antiguedad());
		assertEquals(0, empleadoSinContratos.antiguedad());
	}
	
	@Test
	void testCalcularAumento() {
		assertEquals(0.5d, empleadoConContratos.calcularAumento());
		assertEquals(0d, empleadoSinContratos.calcularAumento());
	}
	
	@Test
	void calcularMontoTotal() {
		assertEquals(3000d, empleadoConContratos.calcularMontoTotal());
		assertEquals(0d, empleadoSinContratos.calcularMontoTotal());
	}
}