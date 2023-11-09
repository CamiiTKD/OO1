package ar.edu.unlp.info.oo1.ejercicio17;

import java.time.LocalDate;
import java.time.LocalTime;

public class Local extends Llamada {
	
	public Local(LocalDate fecha, LocalTime hora, double duracion, String numeroLlama, String numeroRecibe) {
		super(fecha, hora, duracion, numeroLlama, numeroRecibe);
	}
	
	public double Costo() {
		return (super.getDuracion() * 1.0);
	}
}