import java.text.SimpleDateFormat
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_gestaoProjeto_tipoInscricaoValor_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tipoInscricaoValor/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(title)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
expressionOut.print(tipoInscricaoValor?.id)
printHtmlPart(3)
expressionOut.print(tipoInscricaoValor?.version)
printHtmlPart(4)
if(true && (editable)) {
printHtmlPart(5)
for( tipoInscricao in (br.com.eventos.TipoInscricao.createCriteria().list{ order('nome') }) ) {
printHtmlPart(6)
if(true && (tipoInscricaoValor?.tipoInscricao?.id == tipoInscricao.id)) {
printHtmlPart(7)
expressionOut.print(tipoInscricao.id)
printHtmlPart(8)
expressionOut.print(tipoInscricao.nome)
printHtmlPart(9)
}
else {
printHtmlPart(7)
expressionOut.print(tipoInscricao.id)
printHtmlPart(10)
expressionOut.print(tipoInscricao.nome)
printHtmlPart(9)
}
printHtmlPart(11)
}
printHtmlPart(12)
}
else {
printHtmlPart(13)
expressionOut.print(tipoInscricaoValor?.tipoInscricao?.nome)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (!editable)) {
printHtmlPart(16)
}
printHtmlPart(17)
expressionOut.print(tipoInscricaoValor?.valor)
printHtmlPart(18)
if(true && (!editable)) {
printHtmlPart(16)
}
printHtmlPart(19)
expressionOut.print(new SimpleDateFormat('dd/MM/yyyy').format( tipoInscricaoValor?.dataInicioVigencia))
printHtmlPart(20)
if(true && (!editable)) {
printHtmlPart(16)
}
printHtmlPart(21)
expressionOut.print(new SimpleDateFormat('dd/MM/yyyy').format(tipoInscricaoValor?.dataFimVigencia))
printHtmlPart(22)
if(true && (!editable)) {
printHtmlPart(16)
}
printHtmlPart(23)
expressionOut.print(tipoInscricaoValor?.maxParcelas)
printHtmlPart(24)
if(true && (editable)) {
printHtmlPart(25)
}
else {
printHtmlPart(26)
}
printHtmlPart(27)
})
invokeTag('formRemote','g',116,['name':("form"),'url':([action: 'salvar']),'onSuccess':("retornoSalvar(data)")],1)
printHtmlPart(28)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1489592442847L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
