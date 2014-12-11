package play.sports

import grails.test.mixin.*
import spock.lang.*

@TestFor(Categoria)
class CategoriaNombreConstraintsSpec extends Specification {

    def setup() {
        mockForConstraintsTests( Categoria, [ new Categoria() ] )
    }

    def "test 'nullable' constraint"() {

        when:
            def instance = new Categoria( nombre:nombre )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'nombre' ] != null
            instance.errors[ 'nombre' ] == 'nullable'
        where:
            nombre = null

    }

    def "test 'maxSize' constraint"() {

        when:
            def instance = new Categoria( nombre:nombre )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'nombre' ] != null
            instance.errors[ 'nombre' ] == 'maxSize'
        where:
            nombre = 'A' * 51

    }

}