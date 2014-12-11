package play.sports

import grails.test.GrailsMock
import grails.test.mixin.*
import spock.lang.*

@TestFor(EquipoController)
class EquipoControllerListSpec extends Specification {

    def setup() {
        views[ '/equipo/_list.gsp' ] = getTemplate()
    }

    def "test ok"() {

        when:
            def control = mockEquipoService()
            request.method = 'GET'
            def model = controller.list()
        control.verify()

        then:
            response.text == 'OK'
            response.status == 200

    }

    @Ignore( 'See http://jira.grails.org/browse/GRAILS-8426' )
    def "test request method invalid"() {

        when:
            request.method = 'POST'
            controller.list()
        then:
            response.status == 405

    }

    private String getTemplate() {
        '<g:if test="${items && total}">OK</g:if><g:else>ERROR</g:else>'
    }

    private GrailsMock mockEquipoService() {

        def control = mockFor( EquipoService )
        control.demand.list( 1 ) { Map params ->
            [ items:[ new Equipo() ], total:1 ] }
        controller.equipoService = control.createMock()
        control

    }

}