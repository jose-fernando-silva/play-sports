package play.sports

import javax.servlet.http.HttpServletRequest
import grails.test.GrailsMock
import grails.test.mixin.*
import spock.lang.*

@TestFor(NoticiaController)
@Mock(Noticia)
class NoticiaControllerDeleteSpec extends Specification {

    def setup() {
        NoticiaMock.mock( 0 ).save( failOnError:true )

    }

    def "test ok"() {

        when:
            def control = mockNoticiaService()
            request.method = 'POST'
            controller.delete( 1 )
            control.verify()
        then:
            flash.listMessage == 'default.deleted.message'
            response.redirectedUrl == '/noticia/content'
            response.status == 302

    }

    def "test id null"() {

        when:
            def control = mockCrackingService()
            request.method = 'POST'
            controller.delete( null )
            control.verify()
        then:
            response.redirectedUrl == '/logout'
            response.status == 302

    }

    void "test not found"() {

        when:
            def control = mockNoticiaService( false )
            def control2 = mockCrackingService()
            request.method = 'POST'
            controller.delete( 2 )
            control.verify()
            control2.verify()
        then:
            response.redirectedUrl == '/logout'
            response.status == 302

    }

    @Ignore( 'See http://jira.grails.org/browse/GRAILS-8426' )
    def "test request method invalid"() {

        when:
            request.method = 'GET'
            controller.delete( 1 )
        then:
            response.status == 405

    }

    private GrailsMock mockNoticiaService( delete = true ) {

        def control = mockFor( NoticiaService )
        control.demand.get( 1 ) { Long id ->
            Noticia.findById( id )
        }
        if ( delete ) {
            control.demand.delete( 1 ) { Noticia instance ->
                instance.delete()
            }
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

}