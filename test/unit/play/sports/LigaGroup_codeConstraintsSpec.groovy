package play.sports

import grails.test.mixin.*
import spock.lang.*

@TestFor(Liga)
class LigaGroup_codeConstraintsSpec extends Specification {

    def setup() {
        mockForConstraintsTests( Liga, [ new Liga() ] )
    }

    def "test 'nullable' constraint"() {

        when:
            def instance = new Liga( group_code:group_code )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'group_code' ] != null
            instance.errors[ 'group_code' ] == 'nullable'
        where:
            group_code = null

    }

}