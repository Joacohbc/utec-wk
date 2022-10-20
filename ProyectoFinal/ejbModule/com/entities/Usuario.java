package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.entities.enums.Departamento;
import com.entities.enums.EstadoUsuario;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the USUARIOS database table.
 * 
 */
@Entity
@Table(name="USUARIOS")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_USUARIO")
	private Long idUsuario;

	private String apellidos;

	private String contrasena;

	@Enumerated
	private Departamento departamento;

	private String documento;

	private String email;
	
	@Enumerated
	private EstadoUsuario estado;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FEC_NACIMIENTO")
	private Date fecNacimiento;

	private String genero;

	private String localidad;

	@Column(name="NOMBRE_USUARIO", unique = true)
	private String nombreUsuario;

	private String nombres;

	private String telefono;

//	//bi-directional many-to-one association to Analista
//	@OneToMany(mappedBy="usuario")
//	private List<Analista> analistas;
//
//	//bi-directional many-to-one association to Estudiante
//	@OneToMany(mappedBy="usuario")
//	private List<Estudiante> estudiantes;
//
//	//bi-directional many-to-one association to Tutore
//	@OneToMany(mappedBy="usuario")
//	private List<Tutor> tutores;

	//bi-directional many-to-one association to Itr
	@ManyToOne
	@JoinColumn(name="ID_ITR")
	private Itr itr;

	public Usuario() {
	}

	public Long getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public EstadoUsuario getEstadoUsuario() {
		return this.estado;
	}

	public void setEstadoUsuario(EstadoUsuario estado) {
		this.estado = estado;
	}

	public Date getFecNacimiento() {
		return this.fecNacimiento;
	}

	public void setFecNacimiento(Date fecNacimiento) {
		this.fecNacimiento = fecNacimiento;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Analista> getAnalistas() {
		return this.analistas;
	}

	public void setAnalistas(List<Analista> analistas) {
		this.analistas = analistas;
	}

	public Analista addAnalista(Analista analista) {
		getAnalistas().add(analista);
		analista.setUsuario(this);

		return analista;
	}

	public Analista removeAnalista(Analista analista) {
		getAnalistas().remove(analista);
		analista.setUsuario(null);

		return analista;
	}

	public List<Estudiante> getEstudiantes() {
		return this.estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public Estudiante addEstudiante(Estudiante estudiante) {
		getEstudiantes().add(estudiante);
		estudiante.setUsuario(this);

		return estudiante;
	}

	public Estudiante removeEstudiante(Estudiante estudiante) {
		getEstudiantes().remove(estudiante);
		estudiante.setUsuario(null);

		return estudiante;
	}

	public List<Tutor> getTutores() {
		return this.tutores;
	}

	public void setTutores(List<Tutor> tutores) {
		this.tutores = tutores;
	}

	public Tutor addTutore(Tutor tutore) {
		getTutores().add(tutore);
		tutore.setUsuario(this);

		return tutore;
	}

	public Tutor removeTutore(Tutor tutore) {
		getTutores().remove(tutore);
		tutore.setUsuario(null);

		return tutore;
	}

	public Itr getItr() {
		return this.itr;
	}

	public void setItr(Itr itr) {
		this.itr = itr;
	}

}