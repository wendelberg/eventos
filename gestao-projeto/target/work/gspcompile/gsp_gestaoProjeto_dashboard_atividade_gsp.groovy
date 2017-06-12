import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_gestaoProjeto_dashboard_atividade_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/dashboard/_atividade.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(title)
printHtmlPart(1)
for( atividade in (atividades) ) {
printHtmlPart(2)
invokeTag('set','g',12,['var':("newUser"),'value':(atividade.usuario.id)],-1)
printHtmlPart(2)
if(true && (newUser == currentUser)) {
printHtmlPart(3)
expressionOut.print(atividade.nome)
printHtmlPart(4)
expressionOut.print(atividade.situacaoAtividade.nome)
printHtmlPart(5)
expressionOut.print(atividade.percentualConcluido)
printHtmlPart(6)
expressionOut.print(atividade.percentualConcluido)
printHtmlPart(7)
expressionOut.print(atividade.situacaoAtividade.cor)
printHtmlPart(8)
expressionOut.print(atividade.percentualConcluido)
printHtmlPart(9)
}
else {
printHtmlPart(10)
invokeTag('set','g',35,['var':("currentUser"),'value':(atividade.usuario.id)],-1)
printHtmlPart(11)
expressionOut.print(atividade.usuario.username)
printHtmlPart(12)
expressionOut.print(atividade.nome)
printHtmlPart(4)
expressionOut.print(atividade.situacaoAtividade.nome)
printHtmlPart(5)
expressionOut.print(atividade.percentualConcluido)
printHtmlPart(6)
expressionOut.print(atividade.percentualConcluido)
printHtmlPart(7)
expressionOut.print(atividade.situacaoAtividade.cor)
printHtmlPart(8)
expressionOut.print(atividade.percentualConcluido)
printHtmlPart(9)
}
printHtmlPart(13)
}
printHtmlPart(14)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1496850386293L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
