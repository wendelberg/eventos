<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Inscreva-se</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">

<!-- Reset -->
<link rel="stylesheet"
	href="${createLink(uri: '/adminlte/plugins/reset/html5-reset.css')}">
<!-- Bootstrap 3.3.5 -->
<link rel="stylesheet"
	href="${createLink(uri: '/adminlte/bootstrap/css/bootstrap.min.css')}">
<!-- Select2 -->
<link rel="stylesheet"
	href="${createLink(uri: '/adminlte/plugins/select2/select2.min.css')}">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- Confirm -->
<link rel="stylesheet"
	href="${createLink(uri: '/adminlte/plugins/confirm/jquery-confirm.min.css')}">
<!-- Theme style -->
<link rel="stylesheet"
	href="${createLink(uri: '/adminlte/dist/css/AdminLTE.min.css')}">
<!-- Skin - blue -->
<link rel="stylesheet"
	href="${createLink(uri: '/adminlte/dist/css/skins/skin-blue.min.css')}">

<!-- REQUIRED JS SCRIPTS -->
<!-- jQuery 2.1.4 -->
<script
	src="${createLink(uri: '/adminlte/plugins/jQuery/jQuery-2.1.4.min.js')}"></script>
<!-- jQueryUI -->
<script
	src="${createLink(uri: '/adminlte/plugins/jQueryUI/jquery-ui.min.js')}"></script>
<!-- Bootstrap 3.3.5 -->
<script
	src="${createLink(uri: '/adminlte/bootstrap/js/bootstrap.min.js')}"></script>
<!-- AdminLTE App -->
<script src="${createLink(uri: '/adminlte/dist/js/app.min.js')}"></script>
<!-- Notify -->
<script type="text/javascript"
	src="${createLink(uri: '/adminlte/plugins/notify/notify.js')}"></script>
<!-- Select2 -->
<script
	src="${createLink(uri: '/adminlte/plugins/select2/select2.full.min.js')}"></script>
<!-- InputMask -->
<script
	src="${createLink(uri: '/adminlte/plugins/input-mask/jquery.inputmask.bundle.js')}"></script>
<script
	src="${createLink(uri: '/adminlte/plugins/input-mask/jquery.price_format.2.0.min.js')}"></script>




</head>

