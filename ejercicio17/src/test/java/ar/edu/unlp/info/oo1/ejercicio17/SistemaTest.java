package ar.edu.unlp.info.oo1.ejercicio17;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SistemaTest {
	private Sistema empresa;
	private Persona cliente1;
	private Persona cliente2;
	private Persona cliente3;
	
	@BeforeEach
	void setUp() {
		empresa = new Sistema();
		empresa.agregarNumero("numero1");
		empresa.agregarNumero("numero2");
		empresa.agregarNumero("numero3");
		empresa.agregarNumero("numero4");
		cliente1 = empresa.agregarPersonaFisica("Juan", "522 nro 1927", "46.132.564");
		cliente3 = empresa.agregarPersonaJuridica("Cami", "522 nro 1927", "22222", "unTipo");
		cliente2 = empresa.agregarPersonaJuridica("Vero", "522 nro 1927", "22222", "unTipo");
		empresa.registrarLlamadaLocal(LocalDate.of(2020, 10, 10), LocalTime.of(9, 30), 10, "numero2", "numero");
		empresa.registrarLlamadaInterurbana(LocalDate.of(2021, 10, 10), LocalTime.of(9, 30), 30, "numero1", "numero", 200);
		empresa.registrarLlamadaInternacional(LocalDate.of(2022, 10, 10), LocalTime.of(9, 30), 15, "numero2", "numero", "Francia", "Mexico");
		empresa.registrarLlamadaInterurbana(LocalDate.of(2021, 10, 10), LocalTime.of(9, 30), 10, "numero2", "numero", 100);
	}
	
	@Test
	void testBuscarPersona() {
		assertEquals("Juan", empresa.buscarPersona("numero1").getNombre());
		assertEquals(null, empresa.buscarPersona("noEsUnNumero"));
	}
	
	@Test
	void testFacturar() {
		assertEquals(0, empresa.facturar(cliente1, LocalDate.of(2020, 10, 8), LocalDate.of(2021, 2, 2)).getMonto());
		assertEquals(0, empresa.facturar(cliente2, LocalDate.of(2020, 10, 8), LocalDate.of(2021, 2, 2)).getMonto());
		assertEquals(100, empresa.facturar(cliente3, LocalDate.of(2019, 10, 8), LocalDate.of(2023, 1, 1)).getMonto());
	}
}