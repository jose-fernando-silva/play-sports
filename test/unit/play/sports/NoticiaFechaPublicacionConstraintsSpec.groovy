package play.sports

import grails.test.mixin.*
import spock.lang.*

@TestFor(Noticia)
class NoticiaFechaPublicacionConstraintsSpec extends Specification {

    def setup() {
        mockForConstraintsTests( Noticia, [ new Noticia() ] )
    }

    def "test 'nullable' constraint"() {

        when:
            def instance = new Noticia( fechaPublicacion:fechaPublicacion )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'fechaPublicacion' ] != null
            instance.errors[ 'fechaPublicacion' ] == 'nullable'
        where:
            fechaPublicacion = null

    }

}