<body class="hold-transition login-page">

	<div class="container">

		<div class="login-logo">
			<a href="/gestao-projeto"><b>Disca</b>Inscrição</a>
		</div>

		<div class="box box-primary" id="div_login">
			<div class="box-header with-border">
				<h3 class="box-title">Dados</h3>
			</div>

            <g:formRemote id='loginForm' url="[action: 'cadastrarSalvar']"
            	class='cssform' autocomplete='off' name="loginForm" onSuccess="retornoCadastrarSalvar(data)">
				

				<div class="box-body">
				  	<div class="col-sm-12 col-md-6 form-group">
						<label>Nome</label>
						<div class="input-group">
							<div class="input-group-addon">
								<i class="fa fa-laptop"></i>
							</div>
							<input type="text" class="form-control" name="usuario.nome"
								required="required" id="nome">
						</div>
					</div>

					<div class="col-sm-12 col-md-6 form-group">
						<label>Login</label>
						<div class="input-group">
							<div class="input-group-addon">
								<i class="fa fa-laptop"></i>
							</div>
							<input type="text" class="form-control" name="usuario.username"
								required="required" id="username">
						</div>
					</div>
					
					<div class="col-sm-12 col-md-6 form-group">
						<label>E-mail</label>
						<div class="input-group">
							<div class="input-group-addon">
								<i class="fa fa-laptop"></i>
							</div>
							<input type="email" class="form-control" name="usuario.email"
								required="required" id="email">
						</div>
					</div>

					<div class="col-sm-12 col-md-6 form-group">
						<label>Senha</label>
						<div class="input-group">
							<div class="input-group-addon">
								<i class="fa fa-lock"></i>
							</div>
							<input type="password" class="form-control" name="usuario.password"
								required="required" id="password">
						</div>
					</div>
					
					<div class="col-sm-12 col-md-6 form-group">
						<label>Confirme a Senha</label>
						<div class="input-group">
							<div class="input-group-addon">
								<i class="fa fa-lock"></i>
							</div>
							<input type="password" class="form-control" name="usuario.password2"
								required="required" id="password2">
						</div>
					</div>
															
					<div class="col-sm-12 col-md-6 form-group">
						<label>Data Nascimento</label>
						<div class="input-group">
							<div class="input-group-addon">
								<i class="fa fa-laptop"></i>
							</div>
							<input type="text" class="form-control data"
								name="usuario.nascimento" id="nascimento">
						</div>
					</div>
					
					<div class="col-sm-12 col-md-6 form-group">
						<label>Estado Civil</label>
						<select class="form-control select2" name="usuario.estadoCivil" id="estadoCivil" required="required">
							<option value="">Selecione o Estado Civil</option>
							<option value="S">Solteiro(a)</option>
							<option value="C">Casado(a)</option>
							<option value="D">Divorciado(a)</option>
							<option value="V">Viuvo(a)</option>						
						</select>
					</div>
					
					<div class="col-sm-12 col-md-6 form-group">
						<label>União Juvenil</label>
						<select class="form-control select2" name="usuario.juventude" id="juventude">
							<option value="">Selecione a Juventude</option>
							<g:each
								in="${br.com.eventos.UniaoJuvenil.createCriteria().list{ order('nome') }}"
								var="uj">
									<option value="${uj.id}">
										${uj.nome}
									</option>
							</g:each>
						</select>
					</div>
					
					<div class="col-sm-12 col-md-6 form-group">
						<label>Membro da IELB</label>
						<select class="form-control select2" name="usuario.membroIelb" id="membroIelb" required="required">
							<option value="">Selecione</option>
							<option value="true">Sim</option>
							<option value="false">Não</option>					
						</select>
					</div>
					
					<div class="col-sm-12 col-md-6 form-group">
						<label>Participa da Santa Ceia</label>
						<select class="form-control select2" name="usuario.participaSantaCeia" id="participaSantaCeia" required="required">
							<option value="">Selecione</option>
							<option value="true">Sim</option>
							<option value="false">Não</option>					
						</select>
					</div>
					
					<div class="col-sm-12 col-md-6 form-group">
						<label>Sexo</label>
						<select class="form-control select2" name="usuario.sexo" id="sexo" required="required">
							<option value="">Selecione</option>
							<option value="F">Feminino</option>
							<option value="M">Masculino</option>					
						</select>
					</div>
					
					<div class="col-sm-12 col-md-6 form-group">
						<label>Tipo Inscrição</label>
						<select class="form-control select2" name="usuario.tipoInscricao" id="tipoInscricao">
							<option value="">Selecione</option>
							<g:each
								in="${br.com.eventos.TipoInscricao.createCriteria().list{ order('nome') }}"
								var="tipoInscricao">
									<option value="${tipoInscricao.id}">
										${tipoInscricao.nome}
									</option>
							</g:each>
						</select>	
					</div>
					
					<input type="hidden" name="usuario.id" id="id">
					
				</div>

				<div class="box-footer">

					<a href="/gestao-projeto" class="btn btn-danger">Cancelar</a>

					<button type="submit" class="btn btn-primary pull-right">Confirmar</button>

				</div>

			</g:formRemote>

		</div>
		
		<div class="box box-primary" id="div_endereco">
			<div class="box-header with-border">
				<h3 class="box-title">Endereço</h3>
			</div>

            <g:formRemote id='enderecoForm' url="[action: 'enderecoSalvar']"
            	class='cssform' autocomplete='off' name="enderecoForm" onSuccess="retornoEnderecoSalvar(data)">
				
 
				<div class="box-body">

	 				<div class="col-sm-12 col-md-6 form-group">
						<label>* Nome do Endereço</label>
						<div class="input-group">
							<div class="input-group-addon">
								<i class="fa fa-laptop"></i>
							</div>
							<input type="text" class="form-control"
								name="endereco.nome" id="nome">
						</div>
					</div>

					<div class="col-sm-12 col-md-6 form-group">
						<label>* CEP</label>
						<div class="input-group">
							<div class="input-group-addon">
								<i class="fa fa-laptop"></i>
							</div>
							<input type="text" class="form-control"
								name="endereco.cep" id="cep" >
						</div>
					</div>
					
					<div class="col-sm-12 col-md-6 form-group">
						<label>* Rua</label>
						<div class="input-group">
							<div class="input-group-addon">
								<i class="fa fa-laptop"></i>
							</div>
							<input type="text" class="form-control"
								name="endereco.rua" id="rua">
						</div>
					</div>
					
		            <div class="col-sm-12 col-md-6 form-group">
						<label>* Bairro</label>
						<div class="input-group">
							<div class="input-group-addon">
								<i class="fa fa-laptop"></i>
							</div>
							<input type="text" class="form-control"
								name="endereco.bairro" id="bairro" >								
						</div>
					</div>
					
					<div class="col-sm-12 col-md-6 form-group">
						<label>* Cidade</label>
						<div class="input-group">
							<div class="input-group-addon">
								<i class="fa fa-laptop"></i>
							</div>
							<input type="text" class="form-control"
								name="endereco.cidade" id="cidade">
						</div>
					</div>
					
					<div class="col-sm-12 col-md-6 form-group">
						<label>* UF</label>
						<select class="form-control select2" name="endereco.uf" id="uf">
							<option value="">Selecione o Estado</option>
							<g:each
								in="${br.com.eventos.Estado.createCriteria().list{ order('nome') }}"
								var="estado">
									<option value="${estado.sigla}">
										${estado.nome}
									</option>
							</g:each>
						</select>						
					</div>
					
					
					<div class="col-sm-12 col-md-6 form-group">
						<label>* Numero</label>
						<div class="input-group">
							<div class="input-group-addon">
								<i class="fa fa-laptop"></i>
							</div>
							<input type="text" class="form-control"
								name="endereco.numero" id="numero">
						</div>
					</div>

					<div class="col-sm-12 col-md-6 form-group">
						<label>* Complemento</label>
						<div class="input-group">
							<div class="input-group-addon">
								<i class="fa fa-laptop"></i>
							</div>
							<input type="text" class="form-control"
								name="endereco.complemento" id="complemento" >
						</div>
					</div>
					
					<div class="col-sm-12 col-md-6 form-group">
						<label>* Ponto de Referência</label>
						<div class="input-group">
							<div class="input-group-addon">
								<i class="fa fa-laptop"></i>
							</div>
							<input type="text" class="form-control"
								name="endereco.pontoReferencia" id="pontoReferencia" >
						</div>
					</div>
					
					<input type="hidden" id="idCliente" name="idClienteCadastro">
					<input type="hidden" name="endereco.id" id="idEndereco">
					
					
				</div> 

				<div class="box-footer">

					<button type="button" onclick="voltarCadastro()"  class="btn btn-danger">Voltar</button>

					<button type="submit" class="btn btn-primary pull-right">Confirmar</button>

				</div>

			</g:formRemote>

		</div>
		
		<div class="box box-primary" id="div_inscricao">
			<div class="box-header with-border">
				<h3 class="box-title">Dados da Inscrição</h3>
			</div>

            <g:formRemote id='inscricaoForm' url="[action: 'inscricaoSalvar']"
            	class='cssform' autocomplete='off' name="inscricaoForm" onSuccess="retornoInscricaoSalvar(data)">
				

				<div class="box-body">
									
					<div class="col-sm-12 form-group">
						<label>Evento Disponível</label>
						<select class="form-control select2" name="evento.id" id="evento" onchange="buscaDadosEventos(this.value)">
							<option value="">Selecione o Evento</option>
							<g:each
								in="${br.com.eventos.Evento.createCriteria().list{ 
										eq('situacao.id', 1l )
										order('nome') 
									}}"
								var="evento">
									<option value="${evento.id}">
										${evento.nome}
									</option>
							</g:each>
						</select>	
					</div>
					
					<div class="col-sm-12 form-group hide" id="tableDetalhesEvento">
						<label>Dados do Evento</label>
						<div class="container col-sm-12 form-group" >
							 <table class="table table-hover">
							    <thead>
							      <tr>
							        <th>Nome do Evento</th>
							        <th>Data Início</th>
							        <th>Data Fim</th>
							        <th>Situação</th>
							      </tr>
							    </thead>
							    <tbody>
							      <tr>
							        <td><label id="nameEvento"></label></td>
							        <td><label id="dataInicioEvento"></label></td>
							        <td><label id="dataFimEvento"></label></td>
							        <td><label id="idSituacaoEvento"></label></td>
							      </tr>							      
							    </tbody>
							  </table>
						</div>
					</div>
					
					<div class="col-sm-12 form-group" id="divMaxParcelas">
						<label>Parcelas</label>
						<select class="form-control select2" name="tipoInscricaoValor.maxParcelas" id="maxParcelas">
							<option value="">Selecione o numero de Parcelas</option>

						</select>						
					</div>
					
					<input type="hidden" id="idCliente2" name="idCliente2Cadastro">
					<input type="hidden" id="idTipoInscricaoValor" name="idTipoInscricaoValor">
					
					
				</div>

				<div class="box-footer">

					<button type="button" onclick="voltarEndereco()" class="btn btn-danger">Voltar</button>

					<button type="submit" class="btn btn-primary pull-right">Confirmar</button>

				</div>

			</g:formRemote>

		</div>
		

	</div>
	<!-- /.login-box -->

	<script type='text/javascript'>
		(function() {
			$(".select2").select2();

			$(".data").inputmask({
				alias : "dd/mm/yyyy",
				clearIncomplete : true
			});

			$("#cep").focusout(function () {
	            var cepVal = $("#cep").val();
	            
	            buscaCep(cepVal);
	        });
			
			document.forms['loginForm'].elements['usuario.username'].focus();
			$("#div_login").hide()
			$("#div_endereco").hide()
			//$("#div_inscricao").hide()
		})();

		function retornoCadastrarSalvar(data){

			$.notify(data.mensagem, data.type);
			if (data.type == "success") {
				console.log(data);
				$("#idCliente").val(data.id);
				$("#idCliente2").val(data.id);
				$("#id").val(data.id);
				

				$("#div_endereco").show()
				$("#div_login").hide()
			}
			
		}

		function retornoEnderecoSalvar(data){
			$.notify(data.mensagem, data.type);
			if (data.type == "success") {
				
				$("#div_endereco").hide()
				$("#div_inscricao").show()		
				$("#idEndereco").val(data.id);
				
			}
			
		}

		function voltarCadastro(){
		
			$("#div_endereco").hide()
			$("#div_login").show()
		
		}
		
		function voltarEndereco(){
		
			$("#div_inscricao").hide()
			$("#div_endereco").show()
		
		}
		
		function buscaCep(cepVal) {
	        
	        $.ajax({
	            method : "GET",
	            url : "http://api.postmon.com.br/v1/cep/" + cepVal,
	            data : {},
	            success : function(data) {
	                console.log(data);
	                
	                campos(data);
	            },
	            error : function(data) {
	             //   alert('erro: ' + data);
	            }
	        });
	          
	      }
	        
	        function campos(data) {
	            
	            $("#bairro").val(data.bairro);
	            
	            $("#cidade").val(data.cidade);
	            
	            $("#uf").val(data.estado).trigger("change");

	           // $("#uf").select2().select2('text',data.estado_info.nome);
	            
	            $("#rua").val(data.logradouro);

	            $("#numero").focus();
	            
	        }

	        function buscaDadosEventos(val){
				if (val){
			        $.ajax({
			    		method : "GET",
			    		url : "buscaDadosEventos",
			    		data : {
							'id': val,
							'idTipoInscricao': 4 //$('#tipoInscricao').val()
			    		},
			    		success : function(data) {
                            console.log(data);
                            console.log(data.evento.dataInicio);
                            $("#nameEvento").text(data.evento.nome);
                            $("#dataInicioEvento").text(data.evento.dataInicioDescricao);
                            $("#dataFimEvento").text(data.evento.dataFimDescricao);
                            $("#idSituacaoEvento").text(data.eventoSituacao);
                            $("#idTipoInscricaoValor").val(data.tipoInscricaoValor.id);
                            $("#tableDetalhesEvento").removeClass("hide");

                           // $("#divMaxParcelas").select2();
                           	var valor = data.tipoInscricaoValor.valor;
                           	
                            for (var i=1;i<=data.tipoInscricaoValor.maxParcelas;i++){
								var valorParcela = valor/i;
								var comboParcela = i+"X - Valor Parcela(s) R$"+valorParcela;
								$("#maxParcelas").append($("<option></option>").attr("value", i).text(comboParcela));

                            }
			    			
			    		},
			    		error : function(data) {
			    			console.log(data);
			    			
			    		}
			    	})
				}

        	}

	        function retornoInscricaoSalvar(data){
				$.notify(data.mensagem, data.type);
				if (data.type == "success") {

					window.location="${createLink(controller: 'login')}"; 
					
				}
				
			}

	</script>

</body>

</html>
