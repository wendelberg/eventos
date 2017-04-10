package br.com.eventos



import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import br.com.teste.enums.NotifyType
import br.com.teste.utils.UtilsMensagem

import java.text.SimpleDateFormat;
@Secured("IS_AUTHENTICATED_FULLY")
class EventoController {

	@Secured(["ROLE_CREATE_EVENTO", "ROLE_READ_EVENTO", "ROLE_UPDATE_EVENTO", "ROLE_DELETE_EVENTO"])
	def index() {
	}

	def listar() {

		def lista = Evento.createCriteria().list{ order("nome") }

		render(template: "lista", model:[lista: lista])
	}

	@Secured("ROLE_CREATE_EVENTO")
	def incluir() {

		Evento evento = new Evento()
		
		render(template: "form", model:[title: "Novo", editable: true, evento: evento])
	}

	@Secured("ROLE_UPDATE_EVENTO")
	def alterar() {

		Evento evento = Evento.get(params.id)

		render(template: "form", model:[title: "Alterar", editable: true, evento: evento])
	}

	@Secured("ROLE_READ_EVENTO")
	def visualizar() {

		Evento evento = Evento.get(params.id)

		render(template: "form", model:[title: "Visualizar", editable: false, evento: evento])
	}

	def salvar(Evento evento) {

		def retorno
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy")
		
		Date dataInicio = null
		if (params.evento.dataInicio)
			dataInicio = dateFormat.parse(params.evento.dataInicio)

		Date dataFim = null
		if (params.evento.dataFim)
			dataFim = dateFormat.parse(params.evento.dataFim)

		if (dataFim < dataInicio) {
			retorno = UtilsMensagem.getMensagem("A data de Fim não pode ser menor do que a data de Inicio!", NotifyType.WARN)

			render retorno as JSON

			return
		}

		evento.clearErrors()

		evento.dataInicio = dataInicio

		evento.dataInicio = dataInicio

		evento.validate()

		if (params.evento.id) {

			Evento old = Evento.get(params.evento.id);

			if (old.version.toLong() > params.evento.version.toLong()) {

				retorno = UtilsMensagem.getMensagem("A evento já foi alterado por outro usuário!\nFavor canecelar esta operação e tentar novamente!", NotifyType.ERROR)

				render retorno as JSON

				return
			}
		}

		if (evento.hasErrors()) {

			retorno = UtilsMensagem.getMensagem("Não foi possível salvar!", NotifyType.ERROR, evento.errors)
		} else {

			evento.save(flush:true)

			retorno = UtilsMensagem.getMensagem("Salvo com sucesso!", NotifyType.SUCCESS)
		}

		render retorno as JSON
	}

	@Secured("ROLE_DELETE_EVENTO")
	def excluir() {

		def retorno

		Evento evento = Evento.get(params.id)

		try {

			evento.delete(flush:true)

			retorno = UtilsMensagem.getMensagem("Excluido com sucesso!", NotifyType.SUCCESS)
		} catch(Exception e) {

			retorno = UtilsMensagem.getMensagem("Não foi possível excluir!", NotifyType.ERROR)
		}

		render retorno as JSON
	}
	
}
