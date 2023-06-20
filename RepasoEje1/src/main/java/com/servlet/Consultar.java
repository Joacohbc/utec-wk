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
@WebServlet("/consultar")
public class Consultar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Consultar() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s = request.getSession();
		if(s.getAttribute("incidentes") == null) {
			s.setAttribute("incidentes", new LinkedList<IncidenteDTO>());
		}
		request.getRequestDispatcher("consultar.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		doGet(request, response);
	}

}
