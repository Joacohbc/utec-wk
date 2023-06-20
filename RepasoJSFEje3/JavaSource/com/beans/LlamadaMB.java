package com.beans;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.dtos.IncidenteDTO;

@Named("llamadaMB")
@SessionScoped
public class LlamadaMB implements Serializable {

	private static final long serialVersionUID = 1L;

	public LlamadaMB() {
	}
	
	private List<IncidenteDTO> incidentes = new LinkedList<IncidenteDTO>(); 
	private IncidenteDTO incidente = new IncidenteDTO();
	
	public String crear() {
		incidentes.add(incidente);
		return "consulta";
	}
	
	public IncidenteDTO getIncidente() {
		return incidente;
	}

	public void setIncidentes(IncidenteDTO incidente) {
		this.incidente = incidente;
	}

	public List<IncidenteDTO> getIncidentes() {
		return incidentes;
	}

	public void setIncidentes(List<IncidenteDTO> incidentes) {
		this.incidentes = incidentes;
	}
}
