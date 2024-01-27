package hoursControl.service;

import java.time.Duration;
import java.time.LocalTime;

import hoursControl.model.Horario;

public class CalculosService {

	public Horario calcular(String padraoEntrada, String padraoSaida, String marcacaoEntrada, String marcacaoSaida) {
		return verificarHorarios(padraoEntrada,padraoSaida,marcacaoEntrada,marcacaoSaida);
	}
	
	public Horario verificarHorarios(String padraoEntrada, String padraoSaida, String marcacaoEntrada, String marcacaoSaida) {
		
		LocalTime horarioPadraoEntrada = converterHorario(padraoEntrada);
		LocalTime horarioPadraoSaida = converterHorario(padraoSaida);
		LocalTime entrada = converterHorario(marcacaoEntrada);
		LocalTime saida = converterHorario(marcacaoSaida);
		
		long cargaHoraria = Duration.between(horarioPadraoEntrada, horarioPadraoSaida).toHours();
		long horasTrabalhadas = Duration.between(entrada, saida).toHours();
		
		String atraso = "";
		String extra = "";
		
		if((horasTrabalhadas - cargaHoraria) <= 0)
			atraso = String.valueOf(Math.abs(horasTrabalhadas - cargaHoraria));
		
		if((horasTrabalhadas - cargaHoraria) > 0)
			extra = String.valueOf(horasTrabalhadas - cargaHoraria);
		
		
		return new Horario(extra,atraso);
	}
	
	public LocalTime converterHorario(String horario) {
		if(horario == null || horario.isBlank())
			throw new RuntimeException("Parametro obrigatório não informado");
		
		return LocalTime.of(Integer.valueOf(horario.substring(0, 2)), Integer.valueOf(horario.substring(3, 5)));	
	}
	

}
