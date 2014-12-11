package play.sports

import grails.gorm.DetachedCriteria
import grails.validation.ValidationException

class NoticiaService {

    Map list( Map params ) {

        processParams( params )
        def criteria = new DetachedCriteria( Noticia ).build {}
        [ items:criteria.list( params ), total:criteria.count() ]

    }

    void create( Noticia noticia ) {
        save( noticia )
    }

    void update( Noticia noticia ) {
        save( noticia )
    }

    Noticia get( Long id ) {

        if ( id == null ) throw new IllegalArgumentException(
            "Parameter 'id' is null" )
        Noticia.findById( id )

    }

    void delete( Noticia noticia ) {

        if ( noticia == null ) throw new IllegalArgumentException(
            "Parameter 'noticia' is null" )
        noticia.delete()

    }

    private void processParams( params ) {

        params.max = ListUtils.parseMax( params.max )
        params.offset = ListUtils.parseOffset( params.offset )
        params.order = ListUtils.parseOrder( params.order )
        def fields = [ 'titulo', 'fechaPublicacion', 'redactor', 'contenido', 'imagen', 'id' ]
        params.sort = ListUtils.parseSort( params.sort, fields )

    }

    private void save( Noticia noticia ) {

        if ( !noticia ) throw new IllegalArgumentException(
            "Parameter 'noticia' is null" )
        try {
            noticia.save( failOnError:true )
        } catch ( ValidationException ) {
            throw new IllegalArgumentException(
                "Parameter 'noticia' is invalid" )
        }

    }

}