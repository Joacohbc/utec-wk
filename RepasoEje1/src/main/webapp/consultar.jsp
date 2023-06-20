<%@page import="com.dto.IncidenteDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.LinkedList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todos los Incidentes</title>
</head>
<body>
	<table style="border-collapse: collapse; width: 100%;">
		<tr>
			<th style="border: 1px solid black; padding: 8px;">
				Nombre y apellido
			</th>
			<th style="border: 1px solid black; padding: 8px;">
				Descripcion de la Solicitud
			</th>
			<th style="border: 1px solid black; padding: 8px;">
				Tipo de Solicitud
			</th>
			<th style="border: 1px solid black; padding: 8px;">
				Estado del Llamado
			</th>
			<th style="border: 1px solid black; padding: 8px;">
				Duracion
			</th>
		</tr>
		
		<% 
			List<IncidenteDTO> incidentes = ((LinkedList<IncidenteDTO>) session.getAttribute("incidentes"));
			for(IncidenteDTO i : incidentes) {
		%>
		<tr>
			<td style="border: 1px solid black; padding: 8px;"><%= i.getNombresYApellidos() %></td>
			<td style="border: 1px solid black; padding: 8px;"><%= i.getDescripcion()%></td>
			<td style="border: 1px solid black; padding: 8px;"><%= i.getTipo() %></td>
			<td style="border: 1px solid black; padding: 8px;"><%= i.getEstado() %></td>
			<td style="border: 1px solid black; padding: 8px;"><%= i.getDuracion() %></td>
		</tr>
		<% } %>
		
		<%= incidentes.isEmpty() ? "<tr>No hay Incididentes registrados</tr>" : ""  %>
	</table>
	<a href="registroAtencion.html">Ingresar otro incidente</a>
</body>
</html>