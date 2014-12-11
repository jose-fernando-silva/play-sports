package play.sports

import grails.test.mixin.*
import spock.lang.*

@TestFor(CategoriaService)
@Mock(Categoria)
class CategoriaServiceDeleteSpec extends Specification {

    def setup() {
        CategoriaMock.mock( 0 ).save( failOnError:true )
    }

    def " test ok"() {

        when:
            def instance = service.get( id )
            service.delete( instance )
        then:
            Categoria.count() == 0
        where:
            id = 1

    }

    void "test Categoria null"() {

        when:
            service.delete( categoria )
        then:
            IllegalArgumentException e = thrown()
            e.message == "Parameter 'categoria' is null"
        where:
            categoria = null

    }

    def " test invalid"() {

        when:
            def instance = new Categoria()
            service.delete( instance )
        then:
            Categoria.exists( instance.id ) == false

    }

}