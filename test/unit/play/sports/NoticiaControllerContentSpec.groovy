package play.sports

import grails.test.GrailsMock
import grails.test.mixin.*
import spock.lang.*

@TestFor(NoticiaController)
class NoticiaControllerContentSpec extends Specification {

    def setup() {
        views[ '/noticia/_content.gsp' ] = getTemplate()
    }

    def "test ok"() {

        when:
            def control = mockNoticiaService()
            request.method = 'GET'
            def model = controller.content()
            control.verify()

        then:
            response.text == 'OK'
            response.status == 200

    }

    @Ignore( 'See http://jira.grails.org/browse/GRAILS-8426' )
    def "test request method invalid"() {

        when:
            request.method = 'POST'
            controller.content()
        then:
            response.status == 405

    }

    private String getTemplate() {
        '<g:if test="${items && total}">OK</g:if><g:else>ERROR</g:else>'
    }

    private GrailsMock mockNoticiaService() {

        def control = mockFor( NoticiaService )
        control.demand.list( 1 ) { Map params ->
            [ items:[ new Noticia() ], total:1 ] }
        controller.noticiaService = control.createMock()
        control

    }

}