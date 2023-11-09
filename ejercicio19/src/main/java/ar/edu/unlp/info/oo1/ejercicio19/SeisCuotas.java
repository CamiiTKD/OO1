package ar.edu.unlp.info.oo1.ejercicio19;

public class SeisCuotas implements Pago {
	
	public double calcularPago(double monto) {
		return (monto + monto * 0.2);
	}
}