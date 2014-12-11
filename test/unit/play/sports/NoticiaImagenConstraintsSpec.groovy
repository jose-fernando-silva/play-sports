package play.sports

import grails.test.mixin.*
import spock.lang.*

@TestFor(Noticia)
class NoticiaImagenConstraintsSpec extends Specification {

    def setup() {
        mockForConstraintsTests( Noticia, [ new Noticia() ] )
    }

    def "test 'nullable' constraint"() {

        when:
            def instance = new Noticia( imagen:imagen )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'imagen' ] != null
            instance.errors[ 'imagen' ] == 'nullable'
        where:
            imagen = null

    }

    def "test 'url' constraint"() {

        when:
            def instance = new Noticia( imagen:imagen )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'imagen' ] != null
            instance.errors[ 'imagen' ] == 'url'
        where:
            imagen = 'A'

    }

}