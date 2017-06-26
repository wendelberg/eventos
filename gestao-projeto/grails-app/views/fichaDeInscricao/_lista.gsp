<table id="tabela" class="table table-bordered table-striped">
	<thead>
		<tr>
			<th>Nome</th>
			<th style="width: 25px;">Ações</th>
		</tr>
	</thead>
	<g:each in="${lista}" var="eventos">
		<tr>
			<td>${eventos.evento.nome}</td>
			<td>
				<div class="btn-group btn-group-justified" role="group">
					<div class="btn-group" role="group">
						<a target="_blanck" href="ficha/${eventos.id}"><i class="fa fa-print" data-toggle="tooltip" title="Imprimir"></i></a>
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
