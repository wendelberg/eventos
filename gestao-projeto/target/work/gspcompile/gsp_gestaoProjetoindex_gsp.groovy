import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_gestaoProjetoindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'charset':("utf-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(3)
expressionOut.print(assetPath(src: 'favicon.ico'))
printHtmlPart(4)
invokeTag('captureMeta','sitemesh',13,['gsp_sm_xmlClosingForEmptyTag':(""),'content':("width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"),'name':("viewport")],-1)
printHtmlPart(5)
expressionOut.print(createLink(uri: '/adminlte/plugins/reset/html5-reset.css'))
printHtmlPart(6)
expressionOut.print(createLink(uri: '/adminlte/bootstrap/css/bootstrap.min.css'))
printHtmlPart(7)
invokeTag('stylesheet','asset',28,['src':("institucional.css")],-1)
printHtmlPart(8)
expressionOut.print(createLink(uri: '/adminlte/plugins/jQuery/jQuery-2.1.4.min.js'))
printHtmlPart(9)
expressionOut.print(createLink(uri: '/adminlte/plugins/jQueryUI/jquery-ui.min.js'))
printHtmlPart(10)
expressionOut.print(createLink(uri: '/adminlte/bootstrap/js/bootstrap.min.js'))
printHtmlPart(11)
})
invokeTag('captureHead','sitemesh',42,[:],1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(13)
expressionOut.print(createLink(uri:'/'))
printHtmlPart(14)
expressionOut.print(createLink(controller: 'login'))
printHtmlPart(15)
expressionOut.print(createLink(controller: 'usuario',action:'cadastrar'))
printHtmlPart(16)
expressionOut.print(createLink(controller: 'usuario',action:'cadastrar'))
printHtmlPart(17)
})
invokeTag('captureBody','sitemesh',250,[:],1)
printHtmlPart(18)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1492874874527L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
