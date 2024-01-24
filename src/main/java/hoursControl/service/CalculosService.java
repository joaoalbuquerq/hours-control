package hoursControl.service;

import hoursControl.model.Horario;

public class CalculosService {

	public Horario calcular(String entrada, String saida) {
		
		String atraso = calcularAtraso();
		String extra = calcularExtra();
		return new Horario(atraso,extra);
	}
	
	public String calcularAtraso() {
		return "1";
	}
	
	public String calcularExtra() {
		return "1";
	}

}
