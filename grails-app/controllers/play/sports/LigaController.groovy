package play.sports

class LigaController {

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

    def ligaService
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

        def model = [ ligaInstance:new Liga( params ) ]
        render( template:'form', model:model )

    }

    def save() {

        def liga = new Liga( params )
        saveOnDb( liga, 'create' )

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
        map.ligaInstance.properties = params
        map.edit = true
        saveOnDb( map.ligaInstance, 'update', true )

    }

    def delete( Long id ) {

        def map = get( id )
        if ( !map ) return
        ligaService.delete( map.ligaInstance )
        flash.listMessage = message( code:'default.deleted.message',
            args:[ message( code:'liga.label',
            default:'Liga' ), id ] )
        redirect( action:'content' )

    }

    private void renderList( template ) {

        def model = [:]
        def result = ligaService.list( params )
        model.items = result.items
        model.total = result.total
        render( template:template, model:model )

    }

    private Map get( Long id ) {

        if ( id == null ) {
            notifyCrack()
            return null
        }
        def liga = ligaService.get( id )
        if ( !liga ) {
            notifyCrack()
            return null
        }
        [ ligaInstance:liga ]

    }

    private void saveOnDb( liga, method, edit = false ) {

        try {
            ligaService."${method}"( liga )
        } catch ( IllegalArgumentException e ) {
            response.status = 400
            render( template:'form', model:[ ligaInstance:liga,
                edit:edit ] )
            return
        }
        flash.formMessage = message(
            code:"default.${edit?'updated':'created'}.message",
            args:[ message( code:'liga.label',
            default:'Liga' ), liga.id])
        redirect( action:'edit', id:liga.id )

    }

    private void notifyCrack() {

        crackingService.notify( request, params )
        redirect( controller:'logout' )

    }

}

