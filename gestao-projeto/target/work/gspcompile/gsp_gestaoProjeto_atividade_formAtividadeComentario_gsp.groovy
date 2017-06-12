import java.text.SimpleDateFormat
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_gestaoProjeto_atividade_formAtividadeComentario_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/atividade/_formAtividadeComentario.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
for( atividadeComentario in (atividade.comentarios) ) {
printHtmlPart(1)
expressionOut.print(new SimpleDateFormat('dd/MM/yyyy HH:mm:ss').format( atividadeComentario.data ))
printHtmlPart(2)
expressionOut.print(atividadeComentario.id)
printHtmlPart(3)
expressionOut.print(atividadeComentario.id)
printHtmlPart(4)
expressionOut.print(atividadeComentario.nome)
printHtmlPart(5)
}
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
expressionOut.print(atividadeComentario?.id)
printHtmlPart(8)
expressionOut.print(atividadeComentario?.version)
printHtmlPart(9)
expressionOut.print(atividade?.id)
printHtmlPart(10)
if(true && (!editable)) {
printHtmlPart(11)
}
printHtmlPart(12)
expressionOut.print(atividadeComentario?.nome)
printHtmlPart(13)
if(true && (editable)) {
printHtmlPart(14)
}
else {
printHtmlPart(15)
}
printHtmlPart(16)
})
invokeTag('formRemote','g',82,['name':("form"),'url':([action: 'salvarComentario']),'onSuccess':("retornoSalvarComentario(data)")],1)
printHtmlPart(17)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1496850386263L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
