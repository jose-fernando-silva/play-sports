package play.sports

import grails.test.mixin.*
import spock.lang.*

@TestFor(Liga)
class LigaTotal_roundsConstraintsSpec extends Specification {

    def setup() {
        mockForConstraintsTests( Liga, [ new Liga() ] )
    }

    def "test 'nullable' constraint"() {

        when:
            def instance = new Liga( total_rounds:total_rounds )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'total_rounds' ] != null
            instance.errors[ 'total_rounds' ] == 'nullable'
        where:
            total_rounds = null

    }

}