package dtos;

public class Articulo {
	private String nombre;
	private float precio;
	private TipoIVA iva;

	public Articulo() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public TipoIVA getIva() {
		return iva;
	}

	public void setIva(TipoIVA iva) {
		this.iva = iva;
	}
}
