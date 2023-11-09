package ar.edu.unlp.info.oo1.ejercicio19;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class Sistema {
	public List<Producto> productos;
	public List<Persona> vendedores;
	public List<Cliente> clientes;
	
	public Sistema() {
		productos = new ArrayList<Producto>();
		vendedores = new ArrayList<Persona>();
		clientes = new ArrayList<Cliente>();
	}
	
	public Persona registrarVendedor(String nombre, String direccion) {
		Persona vendedor = new Persona(nombre, direccion);
		this.vendedores.add(vendedor);
		return vendedor;
	}
	
	public Optional<Persona> buscarVendedor(String nombre) {
		return this.vendedores.stream()
				.filter(p -> p.getNombre().equals(nombre))
				.findFirst();
	}
	
	public Cliente registrarCliente(String nombre, String direccion) {
		Cliente cliente = new Cliente(nombre, direccion);
		this.clientes.add(cliente);
		return cliente;
	}
	
	public Optional<Cliente> buscarCliente(String nombre) {
		return this.clientes.stream()
				.filter(p -> p.getNombre().equals(nombre))
				.findFirst();
	}
	
	public Producto ponerALaVenta(String nombre, String descripcion, int cantidadUnidades, double precio, Persona vendedor) {
		Producto producto = new Producto(nombre, descripcion, cantidadUnidades, precio, vendedor);
		this.productos.add(producto);
		return producto;
	}
	
	public List<Producto> buscarProducto(String nombre){
		return this.productos.stream()
				.filter(p -> p.getNombre().equals(nombre))
				.collect(Collectors.toList());
	}
	
	public Pedido crearPedido(Cliente cliente, Producto producto, int cantidad, Pago formaDePago, Envio mecanismoDeEnvio) {
		return cliente.crearPedido(producto, cantidad, formaDePago, mecanismoDeEnvio);
	}
	
	public double calcularCostoTotal(Pedido pedido) {
		return pedido.getCliente().calcularCostoTotal(pedido);
	}
}