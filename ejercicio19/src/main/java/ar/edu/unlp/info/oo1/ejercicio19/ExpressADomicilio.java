package ar.edu.unlp.info.oo1.ejercicio19;

public class ExpressADomicilio implements Envio {
	
	public double calcularEnvio(String direccion1, String direccion2) {
		Mapa map = new Mapa();
		return 0.5 * map.distanciaEntre(direccion1, direccion2);
	}
}