<div class="box box-primary">
	<div class="box-header with-border">
		<h3 class="box-title">
			${title}
		</h3>
	</div>
	<g:formRemote name="form" url="[action: 'salvar']"
		onSuccess="retornoSalvar(data)">

		<input type="hidden" name="endereco.id"
			value="${endereco?.id}">

		<input type="hidden" name="endereco.version"
			value="${endereco?.version}">

		<div class="box-body">

			<div class="col-sm-6 form-group" id="div_nome">
				<label>* Nome</label>
				<div class="input-group">
					<div class="input-group-addon">
						<i class="fa fa-laptop"></i>
					</div>
					<input type="text" class="form-control"
						name="endereco.nome"
						<g:if test="${!editable}">disabled</g:if> id="nome"
						value="${endereco?.nome}">
				</div>
			</div>
			<div class="col-sm-6 form-group" id="div_rua">
				<label>* Rua</label>
				<div class="input-group">
					<div class="input-group-addon">
						<i class="fa fa-laptop"></i>
					</div>
					<input type="text" class="form-control"
						name="endereco.rua"
						<g:if test="${!editable}">disabled</g:if> id="rua"
						value="${endereco.rua}">
				</div>
			</div>
            <div class="col-sm-6 form-group" id="div_bairro">
				<label>* Bairro</label>
				<div class="input-group">
					<div class="input-group-addon">
						<i class="fa fa-laptop"></i>
					</div>
					<input type="text" class="form-control"
						name="endereco.bairro"
						<g:if test="${!editable}">disabled</g:if> id="bairro"
						value="${endereco.bairro}">
				</div>
			</div>
			<div class="col-sm-6 form-group" id="div_cidade">
				<label>* Cidade</label>
				<div class="input-group">
					<div class="input-group-addon">
						<i class="fa fa-laptop"></i>
					</div>
					<input type="text" class="form-control"
						name="endereco.cidade"
						<g:if test="${!editable}">disabled</g:if> id="cidade"
						value="${endereco.cidade}">
				</div>
			</div>
			<div class="col-sm-6 form-group" id="div_uf">
				<label>* UF</label>
				<g:if test="${editable}">
					<select class="form-control select2" name="endereco.uf" id="uf">
						<option value="">Selecione o Estado</option>
						<g:each
							in="${br.com.eventos.Estado.createCriteria().list{ order('nome') }}"
							var="estado">
							<g:if test="${endereco?.uf?.id == estado.id}">
								<option value="${estado.sigla}" selected="selected">
									${estado.nome}
								</option>
							</g:if>
							<g:else>
								<option value="${estado.sigla}">
									${estado.nome}
								</option>
							</g:else>
						</g:each>
					</select>
				</g:if>
				<g:else>
					<input type="text" class="form-control"
						value="${endereco?.uf?.nome}" disabled>
				</g:else>
			</div>
			<div class="col-sm-6 form-group" id="div_cep">
				<label>* CEP</label>
				<div class="input-group">
					<div class="input-group-addon">
						<i class="fa fa-laptop"></i>
					</div>
					<input type="text" class="form-control"
						name="endereco.cep"
						<g:if test="${!editable}">disabled</g:if> id="cep"
						value="${endereco.cep}">
				</div>
			</div>
			<div class="col-sm-6 form-group" id="div_numero">
				<label>* Numero</label>
				<div class="input-group">
					<div class="input-group-addon">
						<i class="fa fa-laptop"></i>
					</div>
					<input type="text" class="form-control"
						name="endereco.numero"
						<g:if test="${!editable}">disabled</g:if> id="numero"
						value="${endereco.numero}">
				</div>
			</div>
			<div class="col-sm-6 form-group" id="div_pontoReferencia">
				<label>* Ponto de Referência</label>
				<div class="input-group">
					<div class="input-group-addon">
						<i class="fa fa-laptop"></i>
					</div>
					<input type="text" class="form-control"
						name="endereco.pontoReferencia"
						<g:if test="${!editable}">disabled</g:if> id="pontoReferencia"
						value="${endereco.pontoReferencia}">
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

		$("#nome").focus();

		$("#cep").focusout(function () {
            var cepVal = $("#cep").val();
            
            buscaCep(cepVal);
        });

	});

    function buscaCep(cepVal) {
        
        $.ajax({
            method : "GET",
            url : "http://api.postmon.com.br/v1/cep/" + cepVal,
            data : {},
            success : function(data) {
                console.log(data);
                
                campos(data);
            },
            error : function(data) {
             //   alert('erro: ' + data);
            }
        });
          
      }
        
        function campos(data) {
            
            $("#bairro").val(data.bairro);
            
            $("#cidade").val(data.cidade);
            
            $("#uf").val(data.estado).trigger("change");

           // $("#uf").select2().select2('text',data.estado_info.nome);
            
            $("#rua").val(data.logradouro);
            
        }
</script>