package ar.edu.unlp.info.oo1.ejercicio19;

public class Producto {
	private String nombre;
	private String descripcion;
	private int cantidadUnidades;
	private double precio;
	private Persona vendedor;
	
	
	public Producto(String nombre, String descripcion, int cantidadUnidades, double precio) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.cantidadUnidades = cantidadUnidades;
		this.precio = precio;
		this.vendedor = null;
	}
	
	public Producto(String nombre, String descripcion, int cantidadUnidades, double precio, Persona vendedor) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.cantidadUnidades = cantidadUnidades;
		this.precio = precio;
		this.vendedor = vendedor;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public int getCantidadUnidades() {
		return this.cantidadUnidades;
	}
	
	public double getPrecio() {
		return this.precio;
	}
	
	public Persona getVendedor() {
		return this.vendedor;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void setCantidadUnidades(int cantidadUnidades) {
		this.cantidadUnidades = cantidadUnidades;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public void setVendedor(Persona vendedor) {
		this.vendedor = vendedor;
	}
	
	public void decrementarStock(int cantidad) {
		if(cantidad < this.cantidadUnidades) {
			this.cantidadUnidades = this.cantidadUnidades - cantidad;
		}
	}
	
	public double precioPorCantidad(int cantidad) {
		return this.precio * cantidad;
	}
}