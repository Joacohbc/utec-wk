package semana4.reposo.ej2;

public class Universidad {
	private Long id;
	private String nombre;
	private String ubicacion;

	public Universidad() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	@Override
	public String toString() {
		return nombre;
	}
}
