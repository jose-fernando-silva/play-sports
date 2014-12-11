package play.sports

import grails.test.mixin.*
import spock.lang.*

@TestFor(Noticia)
class NoticiaRedactorConstraintsSpec extends Specification {

    def setup() {
        mockForConstraintsTests( Noticia, [ new Noticia() ] )
    }

    def "test 'nullable' constraint"() {

        when:
            def instance = new Noticia( redactor:redactor )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'redactor' ] != null
            instance.errors[ 'redactor' ] == 'nullable'
        where:
            redactor = null

    }

    def "test 'maxSize' constraint"() {

        when:
            def instance = new Noticia( redactor:redactor )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'redactor' ] != null
            instance.errors[ 'redactor' ] == 'maxSize'
        where:
            redactor = 'A' * 71

    }

}