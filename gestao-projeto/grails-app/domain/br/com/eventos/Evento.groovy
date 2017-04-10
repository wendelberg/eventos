package br.com.eventos


import java.text.SimpleDateFormat

import javax.persistence.Transient;

class Evento {
	String nome
	Date dataIncio
	Date dataFim
	Endereco endereco
	EventoSituacao situacao
	TermoAcordo termo
	@Transient
	String dataInicioDescricao
	@Transient
	String dataFimDescricao

	static constraints = {
		
	}
	
	public String getDataInicioDescricao(){
		return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dataIncio)
		
	}
	public String getDataFimDescricao(){
		return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dataFim)
		
	}
}
