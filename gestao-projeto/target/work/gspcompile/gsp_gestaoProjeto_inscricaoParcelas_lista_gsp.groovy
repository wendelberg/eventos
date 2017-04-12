import java.text.DecimalFormat
import java.text.SimpleDateFormat
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_gestaoProjeto_inscricaoParcelas_lista_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/inscricaoParcelas/_lista.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(createLink(uri: '/adminlte/plugins/jQuery/jquery.maskMoney.js'))
printHtmlPart(2)
for( inscricaoParcelas in (lista) ) {
printHtmlPart(3)
expressionOut.print(inscricaoParcelas.numeroParcela)
printHtmlPart(4)
expressionOut.print(new SimpleDateFormat('dd/MM/yyyy').format(inscricaoParcelas.dataVencimento))
printHtmlPart(4)
expressionOut.print(new DecimalFormat('#0.00').format(inscricaoParcelas.valorParcela))
printHtmlPart(4)
expressionOut.print(inscricaoParcelas.situacao.nome)
printHtmlPart(5)
expressionOut.print(inscricaoParcelas.id)
printHtmlPart(6)
expressionOut.print(inscricaoParcelas.id)
printHtmlPart(7)
expressionOut.print(inscricaoParcelas.id)
printHtmlPart(8)
}
printHtmlPart(9)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1492012199306L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
