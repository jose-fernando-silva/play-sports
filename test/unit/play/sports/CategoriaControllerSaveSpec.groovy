package play.sports

import grails.test.GrailsMock
import grails.test.mixin.*
import spock.lang.*

@TestFor(CategoriaController)
@Mock(Categoria)
class CategoriaControllerSaveSpec extends Specification {

    def setup() {
        views[ '/categoria/_form.gsp' ] = getTemplate()
    }

    def "test ok"() {

        when:
            def control = mockCategoriaService()
            request.method = 'POST'
            setUpParams()
            controller.save()
            control.verify()
        then:
            flash.formMessage == 'default.created.message'
            response.redirectedUrl == "/categoria/edit/1"
            response.status == 302

    }

    def "test params invalid"() {

        when:
            def control = mockCategoriaService( false )
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
        '<g:if test="${categoriaInstance}">OK</g:if><g:else>ERROR</g:else>'
    }

    private GrailsMock mockCategoriaService( save = true ) {

        def control = mockFor( CategoriaService )
        control.demand.create( 1 ) { Categoria instance ->
            if ( save ) {
                instance.id = 1
                instance.save( failOnError:true )
            } else throw new IllegalArgumentException( 'error' )
        }
        controller.categoriaService = control.createMock()
        control

    }

    private void setUpParams() {

        def mock = CategoriaMock.mock( 0 )
        mock.properties.each{ params."${it.key}" = it.value }

    }

}