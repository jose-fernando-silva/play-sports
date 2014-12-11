package play.sports

import grails.test.mixin.*
import spock.lang.*

@TestFor(CategoriaService)
@Mock(Categoria)
class CategoriaServiceUpdateSpec extends Specification {

    def "test ok"() {

        when:
            def instance = CategoriaMock.mock( 0 )
            service.update( instance )
        then:
            Categoria.count() == 1

    }

    def "test Categoria null"() {

        when:
            def instance = null
            service.update( instance )
        then:
            IllegalArgumentException e = thrown()
            e.message == "Parameter 'categoria' is null"

    }

    def "test Categoria invalid"() {

        when:
            def instance = CategoriaMock.mock( 0 )
            instance.nombre = nombre
            service.update( instance )
        then:
            IllegalArgumentException e = thrown()
            e.message == "Parameter 'categoria' is invalid"
        where:
            nombre = null
    }

}