package ar.edu.unlp.info.oo1.ejercicio17;

import java.time.LocalDate;
import java.time.LocalTime;

public class Interurbana extends Llamada {
	private int distancia;
	
	public Interurbana(LocalDate fecha, LocalTime hora, double duracion, String numeroLlama, String numeroRecibe, int distancia) {
		super(fecha, hora, duracion, numeroLlama, numeroRecibe);
		this.distancia = distancia;
	}
	
	public int getDistancia() {
		return this.distancia;
	}
	
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
	
	public double Costo() {
		double valor;
		if(this.getDistancia() < 100) {
			valor = 2.0;
		}
		else if(this.getDistancia() < 500){
			valor = 2.5;
		}
		else {
			valor = 3.0;
		}
		return (super.getDuracion() * valor + 5.0);
	}
}