package ar.edu.unlp.info.oo1.ejercicio18;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PorHoras extends Contrato{
	private double valor;
	private int horas;
	private LocalDate fechaFin;
	
	public PorHoras(Empleado empleado, LocalDate fechaInicio, double valor, int horas, LocalDate fechaFin) {
		super(empleado, fechaInicio);
		this.valor = valor;
		this.horas = horas;
		this.fechaFin = fechaFin;
	}
	
	public double getValor() {
		return this.valor;
	}
	
	public int getHoras() {
		return this.horas;
	}
	
	public LocalDate getFechaFin() {
		return this.fechaFin;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public void setHoras(int horas) {
		this.horas = horas;
	}
	
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	public boolean estaVencido() {
		return this.getFechaFin().isBefore(LocalDate.now());
	}
	
	public double calcularMonto() {
		return this.valor * this.horas;
	}
	
	public int calcularAnios() {
		if(this.fechaFin.isBefore(LocalDate.now())) {
			return (int) this.getFechaInicio().until(getFechaFin(), ChronoUnit.YEARS);
		}
		return (int) this.getFechaInicio().until(LocalDate.now(), ChronoUnit.YEARS);
	}
}