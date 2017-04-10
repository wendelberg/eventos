package br.com.eventos



import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import br.com.teste.enums.NotifyType
import br.com.teste.utils.UtilsMensagem

@Secured("IS_AUTHENTICATED_FULLY")
class DistritoController {

	@Secured(["ROLE_CREATE_DISTRITO", "ROLE_READ_DISTRITO", "ROLE_UPDATE_DISTRITO", "ROLE_DELETE_DISTRITO"])
	def index() {
	}

	def listar() {

		def lista = Distrito.createCriteria().list{ order("nome") }

		render(template: "lista", model:[lista: lista])
	}

	@Secured("ROLE_CREATE_DISTRITO")
	def incluir() {

		Distrito distrito = new Distrito()
		
		render(template: "form", model:[title: "Novo", editable: true, distrito: distrito])
	}

	@Secured("ROLE_UPDATE_DISTRITO")
	def alterar() {

		Distrito distrito = Distrito.get(params.id)

		render(template: "form", model:[title: "Alterar", editable: true, distrito: distrito])
	}

	@Secured("ROLE_READ_DISTRITO")
	def visualizar() {

		Distrito distrito = Distrito.get(params.id)

		render(template: "form", model:[title: "Visualizar", editable: false, distrito: distrito])
	}

	def salvar(Distrito distrito) {

		def retorno

		if (params.distrito.id) {

			Distrito old = Distrito.get(params.distrito.id);

			if (old.version.toLong() > params.distrito.version.toLong()) {

				retorno = UtilsMensagem.getMensagem("A distrito já foi alterado por outro usuário!\nFavor canecelar esta operação e tentar novamente!", NotifyType.ERROR)

				render retorno as JSON

				return
			}
		}

		if (distrito.hasErrors()) {

			retorno = UtilsMensagem.getMensagem("Não foi possível salvar!", NotifyType.ERROR, distrito.errors)
		} else {

			distrito.save(flush:true)

			retorno = UtilsMensagem.getMensagem("Salvo com sucesso!", NotifyType.SUCCESS)
		}

		render retorno as JSON
	}

	@Secured("ROLE_DELETE_DISTRITO")
	def excluir() {

		def retorno

		Distrito distrito = Distrito.get(params.id)

		try {

			distrito.delete(flush:true)

			retorno = UtilsMensagem.getMensagem("Excluido com sucesso!", NotifyType.SUCCESS)
		} catch(Exception e) {

			retorno = UtilsMensagem.getMensagem("Não foi possível excluir!", NotifyType.ERROR)
		}

		render retorno as JSON
	}
	
}
