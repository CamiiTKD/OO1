package ar.edu.unlp.info.oo1.ejercicio15;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Usuario {
	private String nombre;
	private String direccion;
	private String DNI;
	private List<Propiedad> propiedades;
	
	public Usuario(String unNombre, String unaDireccion, String unDni) {
		this.nombre = unNombre;
		this.direccion = unaDireccion;
		this.DNI = unDni;
		this.propiedades  = new ArrayList<Propiedad>();
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String unaDireccion() {
		return this.direccion;
	}
	
	public String getDNI() {
		return this.DNI;
	}
	
	public List<Propiedad> getPropiedades(){
		return this.propiedades;
	}
	
	public void setNombre(String unNombre) {
		this.nombre = unNombre;
	}
	
	public void setDireccion(String unaDireccion) {
		this.direccion = unaDireccion;
	}
	
	public void setDNI(String unDni) {
		this.DNI = unDni;
	}
	
	public void agregarPropiedad(Propiedad unaPropiedad) {
		this.propiedades.add(unaPropiedad);
	}
	
	public void agregarReserva(Reserva unaReserva) {
		unaReserva.getPropiedad().agregarReserva(unaReserva);
	}
	
	public List<Reserva> obtenerReservas(){
		List<Reserva> lista = this.getPropiedades().stream()
				.flatMap(propiedad -> propiedad.getReservas().stream())
				.collect(Collectors.toList());
		return lista;
	}
	
	public double calcularIngresos(LocalDate desde, LocalDate hasta) {
		LapseDate fecha = new LapseDate(desde, hasta);
		return this.getPropiedades().stream()
				.mapToDouble(p -> p.getPrecioEnUnPeriodo(fecha))
				.sum();
	}
	
	public void eliminarReserva(Reserva unaReserva) {
		this.propiedades.stream()
		.flatMap(p -> p.getReservas().stream())
		.filter(p -> p == unaReserva)
		.findFirst();
	}
}