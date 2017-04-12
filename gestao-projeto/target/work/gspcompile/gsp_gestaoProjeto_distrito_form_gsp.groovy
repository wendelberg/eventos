import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_gestaoProjeto_distrito_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/distrito/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(title)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
expressionOut.print(distrito?.id)
printHtmlPart(3)
expressionOut.print(distrito?.version)
printHtmlPart(4)
if(true && (!editable)) {
printHtmlPart(5)
}
printHtmlPart(6)
expressionOut.print(distrito?.nome)
printHtmlPart(7)
if(true && (editable)) {
printHtmlPart(8)
}
else {
printHtmlPart(9)
}
printHtmlPart(10)
})
invokeTag('formRemote','g',47,['name':("form"),'url':([action: 'salvar']),'onSuccess':("retornoSalvar(data)")],1)
printHtmlPart(11)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1489504169000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
