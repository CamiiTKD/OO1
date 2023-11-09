package ar.edu.unlp.info.oo1.ejercicio17;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Persona {
	private String nombre;
	private String direccion;
	private String numero;
	private List<Llamada> llamadas;
	private List<Factura> facturas;
 	
	public Persona(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.numero = null;
		this.llamadas = new ArrayList<Llamada>();
		this.facturas = new ArrayList<Factura>();
	}
	
	public Persona(String nombre, String direccion, String numero) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.numero = numero;
		this.llamadas = new ArrayList<Llamada>();
		this.facturas = new ArrayList<Factura>();
	}
	
	public String getNumero() {
		return this.numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getDireccion() {
		return this.direccion;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	private void agregarLlamada(Llamada llamada) {
		this.llamadas.add(llamada);
	}
	
	public void agregarFactura(Factura factura) {
		this.facturas.add(factura);
	}
	
	public Llamada registrarLlamadaLocal(LocalDate fecha, LocalTime hora, double duracion, String numeroLlama, String numeroRecibe){
		Llamada llamada = new Local(fecha, hora, duracion, numeroLlama, numeroRecibe);
		this.agregarLlamada(llamada);
		return llamada;
	}
	
	public Llamada registrarLlamadaInterurbana(LocalDate fecha, LocalTime hora, double duracion, String numeroLlama, String numeroRecibe, int distancia){
		Llamada llamada = new Interurbana(fecha, hora, duracion, numeroLlama, numeroRecibe, distancia);
		this.agregarLlamada(llamada);
		return llamada;
	}
	
	public Llamada registrarLlamadaInternacional(LocalDate fecha, LocalTime hora, double duracion, String numeroLlama, String numeroRecibe, String paisOrigen, String paisDestino){
		Llamada llamada = new Internacional(fecha, hora, duracion, numeroLlama, numeroRecibe, paisOrigen, paisDestino);
		this.agregarLlamada(llamada);
		return llamada;
	}
	
	public double calcularMonto(LocalDate fechaInicio, LocalDate fechaFin) {
		return this.llamadas.stream()
				.filter(p -> p.isInLapse(fechaInicio, fechaFin))
				.mapToDouble(p -> p.Costo()).sum();
	}
	
	public abstract Factura facturar(LocalDate fechaInicio, LocalDate fechaFin);
}