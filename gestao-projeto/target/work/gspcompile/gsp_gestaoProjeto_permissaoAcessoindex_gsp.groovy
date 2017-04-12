import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_gestaoProjeto_permissaoAcessoindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/permissaoAcesso/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('stylesheet','asset',6,['href':("kendo/kendo.common-material.min.css")],-1)
printHtmlPart(2)
invokeTag('stylesheet','asset',7,['href':("kendo/kendo.material.min.css")],-1)
printHtmlPart(2)
invokeTag('javascript','asset',8,['src':("kendo/kendo.all.min.js")],-1)
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("menu")],-1)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',65,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(5)
for( grupo in (br.com.controleAcesso.UsuarioGrupo.list()) ) {
printHtmlPart(6)
expressionOut.print(grupo.id)
printHtmlPart(7)
expressionOut.print(grupo.nome)
printHtmlPart(8)
}
printHtmlPart(9)
})
invokeTag('captureBody','sitemesh',106,[:],1)
printHtmlPart(10)
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
