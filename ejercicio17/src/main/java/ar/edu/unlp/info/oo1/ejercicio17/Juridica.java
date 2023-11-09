package ar.edu.unlp.info.oo1.ejercicio17;

import java.time.LocalDate;

public class Juridica extends Persona{
	private String cuit;
	private String tipo;
	
	public Juridica(String nombre, String direccion, String cuit, String tipo) {
		super(nombre, direccion);
		this.cuit = cuit;
		this.tipo = tipo;
	}
	
	public Juridica(String nombre, String direccion, String cuit, String tipo, String numero) {
		super(nombre, direccion, numero);
		this.cuit = cuit;
		this.tipo = tipo;
	}
	
	public String getCuit() {
		return this.cuit;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public Factura facturar(LocalDate fechaInicio, LocalDate fechaFin) {
		double monto =  this.calcularMonto(fechaInicio, fechaFin);
		Factura factura = new Factura(this, fechaInicio, fechaFin, monto);
		super.agregarFactura(factura);
		return factura;
	}
}