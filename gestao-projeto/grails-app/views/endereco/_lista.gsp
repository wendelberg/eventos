<table id="tabela" class="table table-bordered table-striped">
	<thead>
		<tr>
			<th>Nome</th>
			<th>Rua</th>
			<th>Bairro</th>
			<th>Cidade</th>
			<th>UF</th>
			<th>CEP</th>
			<th>Numero</th>
			<th>Ponto de Referência</th>
			<th style="width: 75px;">Ações</th>
		</tr>
	</thead>
	<g:each in="${lista}" var="endereco">
		<tr>
			<td>${endereco.nome}</td>
			<td>${endereco.rua}</td>
            <td>${endereco.bairro}</td>
			<td>${endereco.cidade}</td>
			<td>${endereco.uf.sigla}</td>
			<td>${endereco.cep}</td>
			<td>${endereco.numero}</td>
			<td>${endereco.pontoReferencia}</td>
			<td>
				<div class="btn-group btn-group-justified" role="group">
					<div class="btn-group" role="group">
						<a href="javascript: visualizar(${endereco.id})"><i class="fa fa-eye" data-toggle="tooltip" title="Visualizar"></i></a>
					</div>
					<div class="btn-group" role="group">
						<a href="javascript: alterar(${endereco.id})"><i class="fa fa-pencil" data-toggle="tooltip" title="Alterar"></i></a>
					</div>
					<div class="btn-group" role="group">
						<a href="javascript: excluir(${endereco.id})"><i class="fa fa-minus-circle" data-toggle="tooltip" title="Excluir"></i></a>
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