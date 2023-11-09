package ar.edu.unlp.info.oo1.ejercicio17;

import java.time.LocalDate;

public class Fisica extends Persona {
	private String dni;
	
	public Fisica(String nombre, String direccion, String dni) {
		super(nombre, direccion);
		this.dni = dni;
	}
	
	public Fisica(String nombre, String direccion, String dni, String numero) {
		super(nombre, direccion, numero);
		this.dni = dni;
	}
	
	public String getDni() {
		return this.dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public Factura facturar(LocalDate fechaInicio, LocalDate fechaFin) {
		double monto =  this.calcularMonto(fechaInicio, fechaFin);
		monto = monto * 0.9;
		Factura factura = new Factura(this, fechaInicio, fechaFin, monto);
		super.agregarFactura(factura);
		return factura;
	}
}