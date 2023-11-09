package tp03;
import tp03.ArbolBinario;
public class RedBinariaLlena {
	private ArbolBinario<Integer> arbol;
	
	public RedBinariaLlena(ArbolBinario<Integer> a) {
		arbol= a;
	}
	
	public int retardoReenvio() {
		return retardoReenvio(arbol);
	}
	
	
	//Proceso que se queda con el valor maximo de sus hijos y lo retorna junto con el valor del padre (busca el camino con el mayor retardo) 
	private int retardoReenvio(ArbolBinario<Integer> arbol) {
		if(arbol.esVacio()) {
			return 0;
		}
		if(arbol.esHoja()) {
			return arbol.getDato();
		}
		else {
			return arbol.getDato()+ Math.max(retardoReenvio(arbol.getHijoIzquierdo()), retardoReenvio(arbol.getHijoDerecho()));
		} 
	}
}
