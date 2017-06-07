<!DOCTYPE html>
<%@page import="java.text.SimpleDateFormat"%>
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

<!-- Adicionado por mim-->
<link rel="stylesheet"
	href="${createLink(uri: '/adminlte/bootstrap/css/bootstrap.min.css')}">
<!-- Custom CSS -->
<asset:stylesheet src="institucional.css" />

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

	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>

			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="${createLink(uri:'/')}">Home</a></li>
					<li><a href="https://www.facebook.com/sitiocasadooleiro/">Sobre	o Local</a></li>
					<li><a href="http://www.disca.com.br/contato/">Contato</a></li>
					<li><a href="${createLink(controller: 'usuario',action:'listarInscritos')}">Lista de Inscritos</a></li>
					<li><a href="${createLink(controller: 'login')}">Login</a></li>
					<li><a
						href="${createLink(controller: 'usuario',action:'cadastrar')}">Inscreva-se</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>

	<div class="container">

		<div class="login-logo">
		</div>
		
		<div class="box box-primary" id="div_dadosInscricao">
			<div class="box-header with-border">
				<h3 class="box-title">Lista de Inscritos</h3>
			</div>
				
			<div class="box-body">
				
				<div class="col-sm-12 form-group" id="tableDetalhesInscritos">
					<div class="container col-sm-12 form-group" >
					 <table class="table table-hover">
					    <thead>
					      <tr>
					        <th>ID</th>
					        <th>Nome</th>
					        <th>Sexo</th>
					        <th>União Juvenil</th>
					        <th>Estado Civil</th>
					        <th>Data Inscrição</th>
					      </tr>
					    </thead>
					    <tbody>
					    <g:each var = "item" in="${list}"  >
					      <tr>
					        <td>${item.id}</td>
					        <td>${item.nome}</td>
					        <td>${item.sexo}</td>
					        <td>${item.uj}</td>
					        <td>${item.estadoCivil}</td>
					        <td>${new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format( item.dataInscricao )}</td>
					      </tr>						
					    </g:each>	      
					    </tbody>
					  </table>
					</div>
				</div>
			</div>
		

		</div>
	<!-- Footer -->
	<footer>
		<div class="row">
			<div class="col-lg-12">
				<p>&copy; DISCA 2017 - Todos os Direitos Reservados</p>
			</div>
		</div>
		<!-- /.row -->
	</footer>

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

		
		
 	</script>


</body>
</html>
