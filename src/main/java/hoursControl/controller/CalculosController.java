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
		
		var horarioEntrada = request.getParameter("horarioEntrada");
		var horarioSaida = request.getParameter("horarioSaida");
		var marcacaoEntrada = request.getParameter("marcacaoEntrada");
		var marcacaoSaida = request.getParameter("marcacaoSaida");
		
		var horario = service.calcular(horarioEntrada, horarioSaida,marcacaoEntrada,marcacaoSaida);
		
		
		request.setAttribute("atraso", horario.atraso());
		request.setAttribute("extra", horario.extra());
		request.setAttribute("horarioPadraoEntrada", horarioEntrada);
		request.setAttribute("horarioPadraoSaida", horarioSaida);
		request.setAttribute("horarioMarcacaoEntrada", marcacaoEntrada);
		request.setAttribute("horarioMarcacaoSaida", marcacaoSaida);
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	

}
