package semana4.dtos;

public enum TipoIVA {
	MAXIMO("Maximo",22),
	MINIMO("Minimo",10),
	EXENTO("Exento",0);
	
	private String nombre; 
	private int iva;
	
	private TipoIVA(String nombre, int iva) {
		this.nombre = nombre;
		this.iva = iva;
	}
	
	public String getNombre() {
		return nombre;
	}

	public int getIva() {
		return iva;
	}
}
