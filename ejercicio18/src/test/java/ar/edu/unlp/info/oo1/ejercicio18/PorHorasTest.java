package ar.edu.unlp.info.oo1.ejercicio18;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PorHorasTest {
	private Empleado emp1;
	private Empleado emp2;
	private PorHoras contratoVigente;
	private PorHoras contratoVencido;
	
	@BeforeEach
	void setUp() {
		emp1 = new Empleado("Juan", "Tarrio", "2213456", LocalDate.of(2004, 11, 2), false, false);
		contratoVigente = new PorHoras(emp1, LocalDate.of(2020, 10, 10), 500d, 8, LocalDate.of(2030, 10, 10));
		emp2 = new Empleado("Veronica", "Suarez", "3324567", LocalDate.of(1975, 2, 19), true, true);
		contratoVencido = new PorHoras(emp2, LocalDate.of(1992, 11, 11), 400d, 6, LocalDate.of(2022, 10, 10));
	}
	
	@Test
	void testEstaVencido() {
		assertFalse(contratoVigente.estaVencido());
		assertTrue(contratoVencido.estaVencido());
	}
	
	@Test
	void testCalcularMonto() {
		assertEquals(4000d, contratoVigente.calcularMonto());
		assertEquals(2400d, contratoVencido.calcularMonto());
	}
	
	@Test
	void testCalcularAnios() {
		assertEquals(3, contratoVigente.calcularAnios());
		assertEquals(29, contratoVencido.calcularAnios());
	}
}
