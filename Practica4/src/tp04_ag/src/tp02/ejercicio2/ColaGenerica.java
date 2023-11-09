package tp04_ag.src.tp02.ejercicio2;
import tp02.ejercicio2.ListaEnlazadaGenerica;
public class ColaGenerica<T> {
		private ListaEnlazadaGenerica<T> datos;
		
		public ColaGenerica() {
			datos = new ListaEnlazadaGenerica<>(); 
		}
		
		public void encolar(T elem) {
			datos.agregarEn(T, 1);
		}
		public T desencolar() {
			if(datos.esVacia()) {
				return null;
			}
			T elem = datos.elemento(1);
			datos.eliminarEn(1);
			return elem;
		}
		public T tope() {
			if(datos.esVacia()) {
				return null;
			}
			return datos.elemento(datos.tamanio());
		}
		public boolean esVacia() {
			return datos.esVacia();
		}
	}

}
