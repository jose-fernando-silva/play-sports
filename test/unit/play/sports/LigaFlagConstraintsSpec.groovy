package play.sports

import grails.test.mixin.*
import spock.lang.*

@TestFor(Liga)
class LigaFlagConstraintsSpec extends Specification {

    def setup() {
        mockForConstraintsTests( Liga, [ new Liga() ] )
    }

    def "test 'nullable' constraint"() {

        when:
            def instance = new Liga( flag:flag )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'flag' ] == null
        where:
            flag = null

    }

}