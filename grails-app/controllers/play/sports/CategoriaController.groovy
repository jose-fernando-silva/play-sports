package play.sports

class CategoriaController {

    static allowedMethods = [
        index:'GET',
        content:'GET',
        list:'GET',
        create:'GET',
        save:'POST',
        edit:'GET',
        update:'POST',
        delete:'POST'
    ]

    def categoriaService
    def crackingService

    def index() {
        redirect( action:'content', params:params )
    }

    def content() {
        renderList( 'content' )
    }

    def list() {
        renderList( 'list' )
    }

    def create() {

        def model = [ categoriaInstance:new Categoria( params ) ]
        render( template:'form', model:model )

    }

    def save() {

        def categoria = new Categoria( params )
        saveOnDb( categoria, 'create' )

    }

    def edit( Long id ) {

        def map = get( id )
        if ( !map ) return
        map.edit = true
        render( template:'form', model:map )

    }

    def update( Long id ) {

        def map = get( id )
        if ( !map ) return
        map.categoriaInstance.properties = params
        map.edit = true
        saveOnDb( map.categoriaInstance, 'update', true )

    }

    def delete( Long id ) {

        def map = get( id )
        if ( !map ) return
        categoriaService.delete( map.categoriaInstance )
        flash.listMessage = message( code:'default.deleted.message',
            args:[ message( code:'categoria.label',
            default:'Categoria' ), id ] )
        redirect( action:'content' )

    }

    private void renderList( template ) {

        def model = [:]
        def result = categoriaService.list( params )
        model.items = result.items
        model.total = result.total
        render( template:template, model:model )

    }

    private Map get( Long id ) {

        if ( id == null ) {
            notifyCrack()
            return null
        }
        def categoria = categoriaService.get( id )
        if ( !categoria ) {
            notifyCrack()
            return null
        }
        [ categoriaInstance:categoria ]

    }

    private void saveOnDb( categoria, method, edit = false ) {

        try {
            categoriaService."${method}"( categoria )
        } catch ( IllegalArgumentException e ) {
            response.status = 400
            render( template:'form', model:[ categoriaInstance:categoria,
                edit:edit ] )
            return
        }
        flash.formMessage = message(
            code:"default.${edit?'updated':'created'}.message",
            args:[ message( code:'categoria.label',
            default:'Categoria' ), categoria.id])
        redirect( action:'edit', id:categoria.id )

    }

    private void notifyCrack() {

        crackingService.notify( request, params )
        redirect( controller:'logout' )

    }

}