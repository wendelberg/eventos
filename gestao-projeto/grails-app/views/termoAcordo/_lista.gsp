<table id="tabela" class="table table-bordered table-striped">
	<thead>
		<tr>
			<th style="width: 200px;">Termo</th>
			<th>Descrição</th>
			<th style="width: 75px;">Ações</th>
		</tr>
	</thead>
	<g:each in="${lista}" var="termoAcordo">
		<tr>
			<td>${termoAcordo.termo}</td>
			<td>${termoAcordo.descricao}</td>
			<td>
				<div class="btn-group btn-group-justified" role="group">
					<div class="btn-group" role="group">
						<a href="javascript: visualizar(${termoAcordo.id})"><i class="fa fa-eye" data-toggle="tooltip" title="Visualizar"></i></a>
					</div>
					<div class="btn-group" role="group">
						<a href="javascript: alterar(${termoAcordo.id})"><i class="fa fa-pencil" data-toggle="tooltip" title="Alterar"></i></a>
					</div>
					<div class="btn-group" role="group">
						<a href="javascript: excluir(${termoAcordo.id})"><i class="fa fa-minus-circle" data-toggle="tooltip" title="Excluir"></i></a>
					</div>
				</div>
			</td>
		</tr>
	</g:each>
</table>
<script>
	$(function() {

		$('#tabela').DataTable();

	});
</script>
