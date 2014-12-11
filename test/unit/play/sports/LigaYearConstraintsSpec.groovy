package play.sports

import grails.test.mixin.*
import spock.lang.*

@TestFor(Liga)
class LigaYearConstraintsSpec extends Specification {

    def setup() {
        mockForConstraintsTests( Liga, [ new Liga() ] )
    }

    def "test 'nullable' constraint"() {

        when:
            def instance = new Liga( year:year )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'year' ] != null
            instance.errors[ 'year' ] == 'nullable'
        where:
            year = null

    }

}