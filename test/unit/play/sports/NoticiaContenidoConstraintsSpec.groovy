package play.sports

import grails.test.mixin.*
import spock.lang.*

@TestFor(Noticia)
class NoticiaContenidoConstraintsSpec extends Specification {

    def setup() {
        mockForConstraintsTests( Noticia, [ new Noticia() ] )
    }

    def "test 'nullable' constraint"() {

        when:
            def instance = new Noticia( contenido:contenido )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'contenido' ] != null
            instance.errors[ 'contenido' ] == 'nullable'
        where:
            contenido = null

    }

    def "test 'maxSize' constraint"() {

        when:
            def instance = new Noticia( contenido:contenido )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'contenido' ] != null
            instance.errors[ 'contenido' ] == 'maxSize'
        where:
            contenido = 'A' * 1001

    }

}