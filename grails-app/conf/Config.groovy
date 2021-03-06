import org.apache.log4j.rolling.RollingFileAppender
import org.apache.log4j.rolling.TimeBasedRollingPolicy
import org.apache.log4j.EnhancedPatternLayout

grails.config.locations = [ "classpath:config.properties" ]

grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination

// The ACCEPT header will not be used for content negotiation for user agents containing the following strings (defaults to the 4 major rendering engines)
grails.mime.disable.accept.header.userAgents = ['Gecko', 'WebKit', 'Presto', 'Trident']
grails.mime.types = [
    all:           '*/*',
    atom:          'application/atom+xml',
    css:           'text/css',
    csv:           'text/csv',
    form:          'application/x-www-form-urlencoded',
    html:          ['text/html','application/xhtml+xml'],
    js:            'text/javascript',
    json:          ['application/json', 'text/json'],
    multipartForm: 'multipart/form-data',
    rss:           'application/rss+xml',
    text:          'text/plain',
    hal:           ['application/hal+json','application/hal+xml'],
    xml:           ['text/xml', 'application/xml']
]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// What URL patterns should be processed by the resources plugin
grails.resources.adhoc.patterns = ['/images/*', '/css/*', '/js/*', '/plugins/*']

// Legacy setting for codec used to encode data with ${}
grails.views.default.codec = "html"

// The default scope for controllers. May be prototype, session or singleton.
// If unspecified, controllers are prototype scoped.
grails.controllers.defaultScope = 'singleton'

// GSP settings
grails {
    views {
        gsp {
            encoding = 'UTF-8'
            htmlcodec = 'xml' // use xml escaping instead of HTML4 escaping
            codecs {
                expression = 'none' // escapes values inside ${}
                scriptlet = 'html' // escapes output from scriptlets in GSPs
                taglib = 'none' // escapes output from taglibs
                staticparts = 'none' // escapes output from static template parts
            }
        }
        // escapes all not-encoded output at final stage of outputting
        filteringCodecForContentType {
            //'text/html' = 'html'
        }
    }
}
 
grails.converters.encoding = "UTF-8"
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = [ 'play.sports.aop' ]
// whether to disable processing of multi part requests
grails.web.disable.multipart=false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// configure auto-caching of queries by default (if false you can cache individual queries with 'cache: true')
grails.hibernate.cache.queries = false

environments {
    development {
        grails.logging.jul.usebridge = true
    }
    production {
        grails.logging.jul.usebridge = false
        // TODO: grails.serverURL = "http://www.changeme.com"
    }
}

log4j = {

    def layout = new EnhancedPatternLayout()
    layout.conversionPattern = '%d{dd-MM-yyyy HH:mm:ss.SSS} [%t] %-5p %c{1} - %m%n'
    def rollingFile = new RollingFileAppender()
    rollingFile.name = 'rollingFileAppender'
    rollingFile.layout = layout
    def rollingPolicy = new TimeBasedRollingPolicy()
    rollingPolicy.fileNamePattern = 'log/activity.%d.zip'
    rollingPolicy.activeFileName = 'log/activity'
    rollingPolicy.activateOptions()
    rollingFile.rollingPolicy = rollingPolicy

    appenders {
        appender rollingFile
        'null' name:'stacktrace'
    }// End of closure

    error rollingFileAppender:[
        'org.codehaus.groovy.grails.web.servlet',        // controllers
        'org.codehaus.groovy.grails.web.pages',          // GSP
        'org.codehaus.groovy.grails.web.sitemesh',       // layouts
        'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
        'org.codehaus.groovy.grails.web.mapping',        // URL mapping
        'org.codehaus.groovy.grails.commons',            // core / classloading
        'org.codehaus.groovy.grails.plugins',            // plugins
        'org.codehaus.groovy.grails.orm.hibernate',      // hibernate integration
        'org.springframework',
        'org.hibernate',
        'net.sf.ehcache.hibernate'
    ]

    info rollingFileAppender:[
        'play.sports.aop'
    ]

}// End of closure

grails.plugins.remotepagination.enableBootstrap=true

grails {
  optimus {
    tab = 4
    blockComments = false
  }
}


// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'play.sports.Usuario'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'play.sports.UsuarioRol'
grails.plugin.springsecurity.authority.className = 'play.sports.Rol'
grails.plugin.springsecurity.logout.postOnly = false
grails.plugin.springsecurity.securityConfigType = "InterceptUrlMap"
grails.plugin.springsecurity.interceptUrlMap = [
   '/':                  ['permitAll'],
   '/noticia/mostrarNoticia/**':     ['permitAll'],
   '/noticia/mostrarNoticias/**':     ['permitAll'],
   '/home/index':     ['permitAll'],
   '/administrador/**':  ['ROLE_ADMIN'],
   '/categoria/**':      ['ROLE_ADMIN'],
   '/noticia/**':        ['ROLE_ADMIN'],
   '/liga/**':        ['permitAll'],
   '/estadisticas/**':        ['permitAll'],
   '/ligaMX/**':        ['permitAll'],
   '/equipo/**':        ['permitAll'],
   '/mundial/**':        ['permitAll'],


   
   '/index':             ['permitAll'],
   '/index.gsp':         ['permitAll'],
   '/**/js/**':          ['permitAll'],
   '/**/css/**':         ['permitAll'],
   '/**/images/**':      ['permitAll'],
   '/**/favicon.ico':    ['permitAll'],
   '/login/**':          ['permitAll'],
   '/logout/**':         ['permitAll'],
]