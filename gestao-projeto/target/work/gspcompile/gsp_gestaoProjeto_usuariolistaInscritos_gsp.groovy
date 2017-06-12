import java.text.SimpleDateFormat
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_gestaoProjeto_usuariolistaInscritos_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/usuario/listaInscritos.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'charset':("utf-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(4)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':(""),'content':("width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"),'name':("viewport")],-1)
printHtmlPart(5)
expressionOut.print(createLink(uri: '/adminlte/plugins/reset/html5-reset.css'))
printHtmlPart(6)
expressionOut.print(createLink(uri: '/adminlte/bootstrap/css/bootstrap.min.css'))
printHtmlPart(7)
expressionOut.print(createLink(uri: '/adminlte/plugins/select2/select2.min.css'))
printHtmlPart(8)
expressionOut.print(createLink(uri: '/adminlte/plugins/confirm/jquery-confirm.min.css'))
printHtmlPart(9)
expressionOut.print(createLink(uri: '/adminlte/dist/css/AdminLTE.min.css'))
printHtmlPart(10)
expressionOut.print(createLink(uri: '/adminlte/dist/css/skins/skin-blue.min.css'))
printHtmlPart(11)
expressionOut.print(createLink(uri: '/adminlte/bootstrap/css/bootstrap.min.css'))
printHtmlPart(12)
invokeTag('stylesheet','asset',42,['src':("institucional.css")],-1)
printHtmlPart(13)
expressionOut.print(createLink(uri: '/adminlte/plugins/jQuery/jQuery-2.1.4.min.js'))
printHtmlPart(14)
expressionOut.print(createLink(uri: '/adminlte/plugins/jQueryUI/jquery-ui.min.js'))
printHtmlPart(15)
expressionOut.print(createLink(uri: '/adminlte/bootstrap/js/bootstrap.min.js'))
printHtmlPart(16)
expressionOut.print(createLink(uri: '/adminlte/dist/js/app.min.js'))
printHtmlPart(17)
expressionOut.print(createLink(uri: '/adminlte/plugins/notify/notify.js'))
printHtmlPart(18)
expressionOut.print(createLink(uri: '/adminlte/plugins/select2/select2.full.min.js'))
printHtmlPart(19)
expressionOut.print(createLink(uri: '/adminlte/plugins/input-mask/jquery.inputmask.bundle.js'))
printHtmlPart(20)
expressionOut.print(createLink(uri: '/adminlte/plugins/input-mask/jquery.price_format.2.0.min.js'))
printHtmlPart(21)
})
invokeTag('captureHead','sitemesh',71,[:],1)
printHtmlPart(22)
createTagBody(1, {->
printHtmlPart(23)
expressionOut.print(createLink(uri:'/'))
printHtmlPart(24)
expressionOut.print(createLink(controller: 'usuario',action:'listarInscritos'))
printHtmlPart(25)
expressionOut.print(createLink(controller: 'login'))
printHtmlPart(26)
expressionOut.print(createLink(controller: 'usuario',action:'cadastrar'))
printHtmlPart(27)
for( item in (list) ) {
printHtmlPart(28)
expressionOut.print(item.id)
printHtmlPart(29)
expressionOut.print(item.nome)
printHtmlPart(29)
expressionOut.print(item.sexo)
printHtmlPart(29)
expressionOut.print(item.uj)
printHtmlPart(29)
expressionOut.print(item.estadoCivil)
printHtmlPart(29)
expressionOut.print(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format( item.dataInscricao ))
printHtmlPart(30)
}
printHtmlPart(31)
})
invokeTag('captureBody','sitemesh',179,['class':("hold-transition login-page")],1)
printHtmlPart(32)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1496850717099L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
