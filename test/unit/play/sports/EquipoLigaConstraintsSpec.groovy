package play.sports

import grails.test.mixin.*
import spock.lang.*

@TestFor(Equipo)
class EquipoLigaConstraintsSpec extends Specification {

    def setup() {
        mockForConstraintsTests( Equipo, [ new Equipo() ] )
    }

    def "test 'nullable' constraint"() {

        when:
            def instance = new Equipo( liga:liga )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'liga' ] != null
            instance.errors[ 'liga' ] == 'nullable'
        where:
            liga = null

    }

}