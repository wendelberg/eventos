import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_gestaoProjeto_usuarioGrupo_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/usuarioGrupo/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(title)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
expressionOut.print(usuarioGrupo?.id)
printHtmlPart(3)
expressionOut.print(usuarioGrupo?.version)
printHtmlPart(4)
if(true && (!editable)) {
printHtmlPart(5)
}
printHtmlPart(6)
expressionOut.print(usuarioGrupo?.nome)
printHtmlPart(7)
if(true && (editable)) {
printHtmlPart(8)
invokeTag('select','g',36,['class':("form-control select2"),'name':("usuarioGrupo.realizaAtividade"),'noSelection':(['null':'Selecione um...']),'from':(br.com.teste.enums.SimNao?.values()),'value':(usuarioGrupo?.realizaAtividade)],-1)
printHtmlPart(9)
}
else {
printHtmlPart(10)
expressionOut.print(usuarioGrupo?.realizaAtividade)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (editable)) {
printHtmlPart(13)
}
else {
printHtmlPart(14)
}
printHtmlPart(15)
})
invokeTag('formRemote','g',60,['name':("form"),'url':([action: 'salvar']),'onSuccess':("retornoSalvar(data)")],1)
printHtmlPart(16)
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
