package tp04_ag.src.tp04.ejercicio1;
import tp04_ag.src.tp04.ejercicio1.*;
import tp04_ag.src.tp02.ejercicio2.*;
public class RecorridosAG {
	
	public ListaGenerica<Integer> numerosImparesMayoresQuePreOrden(ArbolGeneral<Integer> a, Integer n){
		ListaGenerica<Integer> lista = new ListaEnlazadaGenerica();
		numerosImparesMayoresQuePreOrden(a,n,lista);
		return lista;
	}
	
	private void numerosImparesMayoresQuePreOrden(ArbolGeneral<Integer> a, Integer n, ListaGenerica<Integer> l){
		if(!a.esVacio()) {
			if ((a.getDato()%2 != 0)&&(a.getDato() < n))
				l.agregarFinal(a.getDato());
			ListaGenerica<ArbolGeneral<Integer>> lHijos = a.getHijos();
			lHijos.comenzar();
			while(!lHijos.fin()) {
				numerosImparesMayoresQuePreOrden(lHijos.proximo(),n,l);
			}
		}	
	}
	
	public ListaGenerica<Integer> numerosImparesMayoresQueInOrden(ArbolGeneral<Integer> a, Integer n){
		ListaGenerica<Integer> lista = new ListaEnlazadaGenerica();
		numerosImparesMayoresQueInOrden(a,n,lista);
		return lista;
	}
	
	private void numerosImparesMayoresQueInOrden(ArbolGeneral<Integer> a, Integer n, ListaGenerica<Integer> l) {
		if(!a.esVacio()) {
			ListaGenerica<ArbolGeneral<Integer>> lHijos = a.getHijos();
			if(!lHijos.esVacia()) {
				lHijos.comenzar();
				numerosImparesMayoresQueInOrden(lHijos.proximo(),n,l);
			}
			if((a.getDato()%2 != 0)&&(a.getDato() < n)) {
				l.agregarFinal(a.getDato());
			}
			while(!lHijos.fin()) {
				numerosImparesMayoresQueInOrden(lHijos.proximo(),n,l);
			}
		}
	}
	
	public ListaGenerica<Integer> numerosImparesMayoresQuePostOrden(ArbolGeneral<Integer> a, Integer n){
		ListaGenerica<Integer> lista = new ListaEnlazadaGenerica();
		numerosImparesMayoresQuePostOrden(a,n,lista);
		return lista;
	}
	
	private void numerosImparesMayoresQuePostOrden(ArbolGeneral<Integer> a, Integer n, ListaGenerica<Integer> l) {
		if(!a.esVacio()) {
			ListaGenerica<ArbolGeneral<Integer>> lHijos = a.getHijos();
			lHijos.comenzar();
			while(!lHijos.fin()) {
				numerosImparesMayoresQuePostOrden(lHijos.proximo(), n, l);
			}
			if((a.getDato()%2 != 0)&&(a.getDato() < n)) {
				l.agregarFinal(a.getDato());
			}
		}
	}
	
	public ListaGenerica<Integer> numerosImparesMayoresQuePorNiveles(ArbolGeneral<Integer> a, Integer n){
		ListaGenerica<Integer> lista = new ListaEnlazadaGenerica();
		ArbolGeneral<Integer> arbol = null;
		if(!a.esVacio()) {
			ColaGenerica<ArbolGeneral<Integer>> cola = new ColaGenerica();
			cola.encolar(a);
			while(!cola.esVacia()) {
				arbol = cola.desencolar();
				if(!arbol.esVacio()) {
					if(arbol.tieneHijos()) {
						ListaGenerica<Integer> lHijos = arbol.getHijos();
						lHijos.comenzar();
						while(!lHijos.fin())
							cola.encolar(lHijos.proximo());
					}
					if((arbol.getDato()%2 != 0)&&(arbol.getDato() < n)) {
						lista.agregarFinal(arbol.getDato());
					}
				}
			}
		}
		return lista;
	}
}
