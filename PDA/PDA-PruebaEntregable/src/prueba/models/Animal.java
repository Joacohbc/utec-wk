package prueba.models;

public class Animal {

	private int id;
	private String descripcion;
	private Categoria categoria;
	private Productor productor;

	public Animal() {
		super();
	}

	public Animal(int id, String descripcion, Categoria categoria) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.categoria = categoria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Productor getProductor() {
		return productor;
	}

	public void setProductor(Productor productor) {
		this.productor = productor;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", descripcion=" + descripcion + ", categoria=" + categoria + ", productor="
				+ productor + "]";
	}
}
