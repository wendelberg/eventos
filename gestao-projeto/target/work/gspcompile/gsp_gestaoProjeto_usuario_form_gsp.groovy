import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_gestaoProjeto_usuario_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/usuario/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(title)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
expressionOut.print(usuario?.id)
printHtmlPart(3)
expressionOut.print(usuario?.version)
printHtmlPart(4)
expressionOut.print(usuario?.usuarioGrupo?.id)
printHtmlPart(5)
if(true && (!editable)) {
printHtmlPart(6)
}
printHtmlPart(7)
expressionOut.print(usuario?.username)
printHtmlPart(8)
if(true && (!editable)) {
printHtmlPart(6)
}
printHtmlPart(9)
expressionOut.print(usuario?.password)
printHtmlPart(10)
if(true && (!editable)) {
printHtmlPart(6)
}
printHtmlPart(11)
expressionOut.print(usuario?.email)
printHtmlPart(12)
if(true && (editable)) {
printHtmlPart(13)
for( usuarioGrupo in (br.com.controleAcesso.UsuarioGrupo.createCriteria().list{ order('nome') }) ) {
printHtmlPart(14)
if(true && (usuario?.usuarioGrupo?.id == usuarioGrupo.id)) {
printHtmlPart(15)
expressionOut.print(usuarioGrupo.id)
printHtmlPart(16)
expressionOut.print(usuarioGrupo.nome)
printHtmlPart(17)
}
else {
printHtmlPart(15)
expressionOut.print(usuarioGrupo.id)
printHtmlPart(18)
expressionOut.print(usuarioGrupo.nome)
printHtmlPart(17)
}
printHtmlPart(19)
}
printHtmlPart(20)
}
else {
printHtmlPart(21)
expressionOut.print(usuario?.usuarioGrupo?.nome)
printHtmlPart(22)
}
printHtmlPart(23)
invokeTag('checkBox','g',86,['class':("form-control check"),'name':("usuario.enabled"),'id':("enabled"),'value':(usuario?.enabled),'disabled':(!editable)],-1)
printHtmlPart(24)
if(true && (editable)) {
printHtmlPart(25)
}
else {
printHtmlPart(26)
}
printHtmlPart(27)
})
invokeTag('formRemote','g',105,['name':("form"),'url':([action: 'salvar']),'onSuccess':("retornoSalvar(data)")],1)
printHtmlPart(28)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1496850386703L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
