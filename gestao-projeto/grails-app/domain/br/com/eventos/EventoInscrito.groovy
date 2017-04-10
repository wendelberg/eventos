package br.com.eventos

import br.com.controleAcesso.Usuario

class EventoInscrito {
    Evento evento
	Usuario inscrito
	Date dataInscricao = new Date()
	TipoInscricaoValor valor
	InscricaoSituacao situacao
	
    static constraints = {
    }
}
