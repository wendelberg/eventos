import java.text.SimpleDateFormat
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_gestaoProjeto_evento_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/evento/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(title)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
expressionOut.print(evento?.id)
printHtmlPart(3)
expressionOut.print(evento?.version)
printHtmlPart(4)
if(true && (!editable)) {
printHtmlPart(5)
}
printHtmlPart(6)
expressionOut.print(evento?.nome)
printHtmlPart(7)
if(true && (!editable)) {
printHtmlPart(5)
}
printHtmlPart(8)
expressionOut.print(new SimpleDateFormat('dd/MM/yyyy').format( evento?.dataIncio))
printHtmlPart(9)
if(true && (!editable)) {
printHtmlPart(5)
}
printHtmlPart(10)
expressionOut.print(new SimpleDateFormat('dd/MM/yyyy').format(evento?.dataFim))
printHtmlPart(11)
if(true && (editable)) {
printHtmlPart(12)
for( eventoSituacao in (br.com.eventos.EventoSituacao.createCriteria().list{ order('nome') }) ) {
printHtmlPart(13)
if(true && (evento?.EventoSituacao?.id == EventoSituacao.id)) {
printHtmlPart(14)
expressionOut.print(EventoSituacao.id)
printHtmlPart(15)
expressionOut.print(EventoSituacao.nome)
printHtmlPart(16)
}
else {
printHtmlPart(14)
expressionOut.print(EventoSituacao.id)
printHtmlPart(17)
expressionOut.print(EventoSituacao.nome)
printHtmlPart(16)
}
printHtmlPart(18)
}
printHtmlPart(19)
}
else {
printHtmlPart(20)
expressionOut.print(evento?.EventoSituacao?.nome)
printHtmlPart(21)
}
printHtmlPart(22)
if(true && (editable)) {
printHtmlPart(23)
}
else {
printHtmlPart(24)
}
printHtmlPart(25)
})
invokeTag('formRemote','g',103,['name':("form"),'url':([action: 'salvar']),'onSuccess':("retornoSalvar(data)")],1)
printHtmlPart(26)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1496850386382L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
