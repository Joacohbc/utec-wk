package com.servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.IncidenteDTO;

/**
 * Servlet implementation class HolaMundoServlet
 */
@WebServlet("/registrar")
public class RegistroAtencion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegistroAtencion() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		IncidenteDTO i = new IncidenteDTO();
		i.setNombresYApellidos(request.getParameter("nombres"));
		i.setDescripcion(request.getParameter("descripcion"));
		i.setTipo(request.getParameter("tipo"));
		i.setDuracion(request.getParameter("duracion"));
		i.setEstado(request.getParameter("estado"));
		
		
		HttpSession s = request.getSession();
		if(s.getAttribute("incidentes") == null) {
			s.setAttribute("incidentes", new LinkedList<IncidenteDTO>());
		}
		
		((LinkedList<IncidenteDTO>) s.getAttribute("incidentes")).add(i);
		
		response.sendRedirect(request.getContextPath() + "/mostrar");
	}

}
