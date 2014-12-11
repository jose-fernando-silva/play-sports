package play.sports

import grails.test.mixin.*
import spock.lang.*

@TestFor(Liga)
class LigaPhaseConstraintsSpec extends Specification {

    def setup() {
        mockForConstraintsTests( Liga, [ new Liga() ] )
    }

    def "test 'nullable' constraint"() {

        when:
            def instance = new Liga( phase:phase )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'phase' ] == null
        where:
            phase = null

    }

}