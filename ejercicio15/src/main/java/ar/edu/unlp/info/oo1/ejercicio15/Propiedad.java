package ar.edu.unlp.info.oo1.ejercicio15;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

public class Propiedad {
	private String nombre;
	private String descripcion;
	private double precio;
	private String direccion;
	private Usuario propietario;
	private Politica politica;
	private List<Reserva> reservas;
	
	public Propiedad(String unNombre, String unaDescripcion, double unPrecio, String unaDireccion, Usuario unPropietario, Politica unaPolitica) {
		this.nombre = unNombre;
		this.descripcion = unaDescripcion;
		this.precio = unPrecio;
		this.direccion = unaDireccion;
		this.propietario = unPropietario;
		this.politica = unaPolitica;
		this.reservas = new ArrayList<Reserva>();
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public double getPrecio() {
		return this.precio;
	}
	
	public String getDireccion() {
		return this.direccion;
	}
	
	public Usuario getPropietario() {
		return this.propietario;
	}
	
	public List<Reserva> getReservas() {
		return this.reservas;
	}
	
	public void setNombre(String unNombre) {
		this.nombre = unNombre;
	}
	
	public void setDescripcion(String unaDescripcion) {
		this.descripcion = unaDescripcion;
	}
	
	public void setPrecio(double unPrecio) {
		this.precio = unPrecio;
	}
	
	public void setDireccion(String unaDireccion) {
		this.direccion = unaDireccion;
	}
	
	public void setPropietario(Usuario unPropietario) {
		this.propietario = unPropietario;
	}
	
	public void agregarReserva(Reserva unaReserva) {
		if(this.estaLibre(unaReserva.getFecha())) {
			this.reservas.add(unaReserva);
		}
	}
	
	public double cancelarReserva(LocalDate unaFecha,Reserva unaReserva) {
		this.eliminarReserva(unaReserva);
		return unaReserva.getPrecioReembolso(unaFecha, this.getPolitica());
	}
	
	public Politica getPolitica() {
		return this.politica;
	}
	
	public void eliminarReserva(Reserva unaReserva) {
		this.reservas.remove(unaReserva);
	}
	
	public boolean estaLibre(LapseDate unaFecha) {
		return this.getReservas().stream()
				.noneMatch(reserva -> reserva.estaOcupado(unaFecha));
	}
	
	public double getPrecioEnUnPeriodo(LapseDate unaFecha) {
		return this.getReservas().stream()
				.filter(p -> p.estaOcupado(unaFecha))
				.mapToDouble(p -> p.calcularPrecio())
				.sum();
	}
}