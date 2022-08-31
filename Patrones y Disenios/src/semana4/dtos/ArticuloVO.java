package semana4.dtos;

public class ArticuloVO {
	private int id;
	private String nombre;
	private float precio;
	private TipoIVA iva;

	public ArticuloVO(int id, String nombre, float precio, TipoIVA iva) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.iva = iva;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "ArticuloVO [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", iva=" + iva + "]";
	}
}
