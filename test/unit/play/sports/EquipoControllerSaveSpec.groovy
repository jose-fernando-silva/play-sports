package play.sports

import grails.test.GrailsMock
import grails.test.mixin.*
import spock.lang.*

@TestFor(EquipoController)
@Mock(Equipo)
class EquipoControllerSaveSpec extends Specification {

    def setup() {
        views[ '/equipo/_form.gsp' ] = getTemplate()
    }

    def "test ok"() {

        when:
            def control = mockEquipoService()
            request.method = 'POST'
            setUpParams()
            controller.save()
            control.verify()
        then:
            flash.formMessage == 'default.created.message'
            response.redirectedUrl == "/equipo/edit/1"
            response.status == 302

    }

    def "test params invalid"() {

        when:
            def control = mockEquipoService( false )
            request.method = 'POST'
            setUpParams()
            params.nombre = null
            controller.save()
            control.verify()
        then:
            response.text == 'OK'
            response.status == 400

    }

    @Ignore( 'See http://jira.grails.org/browse/GRAILS-8426' )
    def "test request method invalid"() {

        when:
            request.method = 'GET'
            controller.save()
        then:
            response.status == 405

    }

    private String getTemplate() {
        '<g:if test="${equipoInstance}">OK</g:if><g:else>ERROR</g:else>'
    }

    private GrailsMock mockEquipoService( save = true ) {

        def control = mockFor( EquipoService )
        control.demand.create( 1 ) { Equipo instance ->
            if ( save ) {
                instance.id = 1
                instance.save( failOnError:true )
            } else throw new IllegalArgumentException( 'error' )
        }
        controller.equipoService = control.createMock()
        control

    }

    private void setUpParams() {

        def mock = EquipoMock.mock( 0 )
        mock.properties.each{ params."${it.key}" = it.value }

    }

}