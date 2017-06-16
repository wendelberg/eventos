package br.com.eventos

import br.com.teste.enums.NotifyType;
import br.com.teste.enums.SimNao;
import br.com.teste.utils.UtilsMensagem;
import grails.converters.JSON;
import grails.plugin.springsecurity.annotation.Secured;


@Secured("IS_AUTHENTICATED_FULLY")
class ListaDeInscritosController {
	
	@Secured(["ROLE_READ_INSCRICAO_LISTA"])
    def index() {
	
	}
	
	@Secured(["ROLE_READ_INSCRICAO_LISTA"])
	def listar() {
		
		def lista = ListaDeInscritos.createCriteria().list{ order("nome") }

		render(template: "lista", model:[lista: lista])
	}
	
	@Secured(["ROLE_READ_INSCRICAO_LISTA"])
	def liberar(){
		def retorno
		
		def inscrito = EventoInscrito.get(params.id.toLong())
		if (inscrito.liberaFicha.equals(SimNao.SIM)){
			inscrito.liberaFicha = SimNao.NAO
			retorno = UtilsMensagem.getMensagem("Ficha de inscrição bloqueada com sucesso!", NotifyType.SUCCESS)
		}else{
			inscrito.liberaFicha = SimNao.SIM
			retorno = UtilsMensagem.getMensagem("Ficha de inscrição liberada com sucesso!", NotifyType.SUCCESS)
		}
		
		inscrito.save()
		
		render retorno as JSON
	}
}
