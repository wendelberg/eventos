import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_gestaoProjeto_eventoSituacao_lista_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/eventoSituacao/_lista.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
for( eventoSituacao in (lista) ) {
printHtmlPart(1)
expressionOut.print(eventoSituacao.nome)
printHtmlPart(2)
expressionOut.print(eventoSituacao.id)
printHtmlPart(3)
expressionOut.print(eventoSituacao.id)
printHtmlPart(4)
expressionOut.print(eventoSituacao.id)
printHtmlPart(5)
}
printHtmlPart(6)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1489504224000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
