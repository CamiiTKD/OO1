package tp03;
import tp03.ArbolBinario;
public class ProfundidadDeArbolBinario {
	private ArbolBinario<Integer> arbol;
	
	public Integer sumaElementosProfundidad(int profundidad) {
		int nivel=0;
		int suma=0;
		ArbolBinario<Integer> arbol = null;
		ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<ArbolBinario<Integer>>();
		cola.encolar(arbol);;
		cola.encolar(null);
		while(!cola.esVacia()) {
			arbol = cola.desencolar();
			if((arbol != null)&&(nivel <= profundidad)) {
				if(nivel == profundidad) {
					suma = suma + arbol.getDato();
				}
				if(arbol.tieneHijoIzquierdo()) {
					cola.encolar(arbol.getHijoIzquierdo());
				}
				if(arbol.tieneHijoDerecho()) {
					cola.encolar(arbol.getHijoDerecho());
				}
			}
			else if(!cola.esVacia()) {
				System.out.println("Nivel: " + ++nivel);
				cola.encolar(null);
			}
		}
		return suma;
	}
}
