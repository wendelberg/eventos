import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_gestaoProjeto_situacaoAtividadeindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/situacaoAtividade/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("menu")],-1)
printHtmlPart(2)
invokeTag('javascript','asset',7,['src':("crud.js")],-1)
printHtmlPart(3)
expressionOut.print(createLink(uri: '/adminlte/plugins/colorpicker/bootstrap-colorpicker.min.css'))
printHtmlPart(4)
expressionOut.print(createLink(uri: '/adminlte/plugins/colorpicker/bootstrap-colorpicker.min.js'))
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',15,[:],1)
printHtmlPart(1)
createClosureForHtmlPart(6, 1)
invokeTag('captureBody','sitemesh',42,[:],1)
printHtmlPart(7)
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
