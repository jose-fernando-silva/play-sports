package play.sports

import grails.test.mixin.*
import spock.lang.*

@TestFor(Liga)
class LigaCountryConstraintsSpec extends Specification {

    def setup() {
        mockForConstraintsTests( Liga, [ new Liga() ] )
    }

    def "test 'nullable' constraint"() {

        when:
            def instance = new Liga( country:country )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'country' ] != null
            instance.errors[ 'country' ] == 'nullable'
        where:
            country = null

    }

}