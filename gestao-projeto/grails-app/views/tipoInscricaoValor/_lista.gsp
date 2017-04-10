<%@page import="java.text.SimpleDateFormat"%>

<table id="tabela" class="table table-bordered table-striped">
	<thead>
		<tr>
		 	<th>Tipo Inscrição</th> 
			<th>Valor</th>
			<th>Data Inicio Vigência</th>
			<th>Data Fim Vigência</th>
			<th>Máximo de Parcelas</th>
			<th style="width: 75px;">Ações</th>
		</tr>
	</thead>
	<g:each in="${lista}" var="tipoInscricaoValor">
		<tr>
		 	<td>${tipoInscricaoValor.tipoInscricao.nome}</td>
			<td>${tipoInscricaoValor.valor}</td>
			<td>${new SimpleDateFormat('dd/MM/yyyy').format(tipoInscricaoValor.dataInicioVigencia)}</td>
			<td>${new SimpleDateFormat('dd/MM/yyyy').format(tipoInscricaoValor.dataFimVigencia)}</td>
			<td>${tipoInscricaoValor.maxParcelas}</td>
			<td>
				<div class="btn-group btn-group-justified" role="group">
					<div class="btn-group" role="group">
						<a href="javascript: visualizar(${tipoInscricaoValor.id})"><i class="fa fa-eye" data-toggle="tooltip" title="Visualizar"></i></a>
					</div>
					<div class="btn-group" role="group">
						<a href="javascript: alterar(${tipoInscricaoValor.id})"><i class="fa fa-pencil" data-toggle="tooltip" title="Alterar"></i></a>
					</div>
					<div class="btn-group" role="group">
						<a href="javascript: excluir(${tipoInscricaoValor.id})"><i class="fa fa-minus-circle" data-toggle="tooltip" title="Excluir"></i></a>
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
</script>
