package tp03;
import tp03.ArbolBinario;
import tp02.ejercicio2.*;
public class ContadorArbol {
	private ArbolBinario<Integer> arbol;
	
	public ContadorArbol(ArbolBinario<Integer> a) {
		arbol= a;
	}
	
	public void setArbol(ArbolBinario<Integer> a) {
		arbol= a;
	}
	
	public ArbolBinario<Integer> getArbol(){
		return arbol;
	}
	
	public ListaEnlazadaGenerica<Integer> numerosParesInOrden(){
		ListaEnlazadaGenerica<Integer> InOrden = new ListaEnlazadaGenerica<>();
		numerosParesInOrden(InOrden, arbol);
		return InOrden;
	}
	
	private void numerosParesInOrden(ListaEnlazadaGenerica<Integer> lista, ArbolBinario<Integer> arbol) {
		if(!arbol.esVacio()) {
			numerosParesInOrden(lista, arbol.getHijoIzquierdo());
			if(arbol.getDato() % 2 == 0) {
				lista.agregarFinal(arbol.getDato());
			}
			numerosParesInOrden(lista, arbol.getHijoDerecho());
		}
	}
	
	public ListaEnlazadaGenerica<Integer> numerosParesPostOrden(){
		ListaEnlazadaGenerica<Integer> PostOrden = new ListaEnlazadaGenerica<>();
		numerosParesPostOrden(PostOrden, arbol);
		return PostOrden;
	}
	
	private void numerosParesPostOrden(ListaEnlazadaGenerica<Integer> lista, ArbolBinario<Integer> arbol) {
		if(!arbol.esVacio()) {
			numerosParesPostOrden(lista, arbol.getHijoIzquierdo());
			numerosParesPostOrden(lista, arbol.getHijoDerecho());
			if(arbol.getDato() % 2 == 0) {
				lista.agregarFinal(arbol.getDato());
			}
		}
	}

}