package br.com.eventos



import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import br.com.teste.enums.NotifyType
import br.com.teste.utils.UtilsMensagem

@Secured("IS_AUTHENTICATED_FULLY")
class TipoInscricaoController {

	@Secured(["ROLE_CREATE_TIPO_INSCRICAO", "ROLE_READ_TIPO_INSCRICAO", "ROLE_UPDATE_TIPO_INSCRICAO", "ROLE_DELETE_TIPO_INSCRICAO"])
	def index() {
	}

	def listar() {

		def lista = TipoInscricao.createCriteria().list{ order("nome") }

		render(template: "lista", model:[lista: lista])
	}

	@Secured("ROLE_CREATE_TIPO_INSCRICAO")
	def incluir() {

		TipoInscricao tipoInscricao = new TipoInscricao()
		
		render(template: "form", model:[title: "Novo", editable: true, tipoInscricao: tipoInscricao])
	}

	@Secured("ROLE_UPDATE_TIPOINSCRICAO")
	def alterar() {

		TipoInscricao tipoInscricao = TipoInscricao.get(params.id)

		render(template: "form", model:[title: "Alterar", editable: true, tipoInscricao: tipoInscricao])
	}

	@Secured("ROLE_READ_TIPO_INSCRICAO")
	def visualizar() {

		TipoInscricao tipoInscricao = TipoInscricao.get(params.id)

		render(template: "form", model:[title: "Visualizar", editable: false, tipoInscricao: tipoInscricao])
	}

	def salvar(TipoInscricao tipoInscricao) {

		def retorno

		if (params.tipoInscricao.id) {

			TipoInscricao old = TipoInscricao.get(params.tipoInscricao.id);

			if (old.version.toLong() > params.tipoInscricao.version.toLong()) {

				retorno = UtilsMensagem.getMensagem("A tipoInscricao já foi alterado por outro usuário!\nFavor canecelar esta operação e tentar novamente!", NotifyType.ERROR)

				render retorno as JSON

				return
			}
		}

		if (tipoInscricao.hasErrors()) {

			retorno = UtilsMensagem.getMensagem("Não foi possível salvar!", NotifyType.ERROR, tipoInscricao.errors)
		} else {

			tipoInscricao.save(flush:true)

			retorno = UtilsMensagem.getMensagem("Salvo com sucesso!", NotifyType.SUCCESS)
		}

		render retorno as JSON
	}

	@Secured("ROLE_DELETE_TIPO_INSCRICAO")
	def excluir() {

		def retorno

		TipoInscricao tipoInscricao = TipoInscricao.get(params.id)

		try {

			tipoInscricao.delete(flush:true)

			retorno = UtilsMensagem.getMensagem("Excluido com sucesso!", NotifyType.SUCCESS)
		} catch(Exception e) {

			retorno = UtilsMensagem.getMensagem("Não foi possível excluir!", NotifyType.ERROR)
		}

		render retorno as JSON
	}
	
}
