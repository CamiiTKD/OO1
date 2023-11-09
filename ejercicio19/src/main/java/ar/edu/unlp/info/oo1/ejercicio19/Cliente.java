package ar.edu.unlp.info.oo1.ejercicio19;

import java.util.List;
import java.util.ArrayList;

public class Cliente extends Persona {
	private List<Pedido> pedidos;
	
	public Cliente(String nombre, String direccion) {
		super(nombre, direccion);
		pedidos = new ArrayList<Pedido>();
	}
	
	public Pedido crearPedido(Producto producto, int cantidad, Pago formaDePago, Envio mecanismoDeEnvio) {
		if(producto.getCantidadUnidades() > cantidad) {
			Pedido pedido = new Pedido(this, producto, cantidad, formaDePago, mecanismoDeEnvio);
			producto.decrementarStock(cantidad);
			this.pedidos.add(pedido);
			return pedido;
		}
		return null;
	}
	
	public double calcularCostoTotal(Pedido pedido) {
		return pedido.calcularCostoTotal();
	}
}