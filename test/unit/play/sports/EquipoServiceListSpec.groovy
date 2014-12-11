package play.sports

import grails.test.mixin.*
import spock.lang.*

@TestFor(EquipoService)
@Mock(Equipo)
class EquipoServiceListSpec extends Specification {

    def "test ok"() {

        when:
            def result = service.list( params )
        then:
            result.items != null
            result.total != null
        where:
            params = [:]

    }

}