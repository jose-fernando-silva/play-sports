package play.sports

import grails.test.mixin.*
import spock.lang.*

@TestFor(EquipoService)
@Mock(Equipo)
class EquipoServiceDeleteSpec extends Specification {

    def setup() {
        EquipoMock.mock( 0 ).save( failOnError:true )
    }

    def " test ok"() {

        when:
            def instance = service.get( id )
            service.delete( instance )
        then:
            Equipo.count() == 0
        where:
            id = 1

    }

    void "test Equipo null"() {

        when:
            service.delete( equipo )
        then:
            IllegalArgumentException e = thrown()
            e.message == "Parameter 'equipo' is null"
        where:
            equipo = null

    }

    def " test invalid"() {

        when:
            def instance = new Equipo()
            service.delete( instance )
        then:
            Equipo.exists( instance.id ) == false

    }

}