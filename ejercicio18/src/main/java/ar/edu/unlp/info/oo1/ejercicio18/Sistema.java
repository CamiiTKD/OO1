package ar.edu.unlp.info.oo1.ejercicio18;

import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.util.ArrayList;

public class Sistema {
	private List<Empleado> empleados;
	
	public Sistema() {
		empleados = new ArrayList<Empleado>();
	}
	
	public Empleado agregarEmpleado(String nombre, String apellido, String cuil, LocalDate fechaNacimiento, boolean conyuge, boolean hijos) {
		Empleado emp = new Empleado(nombre, apellido, cuil, fechaNacimiento, conyuge, hijos, LocalDate.now());
		this.empleados.add(emp);
		return emp;
	}
	
	public Empleado buscarEmpleado(String cuil) {
		return this.empleados.stream()
				.filter(p -> p.getCuil().equals(cuil))
				.findFirst().orElse(null);
	}
	
	public void eliminarEmpleado(Empleado emp) {
		this.empleados.remove(emp);
	}
	
	public Empleado getEmpleado(int pos) {
		return this.empleados.get(pos);
	}
	
	public void cargarContratoPorHoras(Empleado emp, LocalDate fechaInicio, double valor, int horas, LocalDate fechaFin) {
		emp.cargarContratoPorHoras(fechaInicio, valor, horas, fechaFin);
	}
	
	public void cargarContratoDePlanta(Empleado emp, LocalDate fechaInicio, double sueldo, double montoPorConyuge, double montoPorHijos) {
		emp.cargarContratoDePlanta(fechaInicio, sueldo, montoPorConyuge, montoPorHijos);
	}
	
	public List<Recibo> generarRecibos(){
		return this.empleados.stream()
				.map(p -> p.generarRecibo())
				.collect(Collectors.toList());
	}
	
	public List<Empleado> obtenerEmpleadosConContratoVencido(){
		return this.empleados.stream()
				.filter(p -> p.tieneContratoVencido())
				.collect(Collectors.toList());
	}
}