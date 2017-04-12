import java.text.SimpleDateFormat
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_gestaoProjeto_atividade_formAtividade_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/atividade/_formAtividade.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
expressionOut.print(atividade?.id)
printHtmlPart(2)
expressionOut.print(atividade?.version)
printHtmlPart(3)
if(true && (!editable)) {
printHtmlPart(4)
}
printHtmlPart(5)
expressionOut.print(atividade?.nome)
printHtmlPart(6)
if(true && (!editable)) {
printHtmlPart(4)
}
printHtmlPart(7)
expressionOut.print(new SimpleDateFormat('dd/MM/yyyy').format( atividade?.dataInicio ))
printHtmlPart(8)
if(true && (!editable)) {
printHtmlPart(4)
}
printHtmlPart(9)
expressionOut.print(new SimpleDateFormat('dd/MM/yyyy').format( atividade?.dataFim ))
printHtmlPart(10)
if(true && (!editable)) {
printHtmlPart(4)
}
printHtmlPart(11)
expressionOut.print(atividade?.percentualConcluido)
printHtmlPart(12)
if(true && (editable)) {
printHtmlPart(13)
for( situacaoAtividade in (br.com.gestaoProjeto.SituacaoAtividade.createCriteria().list{ order('nome') }) ) {
printHtmlPart(14)
if(true && (atividade?.situacaoAtividade?.id == situacaoAtividade.id)) {
printHtmlPart(15)
expressionOut.print(situacaoAtividade.id)
printHtmlPart(16)
expressionOut.print(situacaoAtividade.nome)
printHtmlPart(17)
}
else {
printHtmlPart(15)
expressionOut.print(situacaoAtividade.id)
printHtmlPart(18)
expressionOut.print(situacaoAtividade.nome)
printHtmlPart(17)
}
printHtmlPart(19)
}
printHtmlPart(20)
}
else {
printHtmlPart(21)
expressionOut.print(atividade?.situacaoAtividade?.nome)
printHtmlPart(22)
}
printHtmlPart(23)
if(true && (editable)) {
printHtmlPart(24)
for( usuario in (br.com.controleAcesso.Usuario.createCriteria().list{

									usuarioGrupo {
										eq('realizaAtividade', br.com.teste.enums.SimNao.SIM)
									}
								
									eq('enabled', true)
									order('username') 
								}) ) {
printHtmlPart(14)
if(true && (atividade?.usuario?.id == usuario.id)) {
printHtmlPart(15)
expressionOut.print(usuario.id)
printHtmlPart(16)
expressionOut.print(usuario.username)
printHtmlPart(17)
}
else {
printHtmlPart(15)
expressionOut.print(usuario.id)
printHtmlPart(18)
expressionOut.print(usuario.username)
printHtmlPart(17)
}
printHtmlPart(19)
}
printHtmlPart(20)
}
else {
printHtmlPart(21)
expressionOut.print(atividade?.usuario?.username)
printHtmlPart(22)
}
printHtmlPart(25)
if(true && (editable)) {
printHtmlPart(26)
for( projeto in (br.com.gestaoProjeto.Projeto.createCriteria().list{ order('nome') }) ) {
printHtmlPart(14)
if(true && (atividade?.projeto?.id == projeto.id)) {
printHtmlPart(15)
expressionOut.print(projeto.id)
printHtmlPart(16)
expressionOut.print(projeto.nome)
printHtmlPart(17)
}
else {
printHtmlPart(15)
expressionOut.print(projeto.id)
printHtmlPart(18)
expressionOut.print(projeto.nome)
printHtmlPart(17)
}
printHtmlPart(19)
}
printHtmlPart(20)
}
else {
printHtmlPart(21)
expressionOut.print(atividade?.projeto?.nome)
printHtmlPart(22)
}
printHtmlPart(27)
if(true && (editable)) {
printHtmlPart(28)
}
else {
printHtmlPart(29)
}
printHtmlPart(30)
})
invokeTag('formRemote','g',169,['name':("form"),'url':([action: 'salvar']),'onSuccess':("retornoSalvar(data)")],1)
printHtmlPart(31)
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
