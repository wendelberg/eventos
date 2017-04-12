<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.SimpleDateFormat"%>

<!-- jQuery jquery.maskMoney -->
<script
	src="${createLink(uri: '/adminlte/plugins/jQuery/jquery.maskMoney.js')}"></script>

		
<table id="tabela" class="table table-bordered table-striped">
	<thead>
		<tr>
		
			<th>Numero da Parcela</th>
			<th>Data de Vencimento</th>
			<th>Valor da Parcela</th>
			<th>Situação</th>
			<th style="width: 75px;">Ações</th>
		</tr>
	</thead>
	<g:each in="${lista}" var="inscricaoParcelas">
		<tr>
			
			<td>${inscricaoParcelas.numeroParcela}</td>
			<td>${new SimpleDateFormat('dd/MM/yyyy').format(inscricaoParcelas.dataVencimento)}</td>
			<td>${new DecimalFormat('#0.00').format(inscricaoParcelas.valorParcela)}</td>
			<td>${inscricaoParcelas.situacao.nome}</td>
			<td>
				<div class="btn-group btn-group-justified" role="group">
					<div class="btn-group" role="group">
						<a href="javascript: visualizar(${inscricaoParcelas.id})"><i class="fa fa-eye" data-toggle="tooltip" title="Visualizar"></i></a>
					</div>
					<div class="btn-group" role="group">
						<a href="javascript: alterar(${inscricaoParcelas.id})"><i class="fa fa-pencil" data-toggle="tooltip" title="Alterar"></i></a>
					</div>
					<div class="btn-group" role="group">
						<a href="javascript: excluir(${inscricaoParcelas.id})"><i class="fa fa-minus-circle" data-toggle="tooltip" title="Excluir"></i></a>
					</div>
				</div>
			</td>
		</tr>
	</g:each>
</table>
<!-- page script -->
<script>
	$(function() {

		$('#tabela').DataTable();

	});

	$(document).ready(function(){
   	    $("dinheiro").maskMoney({showSymbol:true, symbol:"R$", decimal:",", thousands:"."});
  	});
	
</script>