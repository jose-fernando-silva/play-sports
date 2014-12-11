package play.sports

import grails.gorm.DetachedCriteria
import grails.validation.ValidationException

class EquipoService {

    Map list( Map params ) {

        processParams( params )
        def criteria = new DetachedCriteria( Equipo ).build {}
        [ items:criteria.list( params ), total:criteria.count() ]

    }

    void create( Equipo equipo ) {
        save( equipo )
    }

    void update( Equipo equipo ) {
        save( equipo )
    }

    Equipo get( Long id ) {

        if ( id == null ) throw new IllegalArgumentException(
            "Parameter 'id' is null" )
        Equipo.findById( id )

    }

    void delete( Equipo equipo ) {

        if ( equipo == null ) throw new IllegalArgumentException(
            "Parameter 'equipo' is null" )
        equipo.delete()

    }

    private void processParams( params ) {

        params.max = ListUtils.parseMax( params.max )
        params.offset = ListUtils.parseOffset( params.offset )
        params.order = ListUtils.parseOrder( params.order )
        def fields = [ 'nombre', 'logo', 'identificador', 'id' ]
        params.sort = ListUtils.parseSort( params.sort, fields )

    }

    private void save( Equipo equipo ) {

        if ( !equipo ) throw new IllegalArgumentException(
            "Parameter 'equipo' is null" )
        try {
            equipo.save( failOnError:true )
        } catch ( ValidationException ) {
            throw new IllegalArgumentException(
                "Parameter 'equipo' is invalid" )
        }

    }

}