package ar.edu.unlp.info.oo1.ejercicio17;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InternacionalTest {
	private Llamada internacionalConDuracion;
	private Llamada internacionalSinDuracion;
	
	@BeforeEach
	void setUp() {
		internacionalConDuracion = new Internacional(LocalDate.now(), LocalTime.now(), 20, "numero1", "numero2", "Narnia", "tuVieja");
		internacionalSinDuracion = new Internacional(LocalDate.now(), LocalTime.now(), 0, "numero1", "numero2", "tuVieja", "Narnia");
	}
	
	@Test
	void testCosto() {
		assertEquals(0, internacionalSinDuracion.Costo());
		assertEquals(80, internacionalConDuracion.Costo());
	}
}