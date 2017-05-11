<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Lista de Inscritos</title>
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
		
		<div class="box box-primary" id="div_dadosInscricao">
			<div class="box-header with-border">
				<h3 class="box-title">Dados da Inscrição</h3>
			</div>
				
				<div class="box-body">
					
					<div class="col-sm-12 form-group hide" id="tableDetalhesInscritos">
						<label>Dados dos Inscritos</label>
						<div class="container col-sm-12 form-group" >
							 <table class="table table-hover">
							    <thead>
							      <tr>
							        <th>ID</th>
							        <th>Nome</th>
							        <th>Sexo</th>
							        <th>União Juvenil</th>
							        <th>Data Nascimento</th>
							        <th>Estado Civil</th>
							        <th>Data Inscrição</th>
							      </tr>
							    </thead>
							    <tbody>
							      <tr>
							        <td><label id="idInscrito"></label></td>
							        <td><label id="nomeInscrito"></label></td>
							        <td><label id="sexoInscrito"></label></td>
							        <td><label id="uniaoJuvenil"></label></td>
							        <td><label id="dataNascimento" class="form-control data"></label></td>
							        <td><label id="estadoCivil"></label></td>
							        <td><label id="dataInscricao"></label></td>
							      </tr>							      
							    </tbody>
							  </table>
						</div>
					</div>
		</div>
		

	</div>
	<!-- /.login-box -->
		<script type="text/javascript">
		(function() {
			$(".select2").select2();

			$(".data").inputmask({
				alias : "dd/mm/yyyy",
				clearIncomplete : true
			});

		})();

		
        function buscaDadosEventos(val){
        	
			if (val){
		        $.ajax({
		    		method : "GET",
		    		url : "buscaDadosEventos",
		    		data : {
						'id': val,
						'idTipoInscricao': $('#tipoInscricao').val()
		    		},
		    		success : function(data) {
                        $("#nameEvento").text(data.evento.nome);
                        $("#dataInicioEvento").text(data.evento.dataInicioDescricao);
                        $("#dataFimEvento").text(data.evento.dataFimDescricao);
                        $("#idSituacaoEvento").text(data.eventoSituacao);
                        $("#idTipoInscricaoValor").val(data.tipoInscricaoValor.id);
                        $("#tableDetalhesEvento").removeClass("hide");


                       	var valor = data.tipoInscricaoValor.valor;
                        
                        $("#maxParcelas").empty();
						$("#maxParcelas").find('option').remove().end().append('<option value="0">Selecione a Quantidade de Parcelas</option>')
						$("#maxParcelas").select2("val", ""); 	
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

       	};

 	</script>


</body>
</html>
