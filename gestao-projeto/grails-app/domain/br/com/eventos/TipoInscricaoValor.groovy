package br.com.eventos

class TipoInscricaoValor {
	TipoInscricao tipoInscricao
	Double valor
	Date dataInicioVigencia = new Date()
	Date dataFimVigencia = new Date()
	Integer maxParcelas
    Evento evento
	static constraints = {
		
	}
}
