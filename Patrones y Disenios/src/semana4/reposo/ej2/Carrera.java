package semana4.reposo.ej2;

public class Carrera {
	private Long id;
	private String nombre;
	private Universidad universidad;

	public Carrera() {
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

	public Universidad getUniversidad() {
		return universidad;
	}

	public void setUniversidad(Universidad universidad) {
		this.universidad = universidad;
	}
	
	@Override
	public String toString() {
		return nombre;
	}

}
