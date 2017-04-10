package br.com.eventos



import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import br.com.teste.enums.NotifyType
import br.com.teste.utils.UtilsMensagem

@Secured("IS_AUTHENTICATED_FULLY")
class SituacaoParcelaController {

	@Secured(["ROLE_CREATE_SITUACAO_PARCELA", "ROLE_READ_SITUACAO_PARCELA", "ROLE_UPDATE_SITUACAO_PARCELA", "ROLE_DELETE_SITUACAO_PARCELA"])
	def index() {
	}

	def listar() {

		def lista = SituacaoParcela.createCriteria().list{ order("nome") }

		render(template: "lista", model:[lista: lista])
	}

	@Secured("ROLE_CREATE_SITUACAO_PARCELA")
	def incluir() {

		SituacaoParcela situacaoParcela = new SituacaoParcela()
		
		render(template: "form", model:[title: "Novo", editable: true, situacaoParcela: situacaoParcela])
	}

	@Secured("ROLE_UPDATE_SITUACAO_PARCELA")
	def alterar() {

		SituacaoParcela situacaoParcela = SituacaoParcela.get(params.id)

		render(template: "form", model:[title: "Alterar", editable: true, situacaoParcela: situacaoParcela])
	}

	@Secured("ROLE_READ_SITUACAO_PARCELA")
	def visualizar() {

		SituacaoParcela situacaoParcela = SituacaoParcela.get(params.id)

		render(template: "form", model:[title: "Visualizar", editable: false, situacaoParcela: situacaoParcela])
	}

	def salvar(SituacaoParcela situacaoParcela) {

		def retorno

		if (params.situacaoParcela.id) {

			SituacaoParcela old = SituacaoParcela.get(params.situacaoParcela.id);

			if (old.version.toLong() > params.situacaoParcela.version.toLong()) {

				retorno = UtilsMensagem.getMensagem("A situacaoParcela já foi alterado por outro usuário!\nFavor canecelar esta operação e tentar novamente!", NotifyType.ERROR)

				render retorno as JSON

				return
			}
		}

		if (situacaoParcela.hasErrors()) {

			retorno = UtilsMensagem.getMensagem("Não foi possível salvar!", NotifyType.ERROR, situacaoParcela.errors)
		} else {

			situacaoParcela.save(flush:true)

			retorno = UtilsMensagem.getMensagem("Salvo com sucesso!", NotifyType.SUCCESS)
		}

		render retorno as JSON
	}

	@Secured("ROLE_DELETE_SITUACAO_PARCELA")
	def excluir() {

		def retorno

		SituacaoParcela situacaoParcela = SituacaoParcela.get(params.id)

		try {

			situacaoParcela.delete(flush:true)

			retorno = UtilsMensagem.getMensagem("Excluido com sucesso!", NotifyType.SUCCESS)
		} catch(Exception e) {

			retorno = UtilsMensagem.getMensagem("Não foi possível excluir!", NotifyType.ERROR)
		}

		render retorno as JSON
	}
	
}
