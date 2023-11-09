package ar.edu.unlp.info.oo1.ejercicio18;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

public class Empleado {
	private String nombre;
	private String apellido;
	private String cuil;
	private LocalDate fechaNacimiento;
	private boolean conyuge;
	private boolean hijos;
	private LocalDate fechaInicio;
	private List<Contrato> contratos;
	
	public Empleado(String nombre, String apellido, String cuil, LocalDate fecha, boolean conyuge, boolean hijos) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cuil = cuil;
		this.fechaNacimiento = fecha;
		this.conyuge = conyuge;
		this.hijos = hijos;
		this.fechaInicio = null;
		contratos = new ArrayList<Contrato>();
	}
	
	public Empleado(String nombre, String apellido, String cuil, LocalDate fecha, boolean conyuge, boolean hijos, LocalDate fechaInicio) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cuil = cuil;
		this.fechaNacimiento = fecha;
		this.conyuge = conyuge;
		this.hijos = hijos;
		this.fechaInicio = fechaInicio;
		contratos = new ArrayList<Contrato>();
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getApellido() {
		return this.apellido;
	}
	
	public String getCuil() {
		return this.cuil;
	}
	
	public LocalDate getFechaNacimiento() {
		return this.fechaNacimiento;
	}
	
	public boolean getConyuge() {
		return this.conyuge;
	}
	
	public boolean getHijos() {
		return this.hijos;
	}
	
	public LocalDate getFechaInicio() {
		return this.fechaInicio;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public void setCuil(String cuil) {
		this.cuil = cuil;
	}
	
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public void setConyuge(boolean conyuge) {
		this.conyuge = conyuge;
	}
	
	public void setHijos(boolean hijos) {
		this.hijos = hijos;
	}
	
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public Optional<Contrato> contratoVigente() {
		return this.contratos.stream()
				.max((Contrato c1, Contrato c2) -> c1.getFechaInicio().compareTo(c2.getFechaInicio()));
	}
	
	public boolean tieneContratoVencido() {
		return this.contratoVigente().map(c -> c.estaVencido()).orElse(true);
	}
	
	public void cargarContratoDePlanta(LocalDate fechaInicio, double sueldo, double montoConyuge, double montoHijos) {
		Contrato contrato = new DePlanta(this, fechaInicio, sueldo, montoConyuge, montoHijos);
		this.contratos.add(contrato);
	}
	
	public void cargarContratoPorHoras(LocalDate fechaInicio, double valor, int horas, LocalDate fechaFin) {
		Contrato contrato = new PorHoras(this, fechaInicio, valor, horas, fechaFin);
		this.contratos.add(contrato);
	}
	
	public int antiguedad() {
		return this.contratos.stream()
				.mapToInt(p -> p.calcularAnios())
				.sum();
	}
	
	public double calcularAumento() {
		if(this.antiguedad() < 5) {
			return 0d;
		}
		else if(this.antiguedad() < 10) {
			return 0.3d;
		}
		else if(this.antiguedad() < 15) {
			return 0.5d;
		}
		else if(this.antiguedad() < 20) {
			return 0.7d;
		}
		return 1d;
	}
	
	public double calcularMontoTotal() {
		if(!this.tieneContratoVencido()) {
			return this.contratoVigente().map(contrato -> contrato.calcularMonto() + contrato.calcularMonto() * this.calcularAumento()).orElse(0d);
		}
		return 0d;
	}
	
	public Recibo generarRecibo() {
		return new Recibo(this.antiguedad(), LocalDate.now(), this.calcularMontoTotal(), this);
	}
}