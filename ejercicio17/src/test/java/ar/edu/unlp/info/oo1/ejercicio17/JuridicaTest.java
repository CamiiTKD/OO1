package ar.edu.unlp.info.oo1.ejercicio17;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JuridicaTest {
	private Persona clienteSinLlamadas;
	private Persona clienteConLlamadas;
	
	@BeforeEach
	void setUp() {
		Sistema empresa = new Sistema();
		empresa.agregarNumero("numero1");
		empresa.agregarNumero("numero2");
		empresa.agregarNumero("numero3");
		empresa.agregarNumero("numero4");
		empresa.agregarNumero("numero5");
		clienteSinLlamadas = new Juridica("Juan", "522 nro 1927", "22222", "unTipo");
		clienteConLlamadas = new Juridica("Cami", "522 nro 1927", "33333", "unTipo");
		clienteConLlamadas.registrarLlamadaLocal(LocalDate.of(2022, 10, 10), LocalTime.of(9, 30), 20, "numero1", "num");
		clienteConLlamadas.registrarLlamadaInterurbana(LocalDate.of(2022, 11, 11), LocalTime.of(9, 30), 10, "numero2", "num", 10);
		clienteConLlamadas.registrarLlamadaInternacional(LocalDate.of(2023, 10, 10), LocalTime.of(9, 30), 20, "numero3", "num", "Argentina", "Holanda");
		clienteConLlamadas.registrarLlamadaInterurbana(LocalDate.of(2021, 10, 10), LocalTime.of(9, 30), 30, "numero4", "num", 500);
		clienteConLlamadas.registrarLlamadaInternacional(LocalDate.of(2020, 10, 10), LocalTime.of(21, 30), 20, "numero5", "num", "Argentina", "Holanda");
	}
	
	@Test
	void testCalcularMonto() {
		assertEquals(0d, clienteSinLlamadas.calcularMonto(LocalDate.of(2021, 9, 9), LocalDate.of(2023, 9, 9)));
		assertEquals(280d, clienteConLlamadas.calcularMonto(LocalDate.of(2020, 1, 1), LocalDate.of(2024, 1, 1))); //todo
		assertEquals(105d, clienteConLlamadas.calcularMonto(LocalDate.of(2022, 11, 9), LocalDate.of(2023, 11, 11))); //parte
		assertEquals(0d, clienteConLlamadas.calcularMonto(LocalDate.of(1995, 10, 9), LocalDate.of(2000, 12, 20))); //nada
	}
	
	@Test
	void testFacturar() {
		assertEquals(0, clienteSinLlamadas.facturar(LocalDate.of(2021, 9, 9), LocalDate.of(2023, 9, 9)).getMonto());
		assertEquals(280d, clienteConLlamadas.facturar(LocalDate.of(2020, 1, 1), LocalDate.of(2024, 1, 1)).getMonto());
	}
}