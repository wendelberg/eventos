import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_gestaoProjeto_agendaindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/agenda/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("menu")],-1)
printHtmlPart(2)
expressionOut.print(createLink(uri: '/adminlte/plugins/fullcalendar-2.6.0/fullcalendar.min.css'))
printHtmlPart(3)
expressionOut.print(createLink(uri: '/adminlte/plugins/fullcalendar-2.6.0/fullcalendar.print.css'))
printHtmlPart(4)
expressionOut.print(createLink(uri: '/adminlte/plugins/fullcalendar-2.6.0/lib/moment.min.js'))
printHtmlPart(5)
expressionOut.print(createLink(uri: '/adminlte/plugins/fullcalendar-2.6.0/fullcalendar.min.js'))
printHtmlPart(5)
expressionOut.print(createLink(uri: '/adminlte/plugins/fullcalendar-2.6.0/lang-all.js'))
printHtmlPart(6)
})
invokeTag('captureHead','sitemesh',117,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(7)
invokeTag('render','g',127,['template':("filtro")],-1)
printHtmlPart(8)
})
invokeTag('captureBody','sitemesh',143,[:],1)
printHtmlPart(9)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1496850386241L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
