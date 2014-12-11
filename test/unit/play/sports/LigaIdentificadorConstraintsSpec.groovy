package play.sports

import grails.test.mixin.*
import spock.lang.*

@TestFor(Liga)
class LigaIdentificadorConstraintsSpec extends Specification {

    def setup() {
        mockForConstraintsTests( Liga, [ new Liga() ] )
    }

    def "test 'nullable' constraint"() {

        when:
            def instance = new Liga( identificador:identificador )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'identificador' ] != null
            instance.errors[ 'identificador' ] == 'nullable'
        where:
            identificador = null

    }

}