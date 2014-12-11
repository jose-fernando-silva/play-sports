package play.sports

import grails.test.GrailsMock
import grails.test.mixin.*
import spock.lang.*

@TestFor(NoticiaController)
@Mock(Noticia)
class NoticiaControllerSaveSpec extends Specification {

    def setup() {
        views[ '/noticia/_form.gsp' ] = getTemplate()
    }

    def "test ok"() {

        when:
            def control = mockNoticiaService()
            request.method = 'POST'
            setUpParams()
            controller.save()
            control.verify()
        then:
            flash.formMessage == 'default.created.message'
            response.redirectedUrl == "/noticia/edit/1"
            response.status == 302

    }

    def "test params invalid"() {

        when:
            def control = mockNoticiaService( false )
            request.method = 'POST'
            setUpParams()
            params.titulo = null
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
        '<g:if test="${noticiaInstance}">OK</g:if><g:else>ERROR</g:else>'
    }

    private GrailsMock mockNoticiaService( save = true ) {

        def control = mockFor( NoticiaService )
        control.demand.create( 1 ) { Noticia instance ->
            if ( save ) {
                instance.id = 1
                instance.save( failOnError:true )
            } else throw new IllegalArgumentException( 'error' )
        }
        controller.noticiaService = control.createMock()
        control

    }

    private void setUpParams() {

        def mock = NoticiaMock.mock( 0 )
        mock.properties.each{ params."${it.key}" = it.value }

    }

}