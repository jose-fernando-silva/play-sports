package play.sports

import grails.test.mixin.*
import spock.lang.*

@TestFor(Noticia)
class NoticiaTituloConstraintsSpec extends Specification {

    def setup() {
        mockForConstraintsTests( Noticia, [ new Noticia() ] )
    }

    def "test 'nullable' constraint"() {

        when:
            def instance = new Noticia( titulo:titulo )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'titulo' ] != null
            instance.errors[ 'titulo' ] == 'nullable'
        where:
            titulo = null

    }

    def "test 'maxSize' constraint"() {

        when:
            def instance = new Noticia( titulo:titulo )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'titulo' ] != null
            instance.errors[ 'titulo' ] == 'maxSize'
        where:
            titulo = 'A' * 101

    }

}