package ar.edu.unlp.info.oo1.ejercicio15;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestUsuario {
	private Reserva reserva;
	private Propiedad propiedad;
	private Usuario inquilino;
	private Usuario duenio;
	private LapseDate periodo1;
	
	@BeforeEach
	void setUp() {
		inquilino = new Usuario("Jose Jacinto Rivera", "45.222.222", "373 e/ 2 y 24");
		duenio = new Usuario("Kakaroto", "22.000.000", "377 e/ 2 y 24");
		propiedad = new Propiedad("Vero", "La Casona", 4000d, "371 e/ 2 y 24", duenio, new Estricta());
		duenio.agregarPropiedad(propiedad);
		periodo1 = new LapseDate(LocalDate.of(2023, 10, 10), LocalDate.of(2023, 10, 11));
		reserva = new Reserva(inquilino, periodo1, propiedad);
		duenio.agregarReserva(reserva);
		propiedad.agregarReserva(reserva);
		
	}
	@Test
	void testCalcularIngresos() {
		assertEquals(4000d , duenio.calcularIngresos(periodo1.getFrom(), periodo1.getTo()));
		assertEquals(0d , duenio.calcularIngresos(periodo1.getFrom().plusDays(20), periodo1.getTo().plusDays(20)));
		assertEquals(0d , inquilino.calcularIngresos(periodo1.getFrom(), periodo1.getTo()));
	}
	@Test
	void testObtenerReservas() {
		assertEquals(0 ,inquilino.obtenerReservas().size());
		assertEquals(1 ,duenio.obtenerReservas().size());
	}
}