import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_gestaoProjeto_endereco_lista_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/endereco/_lista.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
for( endereco in (lista) ) {
printHtmlPart(1)
expressionOut.print(endereco.nome)
printHtmlPart(2)
expressionOut.print(endereco.rua)
printHtmlPart(3)
expressionOut.print(endereco.bairro)
printHtmlPart(2)
expressionOut.print(endereco.cidade)
printHtmlPart(2)
expressionOut.print(endereco.uf.sigla)
printHtmlPart(2)
expressionOut.print(endereco.cep)
printHtmlPart(2)
expressionOut.print(endereco.numero)
printHtmlPart(2)
expressionOut.print(endereco.pontoReferencia)
printHtmlPart(4)
expressionOut.print(endereco.id)
printHtmlPart(5)
expressionOut.print(endereco.id)
printHtmlPart(6)
expressionOut.print(endereco.id)
printHtmlPart(7)
}
printHtmlPart(8)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1496850386363L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
