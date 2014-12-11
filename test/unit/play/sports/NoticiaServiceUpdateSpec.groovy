package play.sports

import grails.test.mixin.*
import spock.lang.*

@TestFor(NoticiaService)
@Mock(Noticia)
class NoticiaServiceUpdateSpec extends Specification {

    def "test ok"() {

        when:
            def instance = NoticiaMock.mock( 0 )
            service.update( instance )
        then:
            Noticia.count() == 1

    }

    def "test Noticia null"() {

        when:
            def instance = null
            service.update( instance )
        then:
            IllegalArgumentException e = thrown()
            e.message == "Parameter 'noticia' is null"

    }

    def "test Noticia invalid"() {

        when:
            def instance = NoticiaMock.mock( 0 )
            instance.titulo = titulo
            service.update( instance )
        then:
            IllegalArgumentException e = thrown()
            e.message == "Parameter 'noticia' is invalid"
        where:
            titulo = null
    }

}