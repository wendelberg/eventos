package br.com.eventos



import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import br.com.teste.enums.NotifyType
import br.com.teste.utils.UtilsMensagem

@Secured("IS_AUTHENTICATED_FULLY")
class InscricaoParcelasController {
    
	def springSecurityService
	
	@Secured(["ROLE_CREATE_INSCRICAO_PARCELAS", "ROLE_READ_INSCRICAO_PARCELAS", "ROLE_UPDATE_INSCRICAO_PARCELAS", "ROLE_DELETE_INSCRICAO_PARCELAS"])
	def index() {
		def user = springSecurityService.currentUser
	}

	def listar() {
		 def user = springSecurityService.currentUser
		 def lista = InscricaoParcelas.createCriteria().list{
			
			 eventoInscrito{
				 eq("inscrito",user)
			 }
			 order("eventoInscrito")
		 }

		render(template: "lista", model:[lista: lista])
	}

	@Secured("ROLE_CREATE_INSCRICAO_PARCELAS")
	def incluir() {

		InscricaoParcelas inscricaoParcelas = new InscricaoParcelas()
		
		render(template: "form", model:[title: "Novo", editable: true, inscricaoParcelas: inscricaoParcelas])
	}

	@Secured("ROLE_UPDATE_INSCRICAO_PARCELAS")
	def alterar() {

		InscricaoParcelas inscricaoParcelas = InscricaoParcelas.get(params.id)

		render(template: "form", model:[title: "Alterar", editable: true, inscricaoParcelas: inscricaoParcelas])
	}

	@Secured("ROLE_READ_INSCRICAO_PARCELAS")
	def visualizar() {

		InscricaoParcelas inscricaoParcelas = InscricaoParcelas.get(params.id)

		render(template: "form", model:[title: "Visualizar", editable: false, inscricaoParcelas: inscricaoParcelas])
	}

	def salvar(InscricaoParcelas inscricaoParcelas) {

		def retorno

		if (params.inscricaoParcelas.id) {

			InscricaoParcelas old = InscricaoParcelas.get(params.inscricaoParcelas.id);

			if (old.version.toLong() > params.inscricaoParcelas.version.toLong()) {

				retorno = UtilsMensagem.getMensagem("A inscricaoParcelas já foi alterado por outro usuário!\nFavor canecelar esta operação e tentar novamente!", NotifyType.ERROR)

				render retorno as JSON

				return
			}
		}

		if (inscricaoParcelas.hasErrors()) {

			retorno = UtilsMensagem.getMensagem("Não foi possível salvar!", NotifyType.ERROR, inscricaoParcelas.errors)
		} else {

			inscricaoParcelas.save(flush:true)

			retorno = UtilsMensagem.getMensagem("Salvo com sucesso!", NotifyType.SUCCESS)
		}

		render retorno as JSON
	}

	@Secured("ROLE_DELETE_INSCRICAO_PARCELAS")
	def excluir() {

		def retorno

		InscricaoParcelas inscricaoParcelas = InscricaoParcelas.get(params.id)

		try {

			inscricaoParcelas.delete(flush:true)

			retorno = UtilsMensagem.getMensagem("Excluido com sucesso!", NotifyType.SUCCESS)
		} catch(Exception e) {

			retorno = UtilsMensagem.getMensagem("Não foi possível excluir!", NotifyType.ERROR)
		}

		render retorno as JSON
	}
	
}
