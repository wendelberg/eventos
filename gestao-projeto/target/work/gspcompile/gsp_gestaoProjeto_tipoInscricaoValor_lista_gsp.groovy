import java.text.SimpleDateFormat
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_gestaoProjeto_tipoInscricaoValor_lista_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tipoInscricaoValor/_lista.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
for( tipoInscricaoValor in (lista) ) {
printHtmlPart(1)
expressionOut.print(tipoInscricaoValor.tipoInscricao.nome)
printHtmlPart(2)
expressionOut.print(tipoInscricaoValor.valor)
printHtmlPart(2)
expressionOut.print(new SimpleDateFormat('dd/MM/yyyy').format(tipoInscricaoValor.dataInicioVigencia))
printHtmlPart(2)
expressionOut.print(new SimpleDateFormat('dd/MM/yyyy').format(tipoInscricaoValor.dataFimVigencia))
printHtmlPart(2)
expressionOut.print(tipoInscricaoValor.maxParcelas)
printHtmlPart(3)
expressionOut.print(tipoInscricaoValor.id)
printHtmlPart(4)
expressionOut.print(tipoInscricaoValor.id)
printHtmlPart(5)
expressionOut.print(tipoInscricaoValor.id)
printHtmlPart(6)
}
printHtmlPart(7)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1496850386689L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
