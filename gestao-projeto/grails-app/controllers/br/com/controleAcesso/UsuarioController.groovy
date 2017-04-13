package br.com.controleAcesso

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import br.com.eventos.Endereco
import br.com.eventos.Estado
import br.com.eventos.Evento
import br.com.eventos.EventoInscrito;
import br.com.eventos.EventoSituacao;
import br.com.eventos.InscricaoParcelas;
import br.com.eventos.InscricaoSituacao;
import br.com.eventos.SituacaoParcela;
import br.com.eventos.TipoInscricaoValor;
import br.com.teste.enums.NotifyType
import br.com.teste.utils.UtilsMensagem


@Secured("IS_AUTHENTICATED_FULLY")
class UsuarioController {

	@Secured([
		"ROLE_CREATE_USUARIO",
		"ROLE_READ_USUARIO",
		"ROLE_UPDATE_USUARIO",
		"ROLE_DELETE_USUARIO"
	])
	def index() {
	}

	def listar() {

		def lista = Usuario.createCriteria().list{ order("username") }

		render(template: "lista", model:[lista: lista])
	}

	@Secured("ROLE_CREATE_USUARIO")
	def incluir() {

		Usuario usuario = new Usuario()

		render(template: "form", model:[title: "Novo", editable: true, usuario: usuario])
	}

	@Secured("ROLE_UPDATE_USUARIO")
	def alterar() {

		Usuario usuario = Usuario.get(params.id)

		render(template: "form", model:[title: "Alterar", editable: true, usuario: usuario])
	}

	@Secured("ROLE_READ_USUARIO")
	def visualizar() {

		Usuario usuario = Usuario.get(params.id)

		render(template: "form", model:[title: "Visualizar", editable: false, usuario: usuario])
	}

	def salvar(Usuario usuario) {

		def retorno

		Long grupoOld
		Long grupoNew

		if (params.usuario.id) {

			Usuario old = Usuario.get(params.usuario.id);

			grupoOld = params.grupoOld.toLong()
			grupoNew = params.usuario.usuarioGrupo.toLong()

			if (old.version.toLong() > params.usuario.version.toLong()) {

				retorno = UtilsMensagem.getMensagem("A situação projeto já foi alterado por outro usuário!\nFavor canecelar esta operação e tentar novamente!", NotifyType.ERROR)

				render retorno as JSON

				return
			}
		}

		if (usuario.hasErrors()) {

			retorno = UtilsMensagem.getMensagem("Não foi possível salvar!", NotifyType.ERROR, usuario.errors)
		} else {

			usuario.save(flush:true)

			if (grupoOld) {

				if (!(grupoOld.equals(grupoNew))) {
					// incluir permissoes quando o usuario muda de grupo

					UsuarioPermissao.removeAll(usuario, true)

					List permissoes = UsuarioGrupoPermissao.findAllByUsuarioGrupo(usuario.usuarioGrupo)

					for (usuarioGrupoPermissao in permissoes) {

						UsuarioPermissao.create(usuario, usuarioGrupoPermissao.permissao, true)

					}

				}
			} else {
				// incluir permissoes para novos usuarios

				List permissoes = UsuarioGrupoPermissao.findAllByUsuarioGrupo(usuario.usuarioGrupo)

				for (usuarioGrupoPermissao in permissoes) {

					UsuarioPermissao.create(usuario, usuarioGrupoPermissao.permissao, true)

				}

			}

			retorno = UtilsMensagem.getMensagem("Salvo com sucesso!", NotifyType.SUCCESS)
		}

		render retorno as JSON
	}

	@Secured("ROLE_DELETE_USUARIO")
	def excluir() {

		def retorno

		Usuario usuario = Usuario.get(params.id)

		try {

			UsuarioPermissao.removeAll(usuario, true);

			usuario.delete(flush:true)

			retorno = UtilsMensagem.getMensagem("Excluido com sucesso!", NotifyType.SUCCESS)
		} catch(Exception e) {

			retorno = UtilsMensagem.getMensagem("Não foi possível excluir!", NotifyType.ERROR)
		}

		render retorno as JSON
	}
    
	@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
	def cadastrar(){
		render view: "cadastro"
				
	}
	
