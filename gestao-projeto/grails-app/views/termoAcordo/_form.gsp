<div class="box box-primary">
	<div class="box-header with-border">
		<h3 class="box-title">
			${title}
		</h3>
	</div>
	<g:formRemote name="form" url="[action: 'salvar']"
		onSuccess="retornoSalvar(data)">

		<input type="hidden" name="termoAcordo.id"
			value="${termoAcordo?.id}">

		<input type="hidden" name="termoAcordo.version"
			value="${termoAcordo?.version}">

		<div class="box-body">

			<div class="col-sm-6 form-group" id="div_termo">
				<label>* Termo</label>
				<div class="input-group">
					<div class="input-group-addon">
						<i class="fa fa-laptop"></i>
					</div>
					<input type="text" class="form-control"
						name="termoAcordo.termo"
						<g:if test="${!editable}">disabled</g:if> id="termo"
						value="${termoAcordo?.termo}">
				</div>
			</div>
			
		<!--  	<div class="col-sm-6 form-group" id="div_descricao">
				<label>* Descrição</label>
				<div class="input-group">
					<div class="input-group-addon">
						<i class="fa fa-laptop"></i>
					</div>
					<input type="text" class="form-control"
						name="termoAcordo.descricao"
						<g:if test="${!editable}">disabled</g:if> id="descricao"
						value="${termoAcordo?.descricao}">
				</div>
			</div>-->
			
			<div class="col-sm-12 form-group" id="div_descricao">
					<label>* Descrição</label> 
				    <textarea rows="6" cols="" name="termoAcordo.descricao" id="descricao" maxlength="5000" class="form-control" required="required">${termoAcordo?.descricao}</textarea>
			</div>

		</div>
		<!-- /.box-body -->

		<div class="box-footer">

			<g:if test="${editable}">
				<button type="reset" class="btn btn-danger"
					onclick="javascript: cancelar()">Cancelar</button>

				<button type="submit" class="btn btn-primary pull-right">Salvar</button>
			</g:if>
			<g:else>
				<button type="reset" class="btn btn-primary pull-right"
					onclick="javascript: cancelar()">Voltar</button>
			</g:else>
		</div>
	</g:formRemote>
</div>
<!-- /.box -->

<!-- Page script -->
<script>
	$(document).ready(function() {

		$("#termo").focus();

	});
</script>
