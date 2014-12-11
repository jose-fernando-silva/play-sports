package play.sports

import grails.test.mixin.*
import spock.lang.*

@TestFor(Equipo)
class EquipoNombreConstraintsSpec extends Specification {

    def setup() {
        mockForConstraintsTests( Equipo, [ new Equipo() ] )
    }

    def "test 'nullable' constraint"() {

        when:
            def instance = new Equipo( nombre:nombre )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'nombre' ] != null
            instance.errors[ 'nombre' ] == 'nullable'
        where:
            nombre = null

    }

}