package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ANALISTAS database table.
 * 
 */
@Entity
@Table(name="ANALISTAS")
@NamedQuery(name="Analista.findAll", query="SELECT a FROM Analista a")
public class Analista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_ANALISTA")
	private Long idAnalista;

	private byte estado;

	//bi-directional many-to-one association to AccionConstancia
	@OneToMany(mappedBy="analista")
	private List<AccionConstancia> accionConstancias;

	//bi-directional many-to-one association to AccionJustificacione
	@OneToMany(mappedBy="analista")
	private List<AccionJustificacion> accionJustificaciones;

	//bi-directional many-to-one association to AccionReclamo
	@OneToMany(mappedBy="analista")
	private List<AccionReclamo> accionReclamos;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	//bi-directional many-to-one association to Gestore
	@OneToMany(mappedBy="analista")
	private List<Gestor> gestores;

	public Analista() {
	}

	public Long getIdAnalista() {
		return this.idAnalista;
	}

	public void setIdAnalista(Long idAnalista) {
		this.idAnalista = idAnalista;
	}

	public byte getEstado() {
		return this.estado;
	}

	public void setEstado(byte estado) {
		this.estado = estado;
	}

	public List<AccionConstancia> getAccionConstancias() {
		return this.accionConstancias;
	}

	public void setAccionConstancias(List<AccionConstancia> accionConstancias) {
		this.accionConstancias = accionConstancias;
	}

	public AccionConstancia addAccionConstancia(AccionConstancia accionConstancia) {
		getAccionConstancias().add(accionConstancia);
		accionConstancia.setAnalista(this);

		return accionConstancia;
	}

	public AccionConstancia removeAccionConstancia(AccionConstancia accionConstancia) {
		getAccionConstancias().remove(accionConstancia);
		accionConstancia.setAnalista(null);

		return accionConstancia;
	}

	public List<AccionJustificacion> getAccionJustificaciones() {
		return this.accionJustificaciones;
	}

	public void setAccionJustificaciones(List<AccionJustificacion> accionJustificaciones) {
		this.accionJustificaciones = accionJustificaciones;
	}

	public AccionJustificacion addAccionJustificacione(AccionJustificacion accionJustificacione) {
		getAccionJustificaciones().add(accionJustificacione);
		accionJustificacione.setAnalista(this);

		return accionJustificacione;
	}

	public AccionJustificacion removeAccionJustificacione(AccionJustificacion accionJustificacione) {
		getAccionJustificaciones().remove(accionJustificacione);
		accionJustificacione.setAnalista(null);

		return accionJustificacione;
	}

	public List<AccionReclamo> getAccionReclamos() {
		return this.accionReclamos;
	}

	public void setAccionReclamos(List<AccionReclamo> accionReclamos) {
		this.accionReclamos = accionReclamos;
	}

	public AccionReclamo addAccionReclamo(AccionReclamo accionReclamo) {
		getAccionReclamos().add(accionReclamo);
		accionReclamo.setAnalista(this);

		return accionReclamo;
	}

	public AccionReclamo removeAccionReclamo(AccionReclamo accionReclamo) {
		getAccionReclamos().remove(accionReclamo);
		accionReclamo.setAnalista(null);

		return accionReclamo;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Gestor> getGestores() {
		return this.gestores;
	}

	public void setGestores(List<Gestor> gestores) {
		this.gestores = gestores;
	}

	public Gestor addGestore(Gestor gestore) {
		getGestores().add(gestore);
		gestore.setAnalista(this);

		return gestore;
	}

	public Gestor removeGestore(Gestor gestore) {
		getGestores().remove(gestore);
		gestore.setAnalista(null);

		return gestore;
	}

}