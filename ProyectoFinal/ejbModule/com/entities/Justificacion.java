package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the JUSTIFICACIONES database table.
 * 
 */
@Entity
@Table(name="JUSTIFICACIONES")
@NamedQuery(name="Justificacion.findAll", query="SELECT j FROM Justificacion j")
public class Justificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_JUSTIFICACION")
	private Long idJustificacion;

	private String detalle;

	private String estado;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHA_HORA")
	private Date fechaHora;

	//bi-directional many-to-one association to AccionJustificacione
	@OneToMany(mappedBy="justificacione")
	private List<AccionJustificacion> accionJustificaciones;

	//bi-directional many-to-one association to Estudiante
	@ManyToOne
	@JoinColumn(name="ID_ESTUDIANTE")
	private Estudiante estudiante;

	//bi-directional many-to-one association to Evento
	@ManyToOne
	@JoinColumn(name="ID_EVENTO")
	private Evento evento;

	public Justificacion() {
	}

	public Long getIdJustificacion() {
		return this.idJustificacion;
	}

	public void setIdJustificacion(Long idJustificacion) {
		this.idJustificacion = idJustificacion;
	}

	public String getDetalle() {
		return this.detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaHora() {
		return this.fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public List<AccionJustificacion> getAccionJustificaciones() {
		return this.accionJustificaciones;
	}

	public void setAccionJustificaciones(List<AccionJustificacion> accionJustificaciones) {
		this.accionJustificaciones = accionJustificaciones;
	}

	public AccionJustificacion addAccionJustificacione(AccionJustificacion accionJustificacione) {
		getAccionJustificaciones().add(accionJustificacione);
		accionJustificacione.setJustificacione(this);

		return accionJustificacione;
	}

	public AccionJustificacion removeAccionJustificacione(AccionJustificacion accionJustificacione) {
		getAccionJustificaciones().remove(accionJustificacione);
		accionJustificacione.setJustificacione(null);

		return accionJustificacione;
	}

	public Estudiante getEstudiante() {
		return this.estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Evento getEvento() {
		return this.evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

}