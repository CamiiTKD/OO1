package tp04.ejercicio1;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04_ag.src.tp02.ejercicio2.ColaGenerica;

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return !this.hijos.esVacia();
	}
	
	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}
	
	public ListaEnlazadaGenerica<T> preOrden() {
		return null;
	}
	
	public Integer altura() {
		if(this.esHoja()) {
			return 0;
		}
		else {
			ListaGenerica<ArbolGeneral<T>> lHijos = this.getHijos();
			lHijos.comenzar();
			int max = 0;
			while(!lHijos.fin()) {
				ArbolGeneral<T> hijo = lHijos.proximo;
				if(hijo.altura() > max) {
					max = hijo.altura();
				}
			}
			return max + 1;
		}
	}

	public Integer nivel(T dato) {
		int nivel = 0;
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica();
		ArbolGeneral<T> arbol = null;
		cola.encolar(this);
		cola.encolar(null);
		boolean encontre = false;
		while ((!cola.esVacia())&&(!encontre)) {
			arbol= cola.desencolar();
			if(arbol != null) {
				if(arbol.getDato().equals(dato)) {
					encontre = true;
				}
				else {
					ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
					hijos.comenzar;
					while(!hijos.fin()) {
						cola.encolar(hijos.proximo);
					}
				}
			}
			else if(!cola.esVacia()){
				nivel++;
				cola.encolar(null);
			}
		}
		if(encontre)
			return nivel;
		else
			return -1;
	}

	public Integer ancho() {
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica();
		ArbolGeneral<T> arbol = null;
		cola.encolar(this);
		cola.encolar(null);
		int max = -1;
		int anchoNivel = 0;
		while(!cola.esVacia()) {
			arbol = cola.desencolar();
			if(arbol != null) {
				ListaGenerica<ArbolGeneral<T>> hijos  = arbol.getHijos();
				hijos.comenzar();
				while(!hijos.fin) {
					cola.encolar(hijos.proximo);
				}
				anchoNivel++;
			}
			else {
				if(!cola.esVacia()) {
					cola.encolar(null);
				}
				max = Math.max(max, anchoNivel);
				anchoNivel = 0;
			}
		}
		return max;
	}
	
	public Boolean esAncestro(T a, T b) {
		if(a.equals(b)) {
			return false;
		}
		ArbolGeneral<T> subArbolA = encontrarArbol(this, a);
		if(subArbolA == null) {
			return false;
		}
		else {
			return (encontrarArbol(subArbolA, b) != null);
		}
	}
	
	private ArbolGeneral<T> encontrarArbol(ArbolGeneral<T> arbol, T dato){
		if(arbol.getDato().equals(dato)) {
			return arbol;
		}
		else {
			if(arbol.tieneHijos()) {
				ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
				ArbolGeneral<T> aux = null;
				while((aux == null)&&(!hijos.fin)) {
					aux = encontrarArbol(hijos.proximo, dato);
				}
				return aux;
			}
		}
		return null;
	}
}