package play.sports

import javax.servlet.http.HttpServletRequest
import grails.test.GrailsMock
import grails.test.mixin.*
import spock.lang.*

@TestFor(CategoriaController)
@Mock(Categoria)
class CategoriaControllerDeleteSpec extends Specification {

    def setup() {
        CategoriaMock.mock( 0 ).save( failOnError:true )

    }

    def "test ok"() {

        when:
            def control = mockCategoriaService()
            request.method = 'POST'
            controller.delete( 1 )
            control.verify()
        then:
            flash.listMessage == 'default.deleted.message'
            response.redirectedUrl == '/categoria/content'
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
            def control = mockCategoriaService( false )
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

    private GrailsMock mockCategoriaService( delete = true ) {

        def control = mockFor( CategoriaService )
        control.demand.get( 1 ) { Long id ->
            Categoria.findById( id )
        }
        if ( delete ) {
            control.demand.delete( 1 ) { Categoria instance ->
                instance.delete()
            }
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

}