package ar.edu.unlp.info.oo1.ejercicio18;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DePlanta extends Contrato {
	private double sueldo;
	private double montoPorConyuge;
	private double montoPorHijos;
	
	public DePlanta(Empleado empleado, LocalDate fechaInicio, double sueldo, double montoPorConyuge, double montoPorHijos) {
		super(empleado, fechaInicio);
		this.sueldo = sueldo;
		this.montoPorConyuge = montoPorConyuge;
		this.montoPorHijos = montoPorHijos;
	}
	
	public double getSueldo() {
		return this.sueldo;
	}
	
	public double getMontoPorConyuge() {
		return this.montoPorConyuge;
	}
	
	public double getMontoPorHijos() {
		return this.montoPorHijos;
	}
	
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	
	public void setMontoPorConyuge(double montoPorConyuge) {
		this.montoPorConyuge = montoPorConyuge;
	}
	
	public void setMontoPorHijos(double montoPorHijos) {
		this.montoPorHijos = montoPorHijos;
	}
	
	public boolean estaVencido() {
		return false;
	}
	
	public double calcularMonto() {
		return this.sueldo + this.montoPorConyuge + this.montoPorHijos;
	}
	
	public int calcularAnios() {
		return (int) this.getFechaInicio().until(LocalDate.now(), ChronoUnit.YEARS);
	}
}