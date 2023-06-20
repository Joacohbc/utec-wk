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
@WebServlet("/mostrar")
public class MostrarLlamada extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MostrarLlamada() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IncidenteDTO i = ((LinkedList<IncidenteDTO>) request.getSession().getAttribute("incidentes")).getLast();
		request.setAttribute("nombres", i.getNombresYApellidos());
		request.setAttribute("descripcion", i.getDescripcion());
		request.setAttribute("estado", i.getEstado());
		request.setAttribute("tipo", i.getTipo());
		request.setAttribute("duracion", i.getDuracion());
		request.getRequestDispatcher("mostrar.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		doGet(request, response);
	}

}
