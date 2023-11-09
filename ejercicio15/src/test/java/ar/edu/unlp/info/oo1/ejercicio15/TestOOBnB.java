package ar.edu.unlp.info.oo1.ejercicio15;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestOOBnB {
	private Reserva reserva1;
	private Reserva reserva2;
	private Reserva reserva3;
	private Reserva reserva4;
	private Reserva reserva5;
	private Reserva reserva6;
	private Reserva reserva7;
	private Reserva reservaFutura;
	private Propiedad propiedad1;
	private Propiedad propiedad2;
	private Propiedad propiedad3;
	private Usuario inquilino1;
	private Usuario inquilino2;
	private Usuario duenio1;
	private Usuario duenio2;
	private LapseDate periodo1;
	private LapseDate periodo2;
	private LapseDate periodo3;
	private LapseDate periodoFuturo;
	private OOBnB sistema;
	
	@BeforeEach
	void setUp() {
		sistema = new OOBnB();
		
		Usuario u1 = new Usuario("Jose Jacinto Rivera", "44.222.222", "371 e/ 2 y 24");
		Usuario u2 = new Usuario("Jacinto Jacinto Rivera", "43.222.222", "372 e/ 2 y 24");
		Usuario u3 = new Usuario("Jose Jose Rivera", "42.222.222", "373 e/ 2 y 24");
		Usuario u4 = new Usuario("Jacinto Jose Rivera", "41.222.222", "374 e/ 2 y 24");
		inquilino1 = sistema.agregarUsuario(u1);
		inquilino2 = sistema.agregarUsuario(u2);
		duenio1 = sistema.agregarUsuario(u3);
		duenio2 = sistema.agregarUsuario(u4);
		
		Propiedad p1 = new Propiedad("La Casona", "Bien grande", 1, "", duenio1, new Moderada());
		Propiedad p2 = new Propiedad("Procap", "Bing Chilling", 2, "", duenio2, new Flexible());
		Propiedad p3 = new Propiedad("Sistedh", "Turkosone", 2, "", duenio2, new Estricta());
		propiedad1 = sistema.agregarPropiedad(p1);
		propiedad2 = sistema.agregarPropiedad(p2);
		propiedad3 = sistema.agregarPropiedad(p3);
		
		periodo1 = new LapseDate(LocalDate.of(2023, 10, 10), LocalDate.of(2023, 10, 11));
		periodo2 = new LapseDate(LocalDate.of(2023, 10, 12), LocalDate.of(2023, 10, 13));
		periodo3 = new LapseDate(LocalDate.of(2023, 10, 8), LocalDate.of(2023, 10, 9));
		periodoFuturo = new LapseDate(LocalDate.now().plusDays(1), LocalDate.now().plusDays(1));
		reserva1 = sistema.agregarReserva(propiedad1, periodo1.getFrom(), periodo1.getTo(), inquilino1);
		reserva2 = sistema.agregarReserva(propiedad1, periodo1.getFrom(), periodo1.getTo(), inquilino1);
		reserva3 = sistema.agregarReserva(propiedad1, periodo2.getFrom(), periodo2.getTo(), inquilino2);
		reserva4 = sistema.agregarReserva(propiedad1, periodo3.getFrom(), periodo3.getTo(), inquilino2);
		reserva5 = sistema.agregarReserva(propiedad3, periodo2.getFrom(), periodo2.getTo(), inquilino2);
		reserva6 = sistema.agregarReserva(propiedad2, periodo3.getFrom(), periodo3.getTo(), inquilino2);
		reserva7 = sistema.agregarReserva(propiedad3, periodo3.getFrom(), periodo3.getTo(), inquilino2);
		reservaFutura = sistema.agregarReserva(propiedad3, periodoFuturo.getFrom(), periodoFuturo.getTo(), inquilino2);
	}
	
	@Test
	void testGetPropiedadesDisponibles() {
		assertEquals(3, sistema.getPropiedadesDisponibles(LocalDate.of(2023, 12, 28), LocalDate.of(2023, 12, 30)).size());
		assertEquals(2, sistema.getPropiedadesDisponibles(periodo1.getFrom(), periodo1.getTo()).size());
		assertEquals(0, sistema.getPropiedadesDisponibles(periodo3.getFrom(), periodo3.getTo()).size());
	}

	@Test
	void testAgregarReserva() {
		assertNotNull(reserva1);
		assertNull(reserva2);
		assertNotNull(reserva3);
		assertNotNull(reserva4);
		assertNotNull(reserva5);
		assertNotNull(reserva6);
		assertNotNull(reserva7);
		assertEquals(1 , this.inquilino1.obtenerReservas().size());
		assertEquals(6 , this.inquilino2.obtenerReservas().size());
	}
	
	@Test
	void testEliminarReserva() {
		sistema.eliminarReserva(reserva3);
		assertEquals(6, inquilino2.obtenerReservas().size());
		sistema.eliminarReserva(reservaFutura);
		assertEquals(5, inquilino2.obtenerReservas().size());
	}
}