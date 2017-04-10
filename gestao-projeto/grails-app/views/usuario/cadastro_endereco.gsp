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
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="${createLink(uri: '/adminlte/dist/css/AdminLTE.min.css')}">

<!-- REQUIRED JS SCRIPTS -->

<!-- jQuery 2.1.4 -->
<script
	src="${createLink(uri: '/adminlte/plugins/jQuery/jQuery-2.1.4.min.js')}"></script>
<!-- Bootstrap 3.3.5 -->
<script
	src="${createLink(uri: '/adminlte/bootstrap/js/bootstrap.min.js')}"></script>

<style type="text/css">
	.login_message {
		padding-bottom: 0px;
		padding-top: 10px;
		padding-left: 10px;
		padding-right: 10px;
		color: #c33;
	}
</style>

</head>

<body class="hold-transition login-page">

	<div class="login-box">

		<div class="login-logo">
			<b>Disca</b>Inscrição
		</div>

		<div class="box box-primary">
			<div class="box-header with-border">
				<h3 class="box-title">Dados</h3>
			</div>


			<form  method='POST' id='loginForm'
				class='cssform' autocomplete='off'>

				<div class="box-body">

					<div class="col-sm-12 form-group">
						<label>Nome</label>
						<div class="input-group">
							<div class="input-group-addon">
								<i class="fa fa-laptop"></i>
							</div>
							<input type="text" class="form-control" name="usuario.username"
								required="required" id="username">
						</div>
					</div>
					
					<div class="col-sm-12 form-group">
						<label>E-mail</label>
						<div class="input-group">
							<div class="input-group-addon">
								<i class="fa fa-laptop"></i>
							</div>
							<input type="email" class="form-control" name="usuario.email"
								required="required" id="email">
						</div>
					</div>

					<div class="col-sm-12 form-group">
						<label>Senha</label>
						<div class="input-group">
							<div class="input-group-addon">
								<i class="fa fa-lock"></i>
							</div>
							<input type="password" class="form-control" name="usuario.password"
								required="required" id="password">
						</div>
					</div>
					
					<div class="col-sm-12 form-group">
						<label>Confirme a Senha</label>
						<div class="input-group">
							<div class="input-group-addon">
								<i class="fa fa-lock"></i>
							</div>
							<input type="password" class="form-control" name="usuario.password2"
								required="required" id="password2">
						</div>
					</div>
				</div>

				<div class="box-footer">

					<button type="reset" class="btn btn-danger">Cancelar</button>

					<button type="submit" class="btn btn-primary pull-right">Confirmar</button>

				</div>

			</form>

		</div>

	</div>
	<!-- /.login-box -->

	<script type='text/javascript'>
		(function() {
			document.forms['loginForm'].elements['usuario.username'].focus();
		})();
	</script>

</body>

</html>
