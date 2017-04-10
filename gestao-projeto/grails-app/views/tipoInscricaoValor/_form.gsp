<%@page import="java.text.SimpleDateFormat"%>

<div class="box box-primary">
	<div class="box-header with-border">
		<h3 class="box-title">
			${title}
		</h3>
	</div>
	<g:formRemote name="form" url="[action: 'salvar']"
		onSuccess="retornoSalvar(data)">

		<input type="hidden" name="tipoInscricaoValor.id"
			value="${tipoInscricaoValor?.id}">

		<input type="hidden" name="tipoInscricaoValor.version"
			value="${tipoInscricaoValor?.version}">

		<div class="box-body">

			<div class="col-sm-6 form-group" id="div_tipoInscricao">
				<label>* Tipo Inscrição</label>
				<g:if test="${editable}">
					<select class="form-control select2" name="tipoInscricaoValor.tipoInscricao">
						<option value="">Selecione o Tipo de Inscrição</option>
						<g:each
							in="${br.com.eventos.TipoInscricao.createCriteria().list{ order('nome') }}"
							var="tipoInscricao">
							<g:if test="${tipoInscricaoValor?.tipoInscricao?.id == tipoInscricao.id}">
								<option value="${tipoInscricao.id}" selected="selected">
									${tipoInscricao.nome}
								</option>
							</g:if>
							<g:else>
								<option value="${tipoInscricao.id}">
									${tipoInscricao.nome}
								</option>
							</g:else>
						</g:each>
					</select>
				</g:if>
				<g:else>
					<input type="text" class="form-control"
						value="${tipoInscricaoValor?.tipoInscricao?.nome}" disabled>
				</g:else>
			</div>
			
			<div class="col-sm-6 form-group" id="div_valor">
				<label>* Valor</label>
				<div class="input-group">
					<div class="input-group-addon">
						<i class="fa fa-laptop"></i>
					</div>
					<input type="number" step="0.01" min="0" class="form-control"
						name="tipoInscricaoValor.valor"
						<g:if test="${!editable}">disabled</g:if> id="valor"
						value="${tipoInscricaoValor?.valor}">
				</div>
			</div>
			
			
			<div class="col-sm-6 form-group" id="div_dataInicioVigencia">
				<label>* Data Inicio Vigência</label>
				<div class="input-group">
					<div class="input-group-addon">
						<i class="fa fa-laptop"></i>
					</div>
					<input type="text" class="form-control data"
						name="tipoInscricaoValor.dataInicioVigencia"
						<g:if test="${!editable}">disabled</g:if> id="dataInicioVigencia"
						value="${new SimpleDateFormat('dd/MM/yyyy').format( tipoInscricaoValor?.dataInicioVigencia)}">
				</div>
			</div>
			
			<div class="col-sm-6 form-group" id="div_dataFimVigencia">
				<label>* Data Fim Vigência</label>
				<div class="input-group">
					<div class="input-group-addon">
						<i class="fa fa-laptop"></i>
					</div>
					<input type="text" class="form-control data"
						name="tipoInscricaoValor.dataFimVigencia"
						<g:if test="${!editable}">disabled</g:if> id="dataFimVigencia"
						value="${new SimpleDateFormat('dd/MM/yyyy').format(tipoInscricaoValor?.dataFimVigencia)}">
				</div>
			</div>
			
			<div class="col-sm-6 form-group" id="div_maxParcelas">
				<label>* Máximo de Parcelas</label>
				<div class="input-group">
					<div class="input-group-addon">
						<i class="fa fa-laptop"></i>
					</div>
					<input type="text" class="form-control"
						name="tipoInscricaoValor.maxParcelas"
						<g:if test="${!editable}">disabled</g:if> id="maxParcelas"
						value="${tipoInscricaoValor?.maxParcelas}">
				</div>
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
		
		<!--	$("#nome").focus();-->

		$(".data").inputmask({
			alias : "dd/mm/yyyy",
			clearIncomplete : true
		});



	});
</script>
