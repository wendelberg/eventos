import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_gestaoProjeto_endereco_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/endereco/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(title)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
expressionOut.print(endereco?.id)
printHtmlPart(3)
expressionOut.print(endereco?.version)
printHtmlPart(4)
if(true && (!editable)) {
printHtmlPart(5)
}
printHtmlPart(6)
expressionOut.print(endereco?.nome)
printHtmlPart(7)
if(true && (!editable)) {
printHtmlPart(5)
}
printHtmlPart(8)
expressionOut.print(endereco.rua)
printHtmlPart(9)
if(true && (!editable)) {
printHtmlPart(5)
}
printHtmlPart(10)
expressionOut.print(endereco.bairro)
printHtmlPart(11)
if(true && (!editable)) {
printHtmlPart(5)
}
printHtmlPart(12)
expressionOut.print(endereco.cidade)
printHtmlPart(13)
if(true && (editable)) {
printHtmlPart(14)
for( estado in (br.com.eventos.Estado.createCriteria().list{ order('nome') }) ) {
printHtmlPart(15)
if(true && (endereco?.uf?.id == estado.id)) {
printHtmlPart(16)
expressionOut.print(estado.sigla)
printHtmlPart(17)
expressionOut.print(estado.nome)
printHtmlPart(18)
}
else {
printHtmlPart(16)
expressionOut.print(estado.sigla)
printHtmlPart(19)
expressionOut.print(estado.nome)
printHtmlPart(18)
}
printHtmlPart(20)
}
printHtmlPart(21)
}
else {
printHtmlPart(22)
expressionOut.print(endereco?.uf?.nome)
printHtmlPart(23)
}
printHtmlPart(24)
if(true && (!editable)) {
printHtmlPart(5)
}
printHtmlPart(25)
expressionOut.print(endereco.cep)
printHtmlPart(26)
if(true && (!editable)) {
printHtmlPart(5)
}
printHtmlPart(27)
expressionOut.print(endereco.numero)
printHtmlPart(28)
if(true && (!editable)) {
printHtmlPart(5)
}
printHtmlPart(29)
expressionOut.print(endereco.pontoReferencia)
printHtmlPart(30)
if(true && (editable)) {
printHtmlPart(31)
}
else {
printHtmlPart(32)
}
printHtmlPart(33)
})
invokeTag('formRemote','g',145,['name':("form"),'url':([action: 'salvar']),'onSuccess':("retornoSalvar(data)")],1)
printHtmlPart(34)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1490023064000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
