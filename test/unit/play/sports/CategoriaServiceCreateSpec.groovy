package play.sports

import grails.test.mixin.*
import spock.lang.*

@TestFor(CategoriaService)
@Mock(Categoria)
class CategoriaServiceCreateSpec extends Specification {

    def "test ok"() {

        when:
            def instance = CategoriaMock.mock( 0 )
            service.create( instance )
        then:
            Categoria.count() == 1

    }

    def "test Categoria null"() {

        when:
            def instance = null
            service.create( instance )
        then:
            IllegalArgumentException e = thrown()
            e.message == "Parameter 'categoria' is null"

    }

    def "test Categoria invalid"() {

        when:
            def instance = CategoriaMock.mock( 0 )
            instance.nombre = nombre
            service.create( instance )
        then:
            IllegalArgumentException e = thrown()
            e.message == "Parameter 'categoria' is invalid"
        where:
            nombre = null

    }

}