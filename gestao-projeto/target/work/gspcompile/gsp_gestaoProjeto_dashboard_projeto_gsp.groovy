import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_gestaoProjeto_dashboard_projeto_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/dashboard/_projeto.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
for( json in (retorno) ) {
printHtmlPart(0)
expressionOut.print(json.id)
printHtmlPart(1)
expressionOut.print(json.nome)
printHtmlPart(2)
expressionOut.print(json.id)
printHtmlPart(3)
expressionOut.print(json.id)
printHtmlPart(4)
expressionOut.print(json.id)
printHtmlPart(5)
expressionOut.print(json.id)
printHtmlPart(6)
expressionOut.print(json.faltando)
printHtmlPart(7)
expressionOut.print(json.concluido)
printHtmlPart(8)
}
printHtmlPart(9)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1456990258000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
