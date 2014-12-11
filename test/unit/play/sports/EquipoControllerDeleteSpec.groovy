package play.sports

import javax.servlet.http.HttpServletRequest
import grails.test.GrailsMock
import grails.test.mixin.*
import spock.lang.*

@TestFor(EquipoController)
@Mock(Equipo)
class EquipoControllerDeleteSpec extends Specification {

    def setup() {
        EquipoMock.mock( 0 ).save( failOnError:true )

    }

    def "test ok"() {

        when:
            def control = mockEquipoService()
            request.method = 'POST'
            controller.delete( 1 )
            control.verify()
        then:
            flash.listMessage == 'default.deleted.message'
            response.redirectedUrl == '/equipo/content'
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
            def control = mockEquipoService( false )
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

    private GrailsMock mockEquipoService( delete = true ) {

        def control = mockFor( EquipoService )
        control.demand.get( 1 ) { Long id ->
            Equipo.findById( id )
        }
        if ( delete ) {
            control.demand.delete( 1 ) { Equipo instance ->
                instance.delete()
            }
        }
        controller.equipoService = control.createMock()
        control

    }

    private GrailsMock mockCrackingService() {

        def control = mockFor( CrackingService )
        control.demand.notify( 1 ) { HttpServletRequest request, Map params -> }
        controller.crackingService = control.createMock()
        control

    }

}