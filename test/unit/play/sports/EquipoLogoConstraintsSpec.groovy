package play.sports

import grails.test.mixin.*
import spock.lang.*

@TestFor(Equipo)
class EquipoLogoConstraintsSpec extends Specification {

    def setup() {
        mockForConstraintsTests( Equipo, [ new Equipo() ] )
    }

    def "test 'nullable' constraint"() {

        when:
            def instance = new Equipo( logo:logo )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'logo' ] != null
            instance.errors[ 'logo' ] == 'nullable'
        where:
            logo = null

    }

}