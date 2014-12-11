package play.sports

import grails.test.mixin.*
import spock.lang.*

@TestFor(Liga)
class LigaTotal_groupConstraintsSpec extends Specification {

    def setup() {
        mockForConstraintsTests( Liga, [ new Liga() ] )
    }

    def "test 'nullable' constraint"() {

        when:
            def instance = new Liga( total_group:total_group )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'total_group' ] != null
            instance.errors[ 'total_group' ] == 'nullable'
        where:
            total_group = null

    }

}