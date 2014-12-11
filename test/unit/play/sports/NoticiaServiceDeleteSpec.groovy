package play.sports

import grails.test.mixin.*
import spock.lang.*

@TestFor(NoticiaService)
@Mock(Noticia)
class NoticiaServiceDeleteSpec extends Specification {

    def setup() {
        NoticiaMock.mock( 0 ).save( failOnError:true )
    }

    def " test ok"() {

        when:
            def instance = service.get( id )
            service.delete( instance )
        then:
            Noticia.count() == 0
        where:
            id = 1

    }

    void "test Noticia null"() {

        when:
            service.delete( noticia )
        then:
            IllegalArgumentException e = thrown()
            e.message == "Parameter 'noticia' is null"
        where:
            noticia = null

    }

    def " test invalid"() {

        when:
            def instance = new Noticia()
            service.delete( instance )
        then:
            Noticia.exists( instance.id ) == false

    }

}