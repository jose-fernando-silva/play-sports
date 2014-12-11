package play.sports

import grails.test.GrailsMock
import grails.test.mixin.*
import spock.lang.*

@TestFor(LigaController)
@Mock(Liga)
class LigaControllerSaveSpec extends Specification {

    def setup() {
        views[ '/liga/_form.gsp' ] = getTemplate()
    }

    def "test ok"() {

        when:
            def control = mockLigaService()
            request.method = 'POST'
            setUpParams()
            controller.save()
            control.verify()
        then:
            flash.formMessage == 'default.created.message'
            response.redirectedUrl == "/liga/edit/1"
            response.status == 302

    }

    def "test params invalid"() {

        when:
            def control = mockLigaService( false )
            request.method = 'POST'
            setUpParams()
            params.year = null
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
        '<g:if test="${ligaInstance}">OK</g:if><g:else>ERROR</g:else>'
    }

    private GrailsMock mockLigaService( save = true ) {

        def control = mockFor( LigaService )
        control.demand.create( 1 ) { Liga instance ->
            if ( save ) {
                instance.id = 1
                instance.save( failOnError:true )
            } else throw new IllegalArgumentException( 'error' )
        }
        controller.ligaService = control.createMock()
        control

    }

    private void setUpParams() {

        def mock = LigaMock.mock( 0 )
        mock.properties.each{ params."${it.key}" = it.value }

    }

}