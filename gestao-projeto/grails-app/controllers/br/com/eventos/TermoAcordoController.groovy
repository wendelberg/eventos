package br.com.eventos



import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import br.com.teste.enums.NotifyType
import br.com.teste.utils.UtilsMensagem

@Secured("IS_AUTHENTICATED_FULLY")
class TermoAcordoController {

	@Secured(["ROLE_CREATE_TERMO_ACORDO", "ROLE_READ_TERMO_ACORDO", "ROLE_UPDATE_TERMO_ACORDO", "ROLE_DELETE_TERMO_ACORDO"])
	def index() {
	}

	def listar() {

		def lista = TermoAcordo.createCriteria().list{ order("termo") }

		render(template: "lista", model:[lista: lista])
	}

	@Secured("ROLE_CREATE_TERMO_ACORDO")
	def incluir() {

		TermoAcordo termoAcordo = new TermoAcordo()
		
		render(template: "form", model:[title: "Novo", editable: true, termoAcordo: termoAcordo])
	}

	@Secured("ROLE_UPDATE_TERMO_ACORDO")
	def alterar() {

		TermoAcordo termoAcordo = TermoAcordo.get(params.id)

		render(template: "form", model:[title: "Alterar", editable: true, termoAcordo: termoAcordo])
	}

	@Secured("ROLE_READ_TERMO_ACORDO")
	def visualizar() {

		TermoAcordo termoAcordo = TermoAcordo.get(params.id)

		render(template: "form", model:[title: "Visualizar", editable: false, termoAcordo: termoAcordo])
	}

	def salvar(TermoAcordo termoAcordo) {

		def retorno

		if (params.termoAcordo.id) {

			TermoAcordo old = TermoAcordo.get(params.termoAcordo.id);

			if (old.version.toLong() > params.termoAcordo.version.toLong()) {

				retorno = UtilsMensagem.getMensagem("A termoAcordo já foi alterado por outro usuário!\nFavor canecelar esta operação e tentar novamente!", NotifyType.ERROR)

				render retorno as JSON

				return
			}
		}

		if (termoAcordo.hasErrors()) {

			retorno = UtilsMensagem.getMensagem("Não foi possível salvar!", NotifyType.ERROR, termoAcordo.errors)
		} else {

			termoAcordo.save(flush:true)

			retorno = UtilsMensagem.getMensagem("Salvo com sucesso!", NotifyType.SUCCESS)
		}

		render retorno as JSON
	}

	@Secured("ROLE_DELETE_TERMO_ACORDO")
	def excluir() {

		def retorno

		TermoAcordo termoAcordo = TermoAcordo.get(params.id)

		try {

			termoAcordo.delete(flush:true)

			retorno = UtilsMensagem.getMensagem("Excluido com sucesso!", NotifyType.SUCCESS)
		} catch(Exception e) {

			retorno = UtilsMensagem.getMensagem("Não foi possível excluir!", NotifyType.ERROR)
		}

		render retorno as JSON
	}
	
}
