package ar.edu.unlp.info.oo1.ejercicio17;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InterurbanaTest {
	private Llamada interurbanaConDuracion;
	private Llamada interurbanaSinDuracion;
	
	@BeforeEach
	void setUp() {
		interurbanaConDuracion = new Interurbana(LocalDate.now(), LocalTime.now(), 20, "numero1", "numero2", 300);
		interurbanaSinDuracion = new Interurbana(LocalDate.now(), LocalTime.now(), 0, "numero1", "numero2", 300);
	}
	
	@Test
	void testCosto() {
		assertEquals(5, interurbanaSinDuracion.Costo());
		assertEquals(55, interurbanaConDuracion.Costo());
	}
}