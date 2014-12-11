package play.sports

import grails.test.mixin.*
import spock.lang.*

@TestFor(Liga)
class LigaPlayoffConstraintsSpec extends Specification {

    def setup() {
        mockForConstraintsTests( Liga, [ new Liga() ] )
    }

    def "test 'nullable' constraint"() {

        when:
            def instance = new Liga( playoff:playoff )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'playoff' ] != null
            instance.errors[ 'playoff' ] == 'nullable'
        where:
            playoff = null

    }

}