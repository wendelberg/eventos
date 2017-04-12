import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_gestaoProjeto_usuariocadastro_endereco_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/usuario/cadastro_endereco.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',3,['gsp_sm_xmlClosingForEmptyTag':(""),'charset':("utf-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'content':("width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"),'name':("viewport")],-1)
printHtmlPart(4)
expressionOut.print(createLink(uri: '/adminlte/plugins/reset/html5-reset.css'))
printHtmlPart(5)
expressionOut.print(createLink(uri: '/adminlte/bootstrap/css/bootstrap.min.css'))
printHtmlPart(6)
expressionOut.print(createLink(uri: '/adminlte/dist/css/AdminLTE.min.css'))
printHtmlPart(7)
expressionOut.print(createLink(uri: '/adminlte/plugins/jQuery/jQuery-2.1.4.min.js'))
printHtmlPart(8)
expressionOut.print(createLink(uri: '/adminlte/bootstrap/js/bootstrap.min.js'))
printHtmlPart(9)
})
invokeTag('captureHead','sitemesh',46,[:],1)
printHtmlPart(10)
createClosureForHtmlPart(11, 1)
invokeTag('captureBody','sitemesh',133,['class':("hold-transition login-page")],1)
printHtmlPart(12)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1490196379512L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
