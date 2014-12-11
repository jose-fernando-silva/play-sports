package play.sports

import grails.test.mixin.*
import spock.lang.*

@TestFor(LigaService)
@Mock(Liga)
class LigaServiceUpdateSpec extends Specification {

    def "test ok"() {

        when:
            def instance = LigaMock.mock( 0 )
            service.update( instance )
        then:
            Liga.count() == 1

    }

    def "test Liga null"() {

        when:
            def instance = null
            service.update( instance )
        then:
            IllegalArgumentException e = thrown()
            e.message == "Parameter 'liga' is null"

    }

    def "test Liga invalid"() {

        when:
            def instance = LigaMock.mock( 0 )
            instance.year = year
            service.update( instance )
        then:
            IllegalArgumentException e = thrown()
            e.message == "Parameter 'liga' is invalid"
        where:
            year = null
    }

}