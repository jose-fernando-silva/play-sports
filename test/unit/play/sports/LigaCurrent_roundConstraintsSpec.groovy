package play.sports

import grails.test.mixin.*
import spock.lang.*

@TestFor(Liga)
class LigaCurrent_roundConstraintsSpec extends Specification {

    def setup() {
        mockForConstraintsTests( Liga, [ new Liga() ] )
    }

    def "test 'nullable' constraint"() {

        when:
            def instance = new Liga( current_round:current_round )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'current_round' ] != null
            instance.errors[ 'current_round' ] == 'nullable'
        where:
            current_round = null

    }

}