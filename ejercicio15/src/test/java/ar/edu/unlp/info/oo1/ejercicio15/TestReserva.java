package ar.edu.unlp.info.oo1.ejercicio15;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestReserva {
	private Reserva reservaPasada;
	private Reserva reservaDespues;
	private Propiedad propiedad;
	private Usuario inquilino;
	
	@BeforeEach
	void setUp() {
		inquilino = new Usuario("Vero", "", "");
		propiedad = new Propiedad("Juan", "La Casona", 400d, "373 e/ 2 y 24", new Usuario("Maria", "", ""), new Moderada());
		LapseDate fecha1 = new LapseDate(LocalDate.of(2023, 10, 10), LocalDate.of(2023, 10, 11));
		LapseDate fecha2 = new LapseDate(LocalDate.now().plusDays(2), LocalDate.now().plusDays(4));
		reservaPasada = new Reserva(inquilino, fecha1, propiedad);
		reservaDespues = new Reserva(inquilino, fecha2,propiedad);
	}
	
	@Test
	void testCalcularPrecio() {
		assertEquals(800d, reservaDespues.calcularPrecio());
	}

	@Test
	void testfechaPosterior() {
		assertFalse(reservaPasada.fechaPosterior());
		assertTrue(reservaDespues.fechaPosterior());
	}
	
	@Test
	void testGetPrecioReembolso() {
		assertEquals(800d, reservaDespues.getPrecioReembolso(LocalDate.of(2023, 10, 22), propiedad.getPolitica()));
		assertEquals(400d, reservaDespues.getPrecioReembolso(LocalDate.of(2023, 10, 30), propiedad.getPolitica()));
		assertEquals(0d, reservaPasada.getPrecioReembolso(LocalDate.now(), propiedad.getPolitica()));
	}
}