package ar.edu.unlp.info.oo1.ejercicio15;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OOBnB {
	private ArrayList<Usuario> usuarios;
	private ArrayList<Propiedad> propiedades;
	
	public OOBnB() {
		this.usuarios = new ArrayList<Usuario>();
		this.propiedades = new ArrayList<Propiedad>();
	}
	
	public List<Usuario> getUsuarios(){
		return this.usuarios;
	}
	
	public List<Propiedad> getPropiedades(){
		return this.propiedades;
	}
	
	public Usuario agregarUsuario(Usuario unUsuario) {
		this.usuarios.add(unUsuario);
		this.propiedades.addAll(unUsuario.getPropiedades());
		return this.usuarios.get(this.usuarios.size() - 1);
	}
	
	public Propiedad agregarPropiedad(Propiedad unaPropiedad) {
		unaPropiedad.getPropietario().agregarPropiedad(unaPropiedad);
		this.propiedades.add(unaPropiedad);
		return this.propiedades.get(this.propiedades.size() - 1);
	}
	
	public List<Propiedad> getPropiedadesDisponibles(LocalDate desde, LocalDate hasta){
		LapseDate fecha = new LapseDate(desde, hasta);
		return this.getPropiedades().stream()
				.filter(p -> p.estaLibre(fecha))
				.toList();
	}
	
	public Reserva agregarReserva(Propiedad unaPropiedad, LocalDate desde, LocalDate hasta, Usuario unInquilino) {
		LapseDate fecha = new LapseDate(desde, hasta);
		if(unaPropiedad.estaLibre(fecha)) {
			Reserva nuevaReserva = new Reserva(unInquilino, fecha, unaPropiedad);
			unaPropiedad.agregarReserva(nuevaReserva);
			return nuevaReserva;
		}
		else {
			return null;
		}
	}
	
	public double eliminarReserva(Reserva unaReserva) {
		if(unaReserva.fechaPosterior()) {
			return unaReserva.getPropiedad().cancelarReserva(LocalDate.now(), unaReserva);
		}
		else {
			return 0;
		}
	}
}