package tp04_ag.src.tp04.ejercicio1;
import tp04_ag.src.tp02.ejercicio2.*;
public class RedDeAguaPotable {
	private ArbolGeneral<Casa> casas;
	
	public RedDeAguaPotable(ArbolGeneral<Casa> c) {
		this.casas = c;
	}
	
	public double minimoCaudal(double caudal) {
		if(casas != null) {
			Casa casa = casas.getDato();
			casa.setCaudal(caudal);
			casas.setDato(casa);
			return buscarMinimo(casas, caudal);
		}
		else {
			return -1;
		}
		
	}
	
	private double buscarMinimo(ArbolGeneral<Casa> c, double caudal) {
		if(c.esHoja()) {
			return c.getDato().getCaudal();
		}
		else {
			double min = Double.MAX_VALUE;
			ListaGenerica<ArbolGeneral<Casa>> hijos = c.getHijos();
			while(!hijos.fin()) {
				ArbolGeneral<Casa> aux = hijos.proximo();
				Casa dato = aux.getDato();
				dato.setCaudal(caudal/hijos.tamanio());
				aux.setDato(dato);
				min = Math.min(min, buscarMinimo(aux, (caudal/hijos.tamanio())));
			}
			return min;
		}
	}
}
