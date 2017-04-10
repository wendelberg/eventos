package br.com.eventos



import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import br.com.teste.enums.NotifyType
import br.com.teste.utils.UtilsMensagem

@Secured("IS_AUTHENTICATED_FULLY")
class EventoSituacaoController {

	@Secured(["ROLE_CREATE_EVENTO_SITUACAO", "ROLE_READ_EVENTO_SITUACAO", "ROLE_UPDATE_EVENTO_SITUACAO", "ROLE_DELETE_EVENTO_SITUACAO"])
	def index() {
	}

	def listar() {

		def lista = EventoSituacao.createCriteria().list{ order("nome") }

		render(template: "lista", model:[lista: lista])
	}

	@Secured("ROLE_CREATE_EVENTO_SITUACAO")
	def incluir() {

		EventoSituacao eventoSituacao = new EventoSituacao()
		
		render(template: "form", model:[title: "Novo", editable: true, eventoSituacao: eventoSituacao])
	}

	@Secured("ROLE_UPDATE_EVENTO_SITUACAO")
	def alterar() {

		EventoSituacao eventoSituacao = EventoSituacao.get(params.id)

		render(template: "form", model:[title: "Alterar", editable: true, eventoSituacao: eventoSituacao])
	}

	@Secured("ROLE_READ_EVENTO_SITUACAO")
	def visualizar() {

		EventoSituacao eventoSituacao = EventoSituacao.get(params.id)

		render(template: "form", model:[title: "Visualizar", editable: false, eventoSituacao: eventoSituacao])
	}

	def salvar(EventoSituacao eventoSituacao) {

		def retorno

		if (params.eventoSituacao.id) {

			EventoSituacao old = EventoSituacao.get(params.eventoSituacao.id);

			if (old.version.toLong() > params.eventoSituacao.version.toLong()) {

				retorno = UtilsMensagem.getMensagem("A eventoSituacao já foi alterado por outro usuário!\nFavor canecelar esta operação e tentar novamente!", NotifyType.ERROR)

				render retorno as JSON

				return
			}
		}

		if (eventoSituacao.hasErrors()) {

			retorno = UtilsMensagem.getMensagem("Não foi possível salvar!", NotifyType.ERROR, eventoSituacao.errors)
		} else {

			eventoSituacao.save(flush:true)

			retorno = UtilsMensagem.getMensagem("Salvo com sucesso!", NotifyType.SUCCESS)
		}

		render retorno as JSON
	}

	@Secured("ROLE_DELETE_EVENTO_SITUACAO")
	def excluir() {

		def retorno

		EventoSituacao eventoSituacao = EventoSituacao.get(params.id)

		try {

			eventoSituacao.delete(flush:true)

			retorno = UtilsMensagem.getMensagem("Excluido com sucesso!", NotifyType.SUCCESS)
		} catch(Exception e) {

			retorno = UtilsMensagem.getMensagem("Não foi possível excluir!", NotifyType.ERROR)
		}

		render retorno as JSON
	}
	
}