	@Secured("IS_AUTHENTICATED_ANONYMOUSLY")	
	def cadastrarSalvar(Usuario usuario){
		def retorno

		
		if (usuario.password.equals(params.usuario.password2)){
			usuario.clearErrors()
			
			def usuarioGrupo = UsuarioGrupo.get(2)
			def permissoes = UsuarioGrupoPermissao.createCriteria().list {
				eq('usuarioGrupo',usuarioGrupo)
				projections {
					property("permissao")
				}
			}
			usuario.usuarioGrupo = usuarioGrupo
			
			usuario.validate()
			if(usuario.hasErrors()){
				println usuario.errors	
			}else{
				usuario.save(flush:true)
				for(permissao in permissoes){
					new UsuarioPermissao(usuario: usuario, permissao: permissao).save()
				}
					
				retorno = UtilsMensagem.getMensagem("Cadastrado com sucesso!", NotifyType.SUCCESS)
				retorno["id"] = usuario.id
				retorno["idTipoInscricao"] = usuario.tipoInscricao.id
			}
						
		}else{
			retorno = UtilsMensagem.getMensagem("Senhas n�o conferem!", NotifyType.ERROR)
		}	
		
		
		render retorno as JSON
		
		
	}
	
	@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
	def buscaDadosEventos(){
		Evento evento = Evento.get(params.id)
		def list = TipoInscricaoValor.createCriteria().list {
			eq('tipoInscricao.id',Long.valueOf(params.idTipoInscricao))
			eq('evento',evento)
			lt('dataInicioVigencia',new Date())
			gt('dataFimVigencia',new Date())
		}  
		
		def retorno = [:]
		retorno["evento"] = evento
		retorno["tipoInscricaoValor"] = list.get(0)
		retorno["eventoSituacao"] = EventoSituacao.get(evento.situacao.id).nome
		
		render retorno as JSON
		
	}
	
	@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
	def enderecoSalvar(Endereco endereco){
		def retorno
		
		endereco.clearErrors()
		
		endereco.uf = Estado.findBySigla(params.endereco.uf)
		
		endereco.validate()

		if (endereco.hasErrors()) {

			retorno = UtilsMensagem.getMensagem("Não foi possível salvar!", NotifyType.ERROR, endereco.errors)
		} else {

			endereco.save(flush:true)
			Usuario usuario = Usuario.get(params.idClienteCadastro)
			usuario.endereco = endereco
			usuario.save(flush:true)
			retorno = UtilsMensagem.getMensagem("Salvo com sucesso!", NotifyType.SUCCESS)
			retorno["id"] = endereco.id
		}
		
		render retorno as JSON
		
		
	}
	
	@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
	def inscricaoSalvar(){
		def retorno
		println params
		
		TipoInscricaoValor tipoInscricaoValor = TipoInscricaoValor.get(params.idTipoInscricaoValor)
		
		EventoInscrito eventoInscrito = new EventoInscrito()
		eventoInscrito.evento = Evento.get(params.evento.id)
		eventoInscrito.inscrito = Usuario.get(params.idCliente2Cadastro)
		eventoInscrito.situacao = InscricaoSituacao.get(3)
		eventoInscrito.valor = tipoInscricaoValor
		
		eventoInscrito.save(flush:true)
		
		Calendar calendar = Calendar.getInstance()
		int day = calendar.get(Calendar.DAY_OF_MONTH)
		
		if (day > 10) {
			calendar.add(Calendar.MONTH, 1)
		}
		
		calendar.set(Calendar.DAY_OF_MONTH, 10)
		 
		int parcelas = Integer.parseInt(params.tipoInscricaoValor.maxParcelas) 
		println parcelas
		double valorParcela = tipoInscricaoValor.valor/parcelas
		println valorParcela
		for (int i=1;i<=parcelas;i++){
			
			if (i > 1) {
				calendar.add(Calendar.MONTH, 1);
			}
			
			InscricaoParcelas inscricaoParcelas = new InscricaoParcelas()
		    inscricaoParcelas.eventoInscrito = eventoInscrito
			inscricaoParcelas.numeroParcela = i
			inscricaoParcelas.situacao = SituacaoParcela.get(3)
			inscricaoParcelas.valorParcela = valorParcela
			inscricaoParcelas.dataVencimento = calendar.getTime()
			
			inscricaoParcelas.save(flush:true)
		}
			
		retorno = UtilsMensagem.getMensagem("Salvo com sucesso!", NotifyType.SUCCESS)
		
		render retorno as JSON
	}
	
	

}
