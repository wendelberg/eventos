<%@page import="java.text.SimpleDateFormat"%>
<div class="box box-primary">
	<div class="box-header with-border">
		<h3 class="box-title">
			${title}
		</h3>
	</div>
	<g:formRemote name="form" url="[action: 'salvar']"
		onSuccess="retornoSalvar(data)">

		<input type="hidden" name="evento.id"
			value="${evento?.id}">

		<input type="hidden" name="evento.version"
			value="${evento?.version}">

		<div class="box-body">

			<div class="col-sm-6 form-group" id="div_nome">
				<label>* Nome</label>
				<div class="input-group">
					<div class="input-group-addon">
						<i class="fa fa-laptop"></i>
					</div>
					<input type="text" class="form-control"
						name="evento.nome"
						<g:if test="${!editable}">disabled</g:if> id="nome"
						value="${evento?.nome}">
				</div>
			</div>
			
			<div class="col-sm-6 form-group" id="div_dataInicio">
				<label>* Data Inicio</label>
				<div class="input-group">
					<div class="input-group-addon">
						<i class="fa fa-laptop"></i>
					</div>
					<input type="text" class="form-control data"
						name="evento.dataIncio"
						<g:if test="${!editable}">disabled</g:if> id="dataInicio"
						value="${new SimpleDateFormat('dd/MM/yyyy').format( evento?.dataIncio)}">
				</div>
			</div>
			
			<div class="col-sm-6 form-group" id="div_dataFim">
				<label>* Data Fim</label>
				<div class="input-group">
					<div class="input-group-addon">
						<i class="fa fa-laptop"></i>
					</div>
					<input type="text" class="form-control data"
						name="evento.dataFim"
						<g:if test="${!editable}">disabled</g:if> id="dataFim"
						value="${new SimpleDateFormat('dd/MM/yyyy').format(evento?.dataFim)}">
				</div>
			</div>
			
			<div class="col-sm-6 form-group" id="div_situacao">
				<label>* Situação Evento</label>
				<g:if test="${editable}">
					<select class="form-control select2" name="tipoInscricaoValor.tipoInscricao">
						<option value="">Selecione a situação do Evento</option>
						<g:each
							in="${br.com.eventos.EventoSituacao.createCriteria().list{ order('nome') }}"
							var="eventoSituacao">
							<g:if test="${evento?.EventoSituacao?.id == EventoSituacao.id}">
								<option value="${EventoSituacao.id}" selected="selected">
									${EventoSituacao.nome}
								</option>
							</g:if>
							<g:else>
								<option value="${EventoSituacao.id}">
									${EventoSituacao.nome}
								</option>
							</g:else>
						</g:each>
					</select>
				</g:if>
				<g:else>
					<input type="text" class="form-control"
						value="${evento?.EventoSituacao?.nome}" disabled>
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

		//$("#nome").focus();

		$(".data").inputmask({
			alias : "dd/mm/yyyy",
			clearIncomplete : true
		});

	});
</script>
