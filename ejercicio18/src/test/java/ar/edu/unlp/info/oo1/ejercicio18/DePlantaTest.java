package ar.edu.unlp.info.oo1.ejercicio18;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DePlantaTest {
	private Empleado emp1;
	private Empleado emp2;
	private DePlanta contrato1;
	private DePlanta contrato2;
	
	@BeforeEach
	void setUp() {
		emp1 = new Empleado("Juan", "Tarrio", "2213456", LocalDate.of(2004, 11, 2), false, false);
		contrato1 = new DePlanta(emp1, LocalDate.of(2023, 10, 10), 2000d, 0d, 0d);
		emp2 = new Empleado("Veronica", "Suarez", "3324567", LocalDate.of(1975, 2, 19), true, true);
		contrato2 = new DePlanta(emp2, LocalDate.of(1992, 11, 11), 3000d, 1200d, 1000d);
	}
	
	@Test
	void testEstaVencido() {
		assertFalse(contrato1.estaVencido());
		assertFalse(contrato2.estaVencido());
	}
	
	@Test
	void testCalcularMonto() {
		assertEquals(2000d, contrato1.calcularMonto());
		assertEquals(5200d, contrato2.calcularMonto());
	}
	
	@Test
	void testCalcularAnios() {
		assertEquals(0, contrato1.calcularAnios());
		assertEquals(30, contrato2.calcularAnios());
	}
}