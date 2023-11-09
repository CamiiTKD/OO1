package ar.edu.unlp.info.oo1.ejercicio18;

import java.time.LocalDate;

public class Recibo {
	private int antiguedad;
	private LocalDate fecha;
	private double monto;
	private Empleado empleado;
	
	public Recibo(int antiguedad, LocalDate fecha, double monto, Empleado empleado) {
		this.antiguedad = antiguedad;
		this.fecha = fecha;
		this.monto = monto;
		this.empleado = empleado;
	}
	
	public int getAntiguedad() {
		return this.antiguedad;
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}
	
	public double getMonto() {
		return this.monto;
	}
	
	public Empleado getEmpleado() {
		return this.empleado;
	}
	
	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
	
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public void setMonto(double monto) {
		this.monto = monto;
	}
	
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
}