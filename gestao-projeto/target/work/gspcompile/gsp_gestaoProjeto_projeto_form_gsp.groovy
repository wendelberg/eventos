import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_gestaoProjeto_projeto_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/projeto/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(title)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
expressionOut.print(projeto?.id)
printHtmlPart(3)
expressionOut.print(projeto?.version)
printHtmlPart(4)
if(true && (!editable)) {
printHtmlPart(5)
}
printHtmlPart(6)
expressionOut.print(projeto?.nome)
printHtmlPart(7)
if(true && (editable)) {
printHtmlPart(8)
for( situacaoProjeto in (br.com.gestaoProjeto.SituacaoProjeto.createCriteria().list{ order('nome') }) ) {
printHtmlPart(9)
if(true && (projeto?.situacaoProjeto?.id == situacaoProjeto.id)) {
printHtmlPart(10)
expressionOut.print(situacaoProjeto.id)
printHtmlPart(11)
expressionOut.print(situacaoProjeto.nome)
printHtmlPart(12)
}
else {
printHtmlPart(10)
expressionOut.print(situacaoProjeto.id)
printHtmlPart(13)
expressionOut.print(situacaoProjeto.nome)
printHtmlPart(12)
}
printHtmlPart(14)
}
printHtmlPart(15)
}
else {
printHtmlPart(16)
expressionOut.print(projeto?.situacaoProjeto?.nome)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (editable)) {
printHtmlPart(19)
}
else {
printHtmlPart(20)
}
printHtmlPart(21)
})
invokeTag('formRemote','g',72,['name':("form"),'url':([action: 'salvar']),'onSuccess':("retornoSalvar(data)")],1)
printHtmlPart(22)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1496850386529L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
