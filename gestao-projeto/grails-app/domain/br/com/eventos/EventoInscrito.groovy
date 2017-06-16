package br.com.eventos

import br.com.controleAcesso.Usuario
import br.com.teste.enums.SimNao;

class EventoInscrito {
    Evento evento
	Usuario inscrito
	Date dataInscricao = new Date()
	TipoInscricaoValor valor
	InscricaoSituacao situacao
	SimNao liberaFicha = SimNao.NAO
	
    static constraints = {
		
    }
}
