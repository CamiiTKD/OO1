package tp04_ag.src.tp04.ejercicio1;

public class AreaEmpresa {
	private String nombre;
	private int tardanza;
	
	public AreaEmpresa() {
		
	}
	
	public AreaEmpresa(String n, int t) {
		this.nombre = n;
		this.tardanza =  t;
	}
	
	public void setNombre(String n) {
		this.nombre = n;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setTardanza(int t) {
		this.tardanza = t;
	}
	
	public int getTardanza() {
		return tardanza;
	}
}
