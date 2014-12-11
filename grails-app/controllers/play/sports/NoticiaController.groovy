package play.sports

class NoticiaController {

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

    def noticiaService
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

        def model = [ noticiaInstance:new Noticia( params ) ]
        render( template:'form', model:model )

    }

    def save() {

        def noticia = new Noticia( params )
        saveOnDb( noticia, 'create' )

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
        map.noticiaInstance.properties = params
        map.edit = true
        saveOnDb( map.noticiaInstance, 'update', true )

    }

    def delete( Long id ) {

        def map = get( id )
        if ( !map ) return
        noticiaService.delete( map.noticiaInstance )
        flash.listMessage = message( code:'default.deleted.message',
            args:[ message( code:'noticia.label',
            default:'Noticia' ), id ] )
        redirect( action:'content' )

    }

    private void renderList( template ) {

        def model = [:]
        def result = noticiaService.list( params )
        model.items = result.items
        model.total = result.total
        render( template:template, model:model )

    }

    private Map get( Long id ) {

        if ( id == null ) {
            notifyCrack()
            return null
        }
        def noticia = noticiaService.get( id )
        if ( !noticia ) {
            notifyCrack()
            return null
        }
        [ noticiaInstance:noticia ]

    }

    private void saveOnDb( noticia, method, edit = false ) {

        try {
            noticiaService."${method}"( noticia )
        } catch ( IllegalArgumentException e ) {
            response.status = 400
            render( template:'form', model:[ noticiaInstance:noticia,
                edit:edit ] )
            return
        }
        flash.formMessage = message(
            code:"default.${edit?'updated':'created'}.message",
            args:[ message( code:'noticia.label',
            default:'Noticia' ), noticia.id])
        redirect( action:'edit', id:noticia.id )

    }

    private void notifyCrack() {

        crackingService.notify( request, params )
        redirect( controller:'logout' )

    }

    def mostrarNoticia() {
        def categoria = Categoria.findByNombre(params.categoria)
        def noticia = Noticia.findByIdAndCategoria(params.id, categoria)
        [noticia: noticia]
    }

    def mostrarNoticias() {
        def categoria = Categoria.findByNombre(params.categoria)
        def noticias = Noticia.findAllByCategoria(categoria, [sort: "fechaPublicacion", order: "desc"])
        [noticias: noticias, categoria: categoria]
    }
}