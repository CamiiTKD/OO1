package ar.edu.unlp.info.oo1.ejercicio17;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Sistema {
	private List<String> numerosDisponibles;
	private List<Persona> personas;
	
	public Sistema() {
		numerosDisponibles = new ArrayList<String>();
		personas = new ArrayList<Persona>();
	}
	
	public void agregarNumero(String num) {
		this.numerosDisponibles.add(num);
	}
	
	private void quitarNumero() {
		this.numerosDisponibles.remove(0);
	}
	
    private void agregarPersona(Persona persona) {
    	this.personas.add(persona);
    }
	
	public Persona agregarPersonaFisica(String nombre, String direccion, String dni) {
		Persona persona = new Fisica(nombre, direccion, dni, numerosDisponibles.get(0));
		this.quitarNumero();
		this.agregarPersona(persona);
		return persona;
	}
	
	public Persona agregarPersonaJuridica(String nombre, String direccion, String cuit, String tipo) {
		Persona persona = new Juridica(nombre, direccion, cuit, tipo, numerosDisponibles.get(0));
		this.quitarNumero();
		this.agregarPersona(persona);
		return persona;
	}
	
	public Persona buscarPersona(String numero) {
		return this.personas.stream()
				.filter(p -> p.getNumero().equals(numero))
				.findFirst().orElse(null);
	}
	
	public Llamada registrarLlamadaLocal(LocalDate fecha, LocalTime hora, int duracion, String numeroLlama, String numeroRecibe) {
		Persona persona = this.buscarPersona(numeroLlama);
		return persona.registrarLlamadaLocal(fecha, hora, duracion, numeroLlama, numeroRecibe);
	}
	
	public Llamada registrarLlamadaInterurbana(LocalDate fecha, LocalTime hora, int duracion, String numeroLlama, String numeroRecibe, int distancia) {
		Persona persona = this.buscarPersona(numeroLlama);
		return persona.registrarLlamadaInterurbana(fecha, hora, duracion, numeroLlama, numeroRecibe, distancia);
	}
	
	public Llamada registrarLlamadaInternacional(LocalDate fecha, LocalTime hora, int duracion, String numeroLlama, String numeroRecibe, String paisOrigen, String paisDestino) {
		Persona persona = this.buscarPersona(numeroLlama);
		return persona.registrarLlamadaInternacional(fecha, hora, duracion, numeroLlama, numeroRecibe, paisOrigen, paisDestino);
	}
	
	public Factura facturar(Persona cliente, LocalDate fechaInicio, LocalDate fechaFin) {
		return cliente.facturar(fechaInicio, fechaFin);
	}
}