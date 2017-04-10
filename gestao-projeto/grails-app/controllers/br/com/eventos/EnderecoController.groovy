package br.com.eventos



import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import br.com.teste.enums.NotifyType
import br.com.teste.utils.UtilsMensagem

@Secured("IS_AUTHENTICATED_FULLY")
class EnderecoController {

	@Secured(["ROLE_CREATE_ENDERECO", "ROLE_READ_ENDERECO", "ROLE_UPDATE_ENDERECO", "ROLE_DELETE_ENDERECO"])
	def index() {
	}

	def listar() {

		def lista = Endereco.createCriteria().list{ order("nome") }

		render(template: "lista", model:[lista: lista])
	}

	@Secured("ROLE_CREATE_ENDERECO")
	def incluir() {

		Endereco endereco = new Endereco()
		
		render(template: "form", model:[title: "Novo", editable: true, endereco: endereco])
	}

	@Secured("ROLE_UPDATE_ENDERECO")
	def alterar() {

		Endereco endereco = Endereco.get(params.id)

		render(template: "form", model:[title: "Alterar", editable: true, endereco: endereco])
	}

	@Secured("ROLE_READ_ENDERECO")
	def visualizar() {

		Endereco endereco = Endereco.get(params.id)

		render(template: "form", model:[title: "Visualizar", editable: false, endereco: endereco])
	}

	def salvar(Endereco endereco) {

		def retorno

		if (params.endereco.id) {

			Endereco old = Endereco.get(params.endereco.id);

			if (old.version.toLong() > params.endereco.version.toLong()) {

				retorno = UtilsMensagem.getMensagem("A endereco já foi alterado por outro usuário!\nFavor canecelar esta operação e tentar novamente!", NotifyType.ERROR)

				render retorno as JSON

				return
			}
		}
		
		endereco.clearErrors()
		
		endereco.uf = Estado.findBySigla(params.endereco.uf) 
		
		endereco.validate()

		if (endereco.hasErrors()) {

			retorno = UtilsMensagem.getMensagem("Não foi possível salvar!", NotifyType.ERROR, endereco.errors)
		} else {

			endereco.save(flush:true)

			retorno = UtilsMensagem.getMensagem("Salvo com sucesso!", NotifyType.SUCCESS)
		}

		render retorno as JSON
	}

	@Secured("ROLE_DELETE_ENDERECO")
	def excluir() {

		def retorno

		Endereco endereco = Endereco.get(params.id)

		try {

			endereco.delete(flush:true)

			retorno = UtilsMensagem.getMensagem("Excluido com sucesso!", NotifyType.SUCCESS)
		} catch(Exception e) {

			retorno = UtilsMensagem.getMensagem("Não foi possível excluir!", NotifyType.ERROR)
		}

		render retorno as JSON
	}
	
}
