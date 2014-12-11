package play.sports

import grails.test.mixin.*
import spock.lang.*

@TestFor(Noticia)
class NoticiaCategoriaConstraintsSpec extends Specification {

    def setup() {
        mockForConstraintsTests( Noticia, [ new Noticia() ] )
    }

    def "test 'nullable' constraint"() {

        when:
            def instance = new Noticia( categoria:categoria )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'categoria' ] != null
            instance.errors[ 'categoria' ] == 'nullable'
        where:
            categoria = null

    }

}