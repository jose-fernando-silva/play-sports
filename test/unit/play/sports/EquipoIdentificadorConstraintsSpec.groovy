package play.sports

import grails.test.mixin.*
import spock.lang.*

@TestFor(Equipo)
class EquipoIdentificadorConstraintsSpec extends Specification {

    def setup() {
        mockForConstraintsTests( Equipo, [ new Equipo() ] )
    }

    def "test 'nullable' constraint"() {

        when:
            def instance = new Equipo( identificador:identificador )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'identificador' ] != null
            instance.errors[ 'identificador' ] == 'nullable'
        where:
            identificador = null

    }

}