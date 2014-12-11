package play.sports

import javax.servlet.http.HttpServletRequest
import grails.test.GrailsMock
import grails.test.mixin.*
import spock.lang.*

@TestFor(NoticiaController)
@Mock(Noticia)
class NoticiaControllerUpdateSpec extends Specification {

    def setup() {

        NoticiaMock.mock( 0 ).save( failOnError:true )
        views[ '/noticia/_form.gsp' ] = getTemplate()

    }

    def "test ok"() {

        when:
            def control = mockNoticiaService()
            request.method = 'POST'
            setUpParams()
            controller.update( 1 )
            control.verify()
        then:
            flash.formMessage == 'default.updated.message'
            response.redirectedUrl == "/noticia/edit/${1}"
            response.status == 302

    }

    def "test id null"() {

        when:
            def control = mockCrackingService()
            request.method = 'GET'
            controller.update( null )
            control.verify()
        then:
            response.redirectedUrl == '/logout'
            response.status == 302

    }

    def "test not found"() {

        when:
            def control = mockNoticiaService( true, 0 )
            def control2 = mockCrackingService()
            request.method = 'GET'
            controller.update( 2 )
            control.verify()
            control2.verify()
        then:
            response.redirectedUrl == '/logout'
            response.status == 302

    }

    def "test params invalid"() {

        when:
            def control = mockNoticiaService( false )
            request.method = 'POST'
            setUpParams()
            params.titulo = null
            controller.update( 1 )
            control.verify()
        then:
            response.text == 'OK'
            response.status == 400

    }

    @Ignore( 'See http://jira.grails.org/browse/GRAILS-8426' )
    def "test request method invalid"() {

        when:
            request.method = 'GET'
            controller.update( 1 )
        then:
            response.status == 405

    }

    private String getTemplate() {
        '<g:if test="${noticiaInstance && edit}">OK</g:if><g:else>ERROR</g:else>'
    }

    private GrailsMock mockNoticiaService( update = true, updateTimes = 1 ) {

        def control = mockFor( NoticiaService )
        control.demand.get( 1 ) { Long id ->
            Noticia.findById( id )
        }
        control.demand.update( updateTimes ) { Noticia instance ->
            if ( update ) {
                instance.save( failOnError:true )
            } else throw new IllegalArgumentException( 'error' )
        }
        controller.noticiaService = control.createMock()
        control

    }

    private GrailsMock mockCrackingService() {

        def control = mockFor( CrackingService )
        control.demand.notify( 1 ) { HttpServletRequest request, Map params -> }
        controller.crackingService = control.createMock()
        control

    }

    private void setUpParams() {

        def mock = NoticiaMock.mock( 0 )
        mock.properties.each{ params."${it.key}" = it.value }

    }

}