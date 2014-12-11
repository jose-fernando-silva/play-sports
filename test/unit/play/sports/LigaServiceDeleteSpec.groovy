package play.sports

import grails.test.mixin.*
import spock.lang.*

@TestFor(LigaService)
@Mock(Liga)
class LigaServiceDeleteSpec extends Specification {

    def setup() {
        LigaMock.mock( 0 ).save( failOnError:true )
    }

    def " test ok"() {

        when:
            def instance = service.get( id )
            service.delete( instance )
        then:
            Liga.count() == 0
        where:
            id = 1

    }

    void "test Liga null"() {

        when:
            service.delete( liga )
        then:
            IllegalArgumentException e = thrown()
            e.message == "Parameter 'liga' is null"
        where:
            liga = null

    }

    def " test invalid"() {

        when:
            def instance = new Liga()
            service.delete( instance )
        then:
            Liga.exists( instance.id ) == false

    }

}