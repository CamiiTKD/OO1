package ar.edu.unlp.info.oo1.ejercicio15;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestPropiedad {
	private Reserva reserva;
	private Propiedad propiedadSinReservas;
	private Propiedad propiedad;
	private Usuario inquilino;
	private LapseDate periodo1;
	private LapseDate periodo2;
	private LapseDate periodo3;
	private LapseDate periodo4;
	private LapseDate periodo5;
	
	@BeforeEach
	void setUp() {
		inquilino = new Usuario("Vero", "", "");
		propiedad = new Propiedad("Juan", "La Casona", 400d, "373 e/ 2 y 24", new Usuario("Dueño1", "", ""), new Flexible());
		propiedadSinReservas = new Propiedad("Cami", "La Casona", 400d, "373 e/ 2 y 24", new Usuario("Dueño2", "", ""), new Flexible());
		
		periodo1 = new LapseDate(LocalDate.of(2023, 10, 10), LocalDate.of(2023, 10, 11));
		periodo2 = new LapseDate(LocalDate.of(2023, 10, 12), LocalDate.of(2023, 10, 13));
		periodo3 = new LapseDate(LocalDate.of(2023, 10, 8), LocalDate.of(2023, 10, 9));
		periodo4 = new LapseDate(LocalDate.of(2023, 10, 10), LocalDate.of(2023, 10, 10));
		periodo5 = new LapseDate(LocalDate.of(2023, 10, 11), LocalDate.of(2023, 10, 11));
		
		reserva = new Reserva(inquilino, periodo1, propiedad);
		propiedad.agregarReserva(reserva);
	}
	
	@Test
	void testEstaLibre() {
		assertFalse(propiedad.estaLibre(periodo1));
		assertTrue(propiedad.estaLibre(periodo2));
		assertTrue(propiedad.estaLibre(periodo3));
		assertFalse(propiedad.estaLibre(periodo4));
		assertFalse(propiedad.estaLibre(periodo5));
	}
	
	@Test
	void testGetPrecioEnUnPeriodo() {
		assertEquals(400d, propiedad.getPrecioEnUnPeriodo(periodo1));
		assertEquals(0, propiedad.getPrecioEnUnPeriodo(periodo2));
		assertEquals(0, propiedadSinReservas.getPrecioEnUnPeriodo(periodo3));
	}
	
	@Test
	void testCancelarReserva() {
		assertEquals(400d, propiedad.cancelarReserva(LocalDate.of(2023, 10, 9), reserva));
		assertEquals(0, propiedadSinReservas.cancelarReserva(LocalDate.now(), reserva));
	}
}