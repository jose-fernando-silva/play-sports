package play.sports

import grails.test.mixin.*
import spock.lang.*

@TestFor(NoticiaService)
@Mock(Noticia)
class NoticiaServiceCreateSpec extends Specification {

    def "test ok"() {

        when:
            def instance = NoticiaMock.mock( 0 )
            service.create( instance )
        then:
            Noticia.count() == 1

    }

    def "test Noticia null"() {

        when:
            def instance = null
            service.create( instance )
        then:
            IllegalArgumentException e = thrown()
            e.message == "Parameter 'noticia' is null"

    }

    def "test Noticia invalid"() {

        when:
            def instance = NoticiaMock.mock( 0 )
            instance.titulo = titulo
            service.create( instance )
        then:
            IllegalArgumentException e = thrown()
            e.message == "Parameter 'noticia' is invalid"
        where:
            titulo = null

    }

}