<table id="tabela" class="table table-bordered table-striped">
	<thead>
		<tr>
			<th>Nome</th>
			<th>Sexo</th>
			<th>UJ</th>
			<th>Estado Civil</th>
			<th>Data da Inscrição</th>
			<th>Situação da Inscrição</th>
			<th>Situação da Ficha</th>
			<th style="width: 25px;">Ações</th>
		</tr>
	</thead>
	<g:each in="${lista}" var="inscrito">
		<tr>
			<td>${inscrito.nome}</td>
			<td>${inscrito.sexo}</td>
			<td>${inscrito.uj}</td>
			<td>${inscrito.estadoCivil}</td>
			<td>${inscrito.dataInscricao}</td>
			<td>${inscrito.situacaoInscricao}</td>
			<td>${inscrito.fichaDeInscricao}</td>
			<td>
				<div class="btn-group btn-group-justified" role="group">
					<div class="btn-group" role="group">
						<a href="javascript: liberar(${inscrito.id})"><i class="fa fa-file-text" data-toggle="tooltip" title="Liberar/Bloquear"></i></a>
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

		$(".data").inputmask({
			alias : "dd/mm/yyyy",
			clearIncomplete : true
		});
		
	});

	function liberar(id) {
		$.ajax({
			method : "POST",
			url : "liberar",
			data : {
				"id" : id
			},
			success : function(data) {
				$.notify(data.mensagem, data.type);
				carregarLista()
				
			},
			error : function(data) {
				retornoErro(data)
			}
		})
	}
	
</script>
