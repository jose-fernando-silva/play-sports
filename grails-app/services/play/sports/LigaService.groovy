package play.sports

import grails.gorm.DetachedCriteria
import grails.validation.ValidationException

class LigaService {

    Map list( Map params ) {

        processParams( params )
        def criteria = new DetachedCriteria( Liga ).build {}
        [ items:criteria.list( params ), total:criteria.count() ]

    }

    void create( Liga liga ) {
        save( liga )
    }

    void update( Liga liga ) {
        save( liga )
    }

    Liga get( Long id ) {

        if ( id == null ) throw new IllegalArgumentException(
            "Parameter 'id' is null" )
        Liga.findById( id )

    }

    void delete( Liga liga ) {

        if ( liga == null ) throw new IllegalArgumentException(
            "Parameter 'liga' is null" )
        liga.delete()

    }

    private void processParams( params ) {

        params.max = ListUtils.parseMax( params.max )
        params.offset = ListUtils.parseOffset( params.offset )
        params.order = ListUtils.parseOrder( params.order )
        def fields = [ 'year', 'group_code', 'playoff', 'name', 'country', 'current_round', 'total_group', 'total_rounds', 'flag', 'phase', 'identificador', 'id' ]
        params.sort = ListUtils.parseSort( params.sort, fields )

    }

    private void save( Liga liga ) {

        if ( !liga ) throw new IllegalArgumentException(
            "Parameter 'liga' is null" )
        try {
            liga.save( failOnError:true )
        } catch ( ValidationException ) {
            throw new IllegalArgumentException(
                "Parameter 'liga' is invalid" )
        }

    }

}