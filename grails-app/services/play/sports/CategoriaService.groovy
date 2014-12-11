package play.sports

import grails.gorm.DetachedCriteria
import grails.validation.ValidationException

class CategoriaService {

    Map list( Map params ) {

        processParams( params )
        def criteria = new DetachedCriteria( Categoria ).build {}
        [ items:criteria.list( params ), total:criteria.count() ]

    }

    void create( Categoria categoria ) {
        save( categoria )
    }

    void update( Categoria categoria ) {
        save( categoria )
    }

    Categoria get( Long id ) {

        if ( id == null ) throw new IllegalArgumentException(
            "Parameter 'id' is null" )
        Categoria.findById( id )

    }

    void delete( Categoria categoria ) {

        if ( categoria == null ) throw new IllegalArgumentException(
            "Parameter 'categoria' is null" )
        categoria.delete()

    }

    private void processParams( params ) {

        params.max = ListUtils.parseMax( params.max )
        params.offset = ListUtils.parseOffset( params.offset )
        params.order = ListUtils.parseOrder( params.order )
        def fields = [ 'nombre', 'descripcion', 'id' ]
        params.sort = ListUtils.parseSort( params.sort, fields )

    }

    private void save( Categoria categoria ) {

        if ( !categoria ) throw new IllegalArgumentException(
            "Parameter 'categoria' is null" )
        try {
            categoria.save( failOnError:true )
        } catch ( ValidationException ) {
            throw new IllegalArgumentException(
                "Parameter 'categoria' is invalid" )
        }

    }

}