package ar.edu.unlp.info.oo1.ejercicio17;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LocalTest {
	private Llamada localConDuracion;
	private Llamada localSinDuracion;
	
	@BeforeEach
	void setUp() {
		localConDuracion = new Local(LocalDate.now(), LocalTime.now(), 20, "numero1", "numero2");
		localSinDuracion = new Local(LocalDate.now(), LocalTime.now(), 0, "numero3", "numero4");
	}
	
	@Test
	void testCosto() {
		assertEquals(0, localSinDuracion.Costo());
		assertEquals(20, localConDuracion.Costo());
	}
}