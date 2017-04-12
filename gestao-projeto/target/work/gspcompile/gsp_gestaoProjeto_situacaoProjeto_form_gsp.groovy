import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_gestaoProjeto_situacaoProjeto_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/situacaoProjeto/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(title)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
expressionOut.print(situacaoProjeto?.id)
printHtmlPart(3)
expressionOut.print(situacaoProjeto?.version)
printHtmlPart(4)
if(true && (!editable)) {
printHtmlPart(5)
}
printHtmlPart(6)
expressionOut.print(situacaoProjeto?.nome)
printHtmlPart(7)
invokeTag('checkBox','g',33,['class':("form-control check"),'name':("situacaoProjeto.exibeDashboard"),'id':("enabled"),'value':(situacaoProjeto?.exibeDashboard),'disabled':(!editable)],-1)
printHtmlPart(8)
if(true && (editable)) {
printHtmlPart(9)
}
else {
printHtmlPart(10)
}
printHtmlPart(11)
})
invokeTag('formRemote','g',52,['name':("form"),'url':([action: 'salvar']),'onSuccess':("retornoSalvar(data)")],1)
printHtmlPart(12)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1456990258000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
