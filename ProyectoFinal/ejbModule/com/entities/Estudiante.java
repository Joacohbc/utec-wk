package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ESTUDIANTES database table.
 * 
 */
@Entity
@Table(name="ESTUDIANTES")
@PrimaryKeyJoinColumn(referencedColumnName = "idUsuario")
public class Estudiante extends Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_ESTUDIANTE")
	private Long idEstudiante;

	private Boolean estado;

	private Integer generacion;

	//bi-directional many-to-one association to Asistencia
	@OneToMany(mappedBy="estudiante")
	private List<Asistencia> asistencias;

	//bi-directional many-to-one association to Constancia
	@OneToMany(mappedBy="estudiante")
	private List<Constancia> constancias;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	//bi-directional many-to-one association to Justificacione
	@OneToMany(mappedBy="estudiante")
	private List<Justificacion> justificaciones;

	//bi-directional many-to-one association to Reclamo
	@OneToMany(mappedBy="estudiante")
	private List<Reclamo> reclamos;

	public Estudiante() {
	}

	public Long getIdEstudiante() {
		return this.idEstudiante;
	}

	public void setIdEstudiante(Long idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public Boolean getEstado() {
		return this.estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Integer getGeneracion() {
		return this.generacion;
	}

	public void setGeneracion(Integer generacion) {
		this.generacion = generacion;
	}

	public List<Asistencia> getAsistencias() {
		return this.asistencias;
	}

	public void setAsistencias(List<Asistencia> asistencias) {
		this.asistencias = asistencias;
	}

	public Asistencia addAsistencia(Asistencia asistencia) {
		getAsistencias().add(asistencia);
		asistencia.setEstudiante(this);

		return asistencia;
	}

	public Asistencia removeAsistencia(Asistencia asistencia) {
		getAsistencias().remove(asistencia);
		asistencia.setEstudiante(null);

		return asistencia;
	}

	public List<Constancia> getConstancias() {
		return this.constancias;
	}

	public void setConstancias(List<Constancia> constancias) {
		this.constancias = constancias;
	}

	public Constancia addConstancia(Constancia constancia) {
		getConstancias().add(constancia);
		constancia.setEstudiante(this);

		return constancia;
	}

	public Constancia removeConstancia(Constancia constancia) {
		getConstancias().remove(constancia);
		constancia.setEstudiante(null);

		return constancia;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Justificacion> getJustificaciones() {
		return this.justificaciones;
	}

	public void setJustificaciones(List<Justificacion> justificaciones) {
		this.justificaciones = justificaciones;
	}

	public Justificacion addJustificacione(Justificacion justificacione) {
		getJustificaciones().add(justificacione);
		justificacione.setEstudiante(this);

		return justificacione;
	}

	public Justificacion removeJustificacione(Justificacion justificacione) {
		getJustificaciones().remove(justificacione);
		justificacione.setEstudiante(null);

		return justificacione;
	}

	public List<Reclamo> getReclamos() {
		return this.reclamos;
	}

	public void setReclamos(List<Reclamo> reclamos) {
		this.reclamos = reclamos;
	}

	public Reclamo addReclamo(Reclamo reclamo) {
		getReclamos().add(reclamo);
		reclamo.setEstudiante(this);

		return reclamo;
	}

	public Reclamo removeReclamo(Reclamo reclamo) {
		getReclamos().remove(reclamo);
		reclamo.setEstudiante(null);

		return reclamo;
	}

}