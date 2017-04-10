package br.com.eventos

class TermoAcordo {
    String termo
	String descricao
    static constraints = {
    }
	static mapping = {
		descricao type: 'text'
	}
}
