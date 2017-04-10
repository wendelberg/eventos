package br.com.eventos



import java.text.SimpleDateFormat;

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import br.com.teste.enums.NotifyType
import br.com.teste.utils.UtilsMensagem

@Secured("IS_AUTHENTICATED_FULLY")
class TipoInscricaoValorController {

	@Secured(["ROLE_CREATE_TIPO_INSCRICAO_VALOR", "ROLE_READ_TIPO_INSCRICAO_VALOR", "ROLE_UPDATE_TIPO_INSCRICAO_VALOR", "ROLE_DELETE_TIPO_INSCRICAO_VALOR"])
	def index() {
	}

	def listar() {

		def lista = TipoInscricaoValor.createCriteria().list{ order("tipoInscricao") }

		render(template: "lista", model:[lista: lista])
	}

	@Secured("ROLE_CREATE_TIPO_INSCRICAO_VALOR")
	def incluir() {

		TipoInscricaoValor tipoInscricaoValor = new TipoInscricaoValor()
		
		render(template: "form", model:[title: "Novo", editable: true, tipoInscricaoValor: tipoInscricaoValor])
	}

	@Secured("ROLE_UPDATE_TIPO_INSCRICAO_VALOR")
	def alterar() {

		TipoInscricaoValor tipoInscricaoValor = TipoInscricaoValor.get(params.id)

		render(template: "form", model:[title: "Alterar", editable: true, tipoInscricaoValor: tipoInscricaoValor])
	}

	@Secured("ROLE_READ_TIPO_INSCRICAO_VALOR")
	def visualizar() {

		TipoInscricaoValor tipoInscricaoValor = TipoInscricaoValor.get(params.id)

		render(template: "form", model:[title: "Visualizar", editable: false, tipoInscricaoValor: tipoInscricaoValor])
	}

	def salvar(TipoInscricaoValor tipoInscricaoValor) {

		def retorno

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy")
		
		Date dataInicioVigencia = null
		if (params.tipoInscricaoValor.dataInicioVigencia)
			dataInicioVigencia = dateFormat.parse(params.tipoInscricaoValor.dataInicioVigencia)

		Date dataFimVigencia = null
		if (params.tipoInscricaoValor.dataFimVigencia)
			dataFimVigencia = dateFormat.parse(params.tipoInscricaoValor.dataFimVigencia)

		if (dataFimVigencia < dataInicioVigencia) {
			retorno = UtilsMensagem.getMensagem("A data de Fim não pode ser menor do que a data de Inicio!", NotifyType.WARN)

			render retorno as JSON

			return
		}

		tipoInscricaoValor.clearErrors()

		tipoInscricaoValor.dataInicioVigencia = dataInicioVigencia

		tipoInscricaoValor.dataInicioVigencia = dataInicioVigencia

		tipoInscricaoValor.validate()
				

		if (params.tipoInscricaoValor.id) {

			TipoInscricaoValor old = TipoInscricaoValor.get(params.tipoInscricaoValor.id);

			if (old.version.toLong() > params.tipoInscricaoValor.version.toLong()) {

				retorno = UtilsMensagem.getMensagem("A tipoInscricaoValor já foi alterado por outro usuário!\nFavor canecelar esta operação e tentar novamente!", NotifyType.ERROR)

				render retorno as JSON

				return
			}
		}

		if (tipoInscricaoValor.hasErrors()) {

			retorno = UtilsMensagem.getMensagem("Não foi possível salvar!", NotifyType.ERROR, tipoInscricaoValor.errors)
		} else {

			tipoInscricaoValor.save(flush:true)

			retorno = UtilsMensagem.getMensagem("Salvo com sucesso!", NotifyType.SUCCESS)
		}

		render retorno as JSON
	}

	@Secured("ROLE_DELETE_TIPO_INSCRICAO_VALOR")
	def excluir() {

		def retorno

		TipoInscricaoValor tipoInscricaoValor = TipoInscricaoValor.get(params.id)

		try {

			tipoInscricaoValor.delete(flush:true)

			retorno = UtilsMensagem.getMensagem("Excluido com sucesso!", NotifyType.SUCCESS)
		} catch(Exception e) {

			retorno = UtilsMensagem.getMensagem("Não foi possível excluir!", NotifyType.ERROR)
		}

		render retorno as JSON
	}
	
}
