package ar.edu.unlp.info.oo1.ejercicio15;

import java.time.LocalDate;

public class Reserva {
	private Usuario inquilino;
	private LapseDate fecha;
	private Propiedad propiedad;
	
	public Reserva(Usuario unInquilino, LapseDate unaFecha, Propiedad unaPropiedad) {
		this.inquilino = unInquilino;
		this.fecha = unaFecha;
		this.propiedad = unaPropiedad;
	}
	
	public Usuario getInquilino() {
		return this.inquilino;
	}
	
	public LapseDate getFecha() {
		return this.fecha;
	}
	
	public Propiedad getPropiedad() {
		return this.propiedad;
	}
	
	public void setInquilino(Usuario unInquilino) {
		this.inquilino = unInquilino;
	}
	
	public void setFecha(LapseDate unaFecha) {
		this.fecha = unaFecha;
	}
	
	public void setPropiedad(Propiedad unaPropiedad) {
		this.propiedad = unaPropiedad;
	}
	
	public double calcularPrecio() {
		return (this.getFecha().sizeInDays() * this.getPropiedad().getPrecio());
	}
	
	public boolean fechaPosterior() {
		return LocalDate.now().isBefore(this.getFecha().getFrom());
	}
	
	public boolean estaOcupado(LapseDate unaFecha) {
		return (this.getFecha().overlaps(unaFecha) || unaFecha.overlaps(this.getFecha()));
	}
	
	public double getPrecioReembolso(LocalDate fechaCancelacion, Politica unaPolitica) {
		return unaPolitica.calcularReembolso(fechaCancelacion, this.fecha.getFrom(), this.calcularPrecio());
	}
}