package br.com.eventos

import br.com.teste.enums.SimNao;
import grails.plugin.springsecurity.annotation.Secured;

class FichaDeInscricaoController {
	
	def springSecurityService
	
	@Secured(["ROLE_READ_FICHA_INSCRICAO"])
    def index() { 
		
	}
	
	@Secured(["ROLE_READ_FICHA_INSCRICAO"])
	def listar() {
		
		def user = springSecurityService.currentUser
		def lista = EventoInscrito.createCriteria().list{
			eq("inscrito",user)
			eq("liberaFicha", SimNao.SIM)
		}
		println lista
		render(template: "lista", model:[lista: lista])
	}
	
	@Secured(["ROLE_READ_FICHA_INSCRICAO"])
	def ficha() {
		
		def user = springSecurityService.currentUser
		
		def  eventoInscrito = EventoInscrito.get(params.id)
		
		if(user.id .equals(eventoInscrito.inscrito.id)){
			render(view: "ficha", model:[eventoInscrito: eventoInscrito])
		}
		
	}
	
}
