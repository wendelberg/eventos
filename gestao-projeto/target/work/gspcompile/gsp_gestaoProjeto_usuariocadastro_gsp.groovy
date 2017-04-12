import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_gestaoProjeto_usuariocadastro_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/usuario/cadastro.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'charset':("utf-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'content':("width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"),'name':("viewport")],-1)
printHtmlPart(4)
expressionOut.print(createLink(uri: '/adminlte/plugins/reset/html5-reset.css'))
printHtmlPart(5)
expressionOut.print(createLink(uri: '/adminlte/bootstrap/css/bootstrap.min.css'))
printHtmlPart(6)
expressionOut.print(createLink(uri: '/adminlte/plugins/select2/select2.min.css'))
printHtmlPart(7)
expressionOut.print(createLink(uri: '/adminlte/plugins/confirm/jquery-confirm.min.css'))
printHtmlPart(8)
expressionOut.print(createLink(uri: '/adminlte/dist/css/AdminLTE.min.css'))
printHtmlPart(9)
expressionOut.print(createLink(uri: '/adminlte/dist/css/skins/skin-blue.min.css'))
printHtmlPart(10)
expressionOut.print(createLink(uri: '/adminlte/plugins/jQuery/jQuery-2.1.4.min.js'))
printHtmlPart(11)
expressionOut.print(createLink(uri: '/adminlte/plugins/jQueryUI/jquery-ui.min.js'))
printHtmlPart(12)
expressionOut.print(createLink(uri: '/adminlte/bootstrap/js/bootstrap.min.js'))
printHtmlPart(13)
expressionOut.print(createLink(uri: '/adminlte/dist/js/app.min.js'))
printHtmlPart(14)
expressionOut.print(createLink(uri: '/adminlte/plugins/notify/notify.js'))
printHtmlPart(15)
expressionOut.print(createLink(uri: '/adminlte/plugins/select2/select2.full.min.js'))
printHtmlPart(16)
expressionOut.print(createLink(uri: '/adminlte/plugins/input-mask/jquery.inputmask.bundle.js'))
printHtmlPart(17)
expressionOut.print(createLink(uri: '/adminlte/plugins/input-mask/jquery.price_format.2.0.min.js'))
printHtmlPart(18)
})
invokeTag('captureHead','sitemesh',64,[:],1)
printHtmlPart(19)
createTagBody(1, {->
printHtmlPart(20)
createTagBody(2, {->
printHtmlPart(21)
for( uj in (br.com.eventos.UniaoJuvenil.createCriteria().list{ order('nome') }) ) {
printHtmlPart(22)
expressionOut.print(uj.id)
printHtmlPart(23)
expressionOut.print(uj.nome)
printHtmlPart(24)
}
printHtmlPart(25)
for( tipoInscricao in (br.com.eventos.TipoInscricao.createCriteria().list{ order('nome') }) ) {
printHtmlPart(22)
expressionOut.print(tipoInscricao.id)
printHtmlPart(23)
expressionOut.print(tipoInscricao.nome)
printHtmlPart(24)
}
printHtmlPart(26)
})
invokeTag('formRemote','g',228,['id':("loginForm"),'url':([action: 'cadastrarSalvar']),'class':("cssform"),'autocomplete':("off"),'name':("loginForm"),'onSuccess':("retornoCadastrarSalvar(data)")],2)
printHtmlPart(27)
createTagBody(2, {->
printHtmlPart(28)
for( estado in (br.com.eventos.Estado.createCriteria().list{ order('nome') }) ) {
printHtmlPart(22)
expressionOut.print(estado.sigla)
printHtmlPart(23)
expressionOut.print(estado.nome)
printHtmlPart(24)
}
printHtmlPart(29)
})
invokeTag('formRemote','g',360,['id':("enderecoForm"),'url':([action: 'enderecoSalvar']),'class':("cssform"),'autocomplete':("off"),'name':("enderecoForm"),'onSuccess':("retornoEnderecoSalvar(data)")],2)
printHtmlPart(30)
createTagBody(2, {->
printHtmlPart(31)
for( evento in (br.com.eventos.Evento.createCriteria().list{ 
										eq('situacao.id', 1l )
										order('nome') 
									}) ) {
printHtmlPart(22)
expressionOut.print(evento.id)
printHtmlPart(23)
expressionOut.print(evento.nome)
printHtmlPart(24)
}
printHtmlPart(32)
})
invokeTag('formRemote','g',438,['id':("inscricaoForm"),'url':([action: 'inscricaoSalvar']),'class':("cssform"),'autocomplete':("off"),'name':("inscricaoForm"),'onSuccess':("retornoInscricaoSalvar(data)")],2)
printHtmlPart(33)
expressionOut.print(createLink(controller: 'login'))
printHtmlPart(34)
})
invokeTag('captureBody','sitemesh',585,['class':("hold-transition login-page")],1)
printHtmlPart(35)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1492037304696L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
