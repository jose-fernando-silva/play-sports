package play.sports

import javax.servlet.http.HttpServletRequest
import grails.test.GrailsMock
import grails.test.mixin.*
import spock.lang.*

@TestFor(CategoriaController)
@Mock(Categoria)
class CategoriaControllerUpdateSpec extends Specification {

    def setup() {

        CategoriaMock.mock( 0 ).save( failOnError:true )
        views[ '/categoria/_form.gsp' ] = getTemplate()

    }

    def "test ok"() {

        when:
            def control = mockCategoriaService()
            request.method = 'POST'
            setUpParams()
            controller.update( 1 )
            control.verify()
        then:
            flash.formMessage == 'default.updated.message'
            response.redirectedUrl == "/categoria/edit/${1}"
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
            def control = mockCategoriaService( true, 0 )
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
            def control = mockCategoriaService( false )
            request.method = 'POST'
            setUpParams()
            params.nombre = null
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
        '<g:if test="${categoriaInstance && edit}">OK</g:if><g:else>ERROR</g:else>'
    }

    private GrailsMock mockCategoriaService( update = true, updateTimes = 1 ) {

        def control = mockFor( CategoriaService )
        control.demand.get( 1 ) { Long id ->
            Categoria.findById( id )
        }
        control.demand.update( updateTimes ) { Categoria instance ->
            if ( update ) {
                instance.save( failOnError:true )
            } else throw new IllegalArgumentException( 'error' )
        }
        controller.categoriaService = control.createMock()
        control

    }

    private GrailsMock mockCrackingService() {

        def control = mockFor( CrackingService )
        control.demand.notify( 1 ) { HttpServletRequest request, Map params -> }
        controller.crackingService = control.createMock()
        control

    }

    private void setUpParams() {

        def mock = CategoriaMock.mock( 0 )
        mock.properties.each{ params."${it.key}" = it.value }

    }

}