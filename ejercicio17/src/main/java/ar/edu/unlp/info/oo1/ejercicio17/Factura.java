package ar.edu.unlp.info.oo1.ejercicio17;

import java.time.LocalDate;

public class Factura {
	private Persona cliente;
	private LocalDate fechaFacturacion;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private double montoTotal;

	public Factura (Persona cliente, LocalDate fechaInicio, LocalDate fechaFin, double montoTotal) {
		this.cliente = cliente;
		this.fechaFacturacion = LocalDate.now();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.montoTotal = montoTotal;
	}
	
	public double getMonto() {
		return this.montoTotal;
	}
}