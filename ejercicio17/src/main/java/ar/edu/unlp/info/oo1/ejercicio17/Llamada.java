package ar.edu.unlp.info.oo1.ejercicio17;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Llamada {
	private LocalDate fecha;
	private LocalTime hora;
	private double duracion;
	private String numeroLlama;
	private String numeroRecibe;
	
	public Llamada(LocalDate fecha, LocalTime hora, double duracion, String numeroLlama, String numeroRecibe) {
		this.fecha = fecha;
		this.hora = hora;
		this.duracion = duracion;
		this.numeroLlama = numeroLlama;
		this.numeroRecibe = numeroRecibe;
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}
	
	public LocalTime getHora() {
		return this.hora;
	}
	
	public double getDuracion() {
		return this.duracion;
	}
	
	public String getNumeroLlama() {
		return this.numeroLlama;
	}
	
	public String getNumeroRecibe() {
		return this.numeroRecibe;
	}
	
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	
	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}
	
	public void setNumeroLlama(String numeroLlama) {
		this.numeroLlama = numeroLlama;
	}
	
	public void setNumeroRecibe(String numeroRecibe) {
		this.numeroRecibe = numeroRecibe;
	}
	
	public boolean isInLapse(LocalDate fechaComienzo, LocalDate fechaFinal) {
		return (this.getFecha().isAfter(fechaComienzo) && this.getFecha().isBefore(fechaFinal));
	}
	
	public abstract double Costo();
	
}