package play.sports

import grails.test.mixin.*
import spock.lang.*

@TestFor(Liga)
class LigaNameConstraintsSpec extends Specification {

    def setup() {
        mockForConstraintsTests( Liga, [ new Liga() ] )
    }

    def "test 'nullable' constraint"() {

        when:
            def instance = new Liga( name:name )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'name' ] != null
            instance.errors[ 'name' ] == 'nullable'
        where:
            name = null

    }

}