package br.com.eventos



import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import br.com.teste.enums.NotifyType
import br.com.teste.utils.UtilsMensagem

@Secured("IS_AUTHENTICATED_FULLY")
class InscricaoSituacaoController {

	@Secured(["ROLE_CREATE_INSCRICAO_SITUACAO", "ROLE_READ_INSCRICAO_SITUACAO", "ROLE_UPDATE_INSCRICAO_SITUACAO", "ROLE_DELETE_INSCRICAO_SITUACAO"])
	def index() {
	}

	def listar() {

		def lista = InscricaoSituacao.createCriteria().list{ order("nome") }

		render(template: "lista", model:[lista: lista])
	}

	@Secured("ROLE_CREATE_INSCRICAO_SITUACAO")
	def incluir() {

		InscricaoSituacao inscricaoSituacao = new InscricaoSituacao()
		
		render(template: "form", model:[title: "Novo", editable: true, inscricaoSituacao: inscricaoSituacao])
	}

	@Secured("ROLE_UPDATE_INSCRICAO_SITUACAO")
	def alterar() {

		InscricaoSituacao inscricaoSituacao = InscricaoSituacao.get(params.id)

		render(template: "form", model:[title: "Alterar", editable: true, inscricaoSituacao: inscricaoSituacao])
	}

	@Secured("ROLE_READ_INSCRICAO_SITUACAO")
	def visualizar() {

		InscricaoSituacao inscricaoSituacao = InscricaoSituacao.get(params.id)

		render(template: "form", model:[title: "Visualizar", editable: false, inscricaoSituacao: inscricaoSituacao])
	}

	def salvar(InscricaoSituacao inscricaoSituacao) {

		def retorno

		if (params.inscricaoSituacao.id) {

			InscricaoSituacao old = InscricaoSituacao.get(params.inscricaoSituacao.id);

			if (old.version.toLong() > params.inscricaoSituacao.version.toLong()) {

				retorno = UtilsMensagem.getMensagem("A inscricaoSituacao já foi alterado por outro usuário!\nFavor canecelar esta operação e tentar novamente!", NotifyType.ERROR)

				render retorno as JSON

				return
			}
		}

		if (inscricaoSituacao.hasErrors()) {

			retorno = UtilsMensagem.getMensagem("Não foi possível salvar!", NotifyType.ERROR, inscricaoSituacao.errors)
		} else {

			inscricaoSituacao.save(flush:true)

			retorno = UtilsMensagem.getMensagem("Salvo com sucesso!", NotifyType.SUCCESS)
		}

		render retorno as JSON
	}

	@Secured("ROLE_DELETE_INSCRICAO_SITUACAO")
	def excluir() {

		def retorno

		InscricaoSituacao inscricaoSituacao = InscricaoSituacao.get(params.id)

		try {

			inscricaoSituacao.delete(flush:true)

			retorno = UtilsMensagem.getMensagem("Excluido com sucesso!", NotifyType.SUCCESS)
		} catch(Exception e) {

			retorno = UtilsMensagem.getMensagem("Não foi possível excluir!", NotifyType.ERROR)
		}

		render retorno as JSON
	}
	
}
