<div class="box box-primary">
	<div class="box-header with-border">
		<h3 class="box-title">
			${title}
		</h3>
	</div>
	<g:formRemote name="form" url="[action: 'salvar']"
		onSuccess="retornoSalvar(data)">

		<input type="hidden" name="inscricaoParcelas.id"
			value="${inscricaoParcelas?.id}">

		<input type="hidden" name="inscricaoParcelas.version"
			value="${inscricaoParcelas?.version}">

		<div class="box-body">

			<div class="col-sm-6 form-group" id="div_parcelas">
				<label>* Numero Parcelas</label>
				<div class="input-group">
					<div class="input-group-addon">
						<i class="fa fa-laptop"></i>
					</div>
					<input type="text" class="form-control"
						name="inscricaoParcelas.parcelas"
						<g:if test="${!editable}">disabled</g:if> id="parcelas"
						value="${inscricaoParcelas?.numeroParcela}">
				</div>
			</div>
			
			<div class="col-sm-6 form-group" id="div_situacao">
				<label>* Situaçao da Parcela</label>
				<g:if test="${editable}">
					<select class="form-control select2" name="inscricaoParcelas.situacao">
						<option value="">Selecione a situação</option>
						<g:each
							in="${br.com.eventos.SituacaoParcela.createCriteria().list{ order('nome') }}"
							var="situacao">
							<g:if test="${inscricaoParcelas?.situacao?.id == situacao.id}">
								<option value="${situacao.id}" selected="selected">
									${situacao.nome}
								</option>
							</g:if>
							<g:else>
								<option value="${situacao.id}">
									${situacao.nome}
								</option>
							</g:else>
						</g:each>
					</select>
				</g:if>
				<g:else>
					<input type="text" class="form-control"
						value="${inscricaoParcelas?.situacao?.nome}" disabled>
				</g:else>
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

		$(".select2").select2();
		$("#nome").focus();

	});
</script>
