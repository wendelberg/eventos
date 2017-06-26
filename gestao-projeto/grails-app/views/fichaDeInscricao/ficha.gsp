<!DOCTYPE html>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.DecimalFormat"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ficha de Inscrição</title>
    
    <!-- Latest compiled and minified CSS 
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="ficha.css">-->
    <asset:stylesheet src="ficha.css"/>

</head>

<body class="col-sm-12" >
    
    <header>
        
        <div class="col-sm-4" align="center">
            <asset:image src="ficha.png"/>
        </div>
        
        <div class="col-sm-8" align="center">
            <h3><strong>PASSAPORTE  DISCA / JELB</strong></h3>
            <h4><strong>XXXVII Congresso de Jovens – Distrito Capixaba</strong></h4>
            <span>04 a 06 de Agosto de 2017 – Sítio Casa do Oleiro, Viana - ES</span><br>
            <span><strong>Tema: “Herdeiros da Reforma”</strong></span><br>
            <span><strong>Lema: </strong><em>"A igreja que fomos, que somos, e que queremos ser"</em></span><br>
            <p><em>Atos 17.28 - "pois nele vivemos, e nos movemos, e existimos, como alguns dos vossos poetas têm dito: Porque dele também somos geração."</em></p>
        </div>
        
    </header>
  
    <hr>
    
    <div class="col-sm-12">
        
        <div class="panel panel-default col-sm-12">
            <span><strong>Inscrição:</strong> ${eventoInscrito.evento.nome} - Nº ${eventoInscrito.id}</span><br>
            <span><strong>Nome Completo:</strong> ${eventoInscrito.inscrito.nome}</span><br>
            <span><strong>Data Nascimento:</strong> ${eventoInscrito.inscrito.nascimento}</span><br>
            <span><strong>Telefone/Celular:</strong> </span><br>
            <span><strong>E-mail:</strong> ${eventoInscrito.inscrito.email}</span><br>
            <span><strong>União Juvenil:</strong> ${eventoInscrito.inscrito.juventude.nome}</span><br>
            <span><strong>Valor da Inscrição:</strong> ${NumberFormat.getCurrencyInstance(new Locale('pt', 'BR')).format(eventoInscrito.valor.valor)}</span><br> 
        </div>
        
      <hr>  
      
      <div class="panel panel-default col-sm-12">
            
            <div class="col-sm-12">
                <span><strong>TERMO DE COMPROMISSO</strong></span>
                <ul>
                    <li>Participar em todas as atividades do congresso, especialmente das programações em plenárias, sejam momentos de louvor, palestras e administrativo. Entendo que o lazer no congresso é importante, porém é secundário;</li>
                    <li>Dar bons exemplos aos congressistas e demais membros da sociedade;</li>
                    <li>Não desobedecer às regras pré-estabelecidas pela organização do Congresso;</li>
                    <li>Não consumir bebida alcoólica;</li>
                    <li>Não fazer uso da área de jogos e piscina em horário fora do permitido;</li>
                    <li>Aceitar devida advertência e punição em caso de desobediência às regras.</li>
                </ul>        
            </div>

            <div class="col-sm-12">
                <span><strong>OBJETIVOS</strong></span>
                <ul>
                    <li>Crescer no conhecimento da palavra de Deus;</li>
                    <li>Conviver em comunhão com os irmãos em cristo;</li>
                    <li>Compartilhar experiências no trabalho da igreja;</li>
                    <li>Usufruir lazer e diversão sadia.</li>
                </ul>
            </div>

            <div class="col-sm-12">
                <span><strong>Observação:</strong> Estou ciente que o não cumprimento de alguma destas regras implicará em uma advertência por parte da diretoria e se necessário o desligamento do Congresso. </span> 
            </div>
            
        </div>

      
      <hr>
        
        <div class="col-sm-12 assinatura">
            <div class="col-sm-4 campo" align="center">
                <!--<p>_________________________________</p>-->
                <p>Jovem</p>
            </div>
            <div class="col-sm-4 campo" align="center">
                <!--<p>_________________________________</p>-->
                <span>Responsável</span><br>
                <span>(caso menor de 18 anos)</span><br>
            </div>
            <div class="col-sm-4 campo" align="center">
                <!--<p>_________________________________</p>-->
                <p>Pastor Responsável</p>            
            </div>
        </div> 
        
        <footer align="center">
             <p><em>Este passaporte deverá ser entregue <strong>assinado pelo jovem e/ou responsável e pelo pastor </strong>no ato do credenciamento no local do congresso,<u>juntamente do comprovante de depósito.</u></em></p>
        </footer>
        
    </div>
    

</body>

</html>