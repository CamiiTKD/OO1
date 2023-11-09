package ar.edu.unlp.info.oo1.ejercicio17;

import java.time.LocalDate;
import java.time.LocalTime;

public class Internacional extends Llamada{
	private String paisOrigen;
	private String paisDestino;
	
	public Internacional(LocalDate fecha, LocalTime hora, double duracion, String numeroLlama, String numeroRecibe, String paisOrigen, String paisDestino) {
		super(fecha, hora, duracion, numeroLlama, numeroRecibe);
		this.paisOrigen = paisOrigen;
		this.paisDestino = paisDestino;
	}
	
	public String getPaisOrigen() {
		return this.paisOrigen;
	}
	
	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}
	
	public String getPaisDestino() {
		return this.paisDestino;
	}
	
	public void setPaisDestino(String paisDestino) {
		this.paisDestino = paisDestino;
	}
	
	public double Costo() {
		double valor;
		if ((super.getHora().isAfter(LocalTime.of(8,0)))&&(super.getHora().isBefore(LocalTime.of(20,0)))){
			valor = 4.0;
		}
		else {
			valor = 3.0;
		}
		return (super.getDuracion() * valor);
	}
}