import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_gestaoProjeto_termoAcordo_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/termoAcordo/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(title)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
expressionOut.print(termoAcordo?.id)
printHtmlPart(3)
expressionOut.print(termoAcordo?.version)
printHtmlPart(4)
if(true && (!editable)) {
printHtmlPart(5)
}
printHtmlPart(6)
expressionOut.print(termoAcordo?.termo)
printHtmlPart(7)
if(true && (!editable)) {
printHtmlPart(5)
}
printHtmlPart(8)
expressionOut.print(termoAcordo?.descricao)
printHtmlPart(9)
expressionOut.print(termoAcordo?.descricao)
printHtmlPart(10)
if(true && (editable)) {
printHtmlPart(11)
}
else {
printHtmlPart(12)
}
printHtmlPart(13)
})
invokeTag('formRemote','g',65,['name':("form"),'url':([action: 'salvar']),'onSuccess':("retornoSalvar(data)")],1)
printHtmlPart(14)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1488901445258L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
