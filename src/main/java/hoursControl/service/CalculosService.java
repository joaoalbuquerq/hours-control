package hoursControl.service;

import java.time.Duration;
import java.time.LocalTime;

import hoursControl.model.Horario;

public class CalculosService {

	public Horario calcular(String padraoEntrada, String padraoSaida, String marcacaoEntrada, String marcacaoSaida) {
		
		String atraso = verificarAtraso(padraoEntrada, padraoSaida, marcacaoEntrada, marcacaoSaida);
		String extra = verificarExtra(padraoEntrada, padraoSaida, marcacaoEntrada, marcacaoSaida);
		return new Horario(atraso,extra);
	}
	
	public String verificarAtraso(String padraoEntrada, String padraoSaida, String marcacaoEntrada, String marcacaoSaida) {
		
		LocalTime horarioPadraoEntrada = converterHorario(padraoEntrada);
		LocalTime horarioPadraoSaida = converterHorario(padraoSaida);
		LocalTime entrada = converterHorario(marcacaoEntrada);
		LocalTime saida = converterHorario(marcacaoSaida);
		
		long qtdHorasDeviaTrabalhar = Duration.between(horarioPadraoEntrada, horarioPadraoSaida).toHours();
		long qtdHorasTrabalhadas = Duration.between(entrada, saida).toHours();
		long saldoHoras = qtdHorasTrabalhadas - qtdHorasDeviaTrabalhar;
		
		return String.valueOf(saldoHoras <= 0 ? saldoHoras : "");
	}
	
	public String verificarExtra(String padraoEntrada, String padraoSaida, String marcacaoEntrada, String marcacaoSaida) {
		LocalTime horarioPadraoEntrada = converterHorario(padraoEntrada);
		LocalTime horarioPadraoSaida = converterHorario(padraoSaida);
		LocalTime entrada = converterHorario(marcacaoEntrada);
		LocalTime saida = converterHorario(marcacaoSaida);
		
		long qtdHorasDeviaTrabalhar = Duration.between(horarioPadraoEntrada, horarioPadraoSaida).toHours();
		long qtdHorasTrabalhadas = Duration.between(entrada, saida).toHours();
		long saldoHoras =  qtdHorasTrabalhadas - qtdHorasDeviaTrabalhar;
		
		return String.valueOf(saldoHoras >= 0 ? saldoHoras : "");
	}
	
	public LocalTime converterHorario(String horario) {
		if(horario == null || horario.isBlank())
			throw new RuntimeException("Parametro obrigatório não informado");
		
		return LocalTime.of(Integer.valueOf(horario.substring(0, 2)), Integer.valueOf(horario.substring(3, 5)));	
	}
	

}
