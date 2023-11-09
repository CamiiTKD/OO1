package ar.edu.unlp.info.oo1.ejercicio19;

public class Pedido {
	private Cliente cliente;
	private Producto producto;
	private int cantidadSolicitada;
	private Pago formaDePago;
	private Envio mecanismoDeEnvio;
	
	public Pedido(Cliente cliente, Producto producto, int cantidadSolicitada, Pago formaDePago, Envio mecanismoDeEnvio) {
		this.cliente = cliente;
		this.producto = producto;
		this.cantidadSolicitada = cantidadSolicitada;
		this.formaDePago = formaDePago;
		this.mecanismoDeEnvio = mecanismoDeEnvio;
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}
	
	public Producto getProducto() {
		return this.producto;
	}
	
	public int getCantidadSolicitada() {
		return this.cantidadSolicitada;
	}
	
	public Pago getFormaDePago() {
		return this.formaDePago;
	}
	
	public Envio getMecanismoDeEnvio() {
		return this.mecanismoDeEnvio;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void setProducto() {
		this.producto = producto;
	}
	
	public void setCantidadSolicitada(int cantidadSolicitada) {
		this.cantidadSolicitada = cantidadSolicitada;
	}
	
	public void setFormaDePago(Pago formaDePago) {
		this.formaDePago = formaDePago;
	}
	
	public void setMecanismoDeEnvio(Envio mecanismoDeEnvio) {
		this.mecanismoDeEnvio = mecanismoDeEnvio;
	}
	
	public double calcularCostoTotal() {
		return (this.getFormaDePago().calcularPago(this.producto.precioPorCantidad(this.getCantidadSolicitada())) + this.getMecanismoDeEnvio().calcularEnvio("desde", "hasta"));
	}
}