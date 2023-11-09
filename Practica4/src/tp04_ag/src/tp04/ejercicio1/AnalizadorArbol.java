package tp04_ag.src.tp04.ejercicio1;
import tp04_ag.src.tp04.ejercicio1.*;
import tp04_ag.src.tp02.ejercicio2.*;
public class AnalizadorArbol {

	public int devolverMaximoPromedio (ArbolGeneral<AreaEmpresa> arbol) {
		int nodos = 0;
		int maxTotal = -1;
		int contador = 0;
		ColaGenerica<ArbolGeneral<AreaEmpresa>> cola = new ColaGenerica();
		ArbolGeneral<AreaEmpresa> a = null;
		cola.encolar(arbol);
		cola.encolar(null);
		while(!cola.esVacia()) {
			arbol = cola.desencolar();
			if(arbol != null) {
				nodos++;
				contador = contador + arbol.getDato().getTardanza();
				ListaGenerica<ArbolGeneral<AreaEmpresa>> hijos = arbol.getHijos();
				while(!hijos.fin()) {
					cola.encolar(hijos.proximo());
				}
			}
			else {
				if(!cola.esVacia()) {
					cola.encolar(null);
				}
				maxTotal = Math.max(maxTotal, contador/nodos);
				nodos = 0;
				contador = 0;
			}
		}
		return maxTotal;
	}
}
