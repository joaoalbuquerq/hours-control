package hoursControl.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import hoursControl.model.Horario;
import hoursControl.service.CalculosService;

@WebServlet("/calcular")
public class CalculosController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private CalculosService service;
	
	@Override
    public void init() throws ServletException {
		service = new CalculosService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var horario = service.calcular(request.getParameter("marcacaoEntrada"),request.getParameter("marcacaoSaida"));
		request.setAttribute("atraso", horario.atraso());
		request.setAttribute("extra", horario.extra());
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	

}
