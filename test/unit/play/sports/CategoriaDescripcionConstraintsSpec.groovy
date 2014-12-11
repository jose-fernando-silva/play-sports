package play.sports

import grails.test.mixin.*
import spock.lang.*

@TestFor(Categoria)
class CategoriaDescripcionConstraintsSpec extends Specification {

    def setup() {
        mockForConstraintsTests( Categoria, [ new Categoria() ] )
    }

    def "test 'nullable' constraint"() {

        when:
            def instance = new Categoria( descripcion:descripcion )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'descripcion' ] != null
            instance.errors[ 'descripcion' ] == 'nullable'
        where:
            descripcion = null

    }

    def "test 'maxSize' constraint"() {

        when:
            def instance = new Categoria( descripcion:descripcion )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'descripcion' ] != null
            instance.errors[ 'descripcion' ] == 'maxSize'
        where:
            descripcion = 'A' * 256

    }

}