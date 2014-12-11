package play.sports

import grails.test.mixin.*
import spock.lang.*

@TestFor(EquipoService)
@Mock(Equipo)
class EquipoServiceUpdateSpec extends Specification {

    def "test ok"() {

        when:
            def instance = EquipoMock.mock( 0 )
            service.update( instance )
        then:
            Equipo.count() == 1

    }

    def "test Equipo null"() {

        when:
            def instance = null
            service.update( instance )
        then:
            IllegalArgumentException e = thrown()
            e.message == "Parameter 'equipo' is null"

    }

    def "test Equipo invalid"() {

        when:
            def instance = EquipoMock.mock( 0 )
            instance.nombre = nombre
            service.update( instance )
        then:
            IllegalArgumentException e = thrown()
            e.message == "Parameter 'equipo' is invalid"
        where:
            nombre = null
    }

}