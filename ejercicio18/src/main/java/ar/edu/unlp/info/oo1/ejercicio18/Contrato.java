package ar.edu.unlp.info.oo1.ejercicio18;

import java.time.LocalDate;

public abstract class Contrato {
	private Empleado empleado;
	private LocalDate fechaInicio;
	
	public Contrato(Empleado empleado, LocalDate fechaInicio) {
		this.empleado = empleado;
		this.fechaInicio = fechaInicio;
	}
	
	public LocalDate getFechaInicio() {
		return this.fechaInicio;
	}
	
	public Empleado getEmpleado() {
		return this.empleado;
	}
	
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	public abstract boolean estaVencido();
	
	public abstract double calcularMonto();
	
	public abstract int calcularAnios();
}