package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TIPO_CONSTANCIAS database table.
 * 
 */
@Entity
@Table(name="TIPO_CONSTANCIAS")
@NamedQuery(name="TipoConstancia.findAll", query="SELECT t FROM TipoConstancia t")
public class TipoConstancia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_TIPO_CONSTANCIA")
	private Long idTipoConstancia;

	private Boolean estado;

	@Lob
	private byte[] plantilla;

	private String tipo;

	//bi-directional many-to-one association to Constancia
	@OneToMany(mappedBy="tipoConstancia")
	private List<Constancia> constancias;

	public TipoConstancia() {
	}

	public Long getIdTipoConstancia() {
		return this.idTipoConstancia;
	}

	public void setIdTipoConstancia(Long idTipoConstancia) {
		this.idTipoConstancia = idTipoConstancia;
	}

	public Boolean getEstado() {
		return this.estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public byte[] getPlantilla() {
		return this.plantilla;
	}

	public void setPlantilla(byte[] plantilla) {
		this.plantilla = plantilla;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Constancia> getConstancias() {
		return this.constancias;
	}

	public void setConstancias(List<Constancia> constancias) {
		this.constancias = constancias;
	}

	public Constancia addConstancia(Constancia constancia) {
		getConstancias().add(constancia);
		constancia.setTipoConstancia(this);

		return constancia;
	}

	public Constancia removeConstancia(Constancia constancia) {
		getConstancias().remove(constancia);
		constancia.setTipoConstancia(null);

		return constancia;
	}

}