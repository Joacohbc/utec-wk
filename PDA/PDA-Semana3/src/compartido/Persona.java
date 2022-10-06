package compartido;

public class Persona {
	private Long id;
	private Long documento;
	private String nombre;
	private String segNombre;
	private String apellido;
	private String segApellido;

	public Persona() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDocumento() {
		return documento;
	}

	public void setDocumento(Long documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSegNombre() {
		return segNombre;
	}

	public void setSegNombre(String segNombre) {
		this.segNombre = segNombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getSegApellido() {
		return segApellido;
	}

	public void setSegApellido(String segApellido) {
		this.segApellido = segApellido;
	}

	@Override
	public String toString() {
		return "Persona [documento=" + documento + ", nombre=" + nombre + ", segNombre=" + segNombre + ", apellido="
				+ apellido + ", segApellido=" + segApellido + "]";
	}

}
