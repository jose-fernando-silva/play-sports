package play.sports

import javax.servlet.http.HttpServletRequest
import grails.test.GrailsMock
import grails.test.mixin.*
import spock.lang.*

@TestFor(EquipoController)
@Mock(Equipo)
class EquipoControllerEditSpec extends Specification {

    def setup() {

        EquipoMock.mock( 0 ).save( failOnError:true )
        views[ '/equipo/_form.gsp' ] = getTemplate()

    }

    def "test ok"() {

        when:
            def control = mockEquipoService()
            request.method = 'GET'
            def model = controller.edit( 1 )
            control.verify()
        then:
            response.text == 'OK'
            response.status == 200

    }

    def "test id null"() {

        when:
            def control = mockCrackingService()
            request.method = 'GET'
            controller.edit( null )
            control.verify()
        then:
            response.redirectedUrl == '/logout'
            response.status == 302

    }

    def "test not found"() {

        when:
            def control = mockEquipoService()
            def control2 = mockCrackingService()
            request.method = 'GET'
            controller.edit( 2 )
            control.verify()
            control2.verify()
        then:
            response.redirectedUrl == '/logout'
            response.status == 302

    }

    @Ignore( 'See http://jira.grails.org/browse/GRAILS-8426' )
    def "test request method invalid"() {

        when:
            request.method = 'POST'
            controller.edit( 2 )
        then:
            response.status == 405

    }

    private String getTemplate() {
        '<g:if test="${equipoInstance}">OK</g:if><g:else>ERROR</g:else>'
    }

    private GrailsMock mockEquipoService() {

        def control = mockFor( EquipoService )
        control.demand.get( 1 ) { Long id ->
            Equipo.findById( id )
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