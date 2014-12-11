package play.sports

class EquipoController {

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

    def equipoService
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

        def model = [ equipoInstance:new Equipo( params ) ]
        render( template:'form', model:model )

    }

    def save() {

        def equipo = new Equipo( params )
        saveOnDb( equipo, 'create' )

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
        map.equipoInstance.properties = params
        map.edit = true
        saveOnDb( map.equipoInstance, 'update', true )

    }

    def delete( Long id ) {

        def map = get( id )
        if ( !map ) return
        equipoService.delete( map.equipoInstance )
        flash.listMessage = message( code:'default.deleted.message',
            args:[ message( code:'equipo.label',
            default:'Equipo' ), id ] )
        redirect( action:'content' )

    }

    private void renderList( template ) {

        def model = [:]
        def result = equipoService.list( params )
        model.items = result.items
        model.total = result.total
        render( template:template, model:model )

    }

    private Map get( Long id ) {

        if ( id == null ) {
            notifyCrack()
            return null
        }
        def equipo = equipoService.get( id )
        if ( !equipo ) {
            notifyCrack()
            return null
        }
        [ equipoInstance:equipo ]

    }

    private void saveOnDb( equipo, method, edit = false ) {

        try {
            equipoService."${method}"( equipo )
        } catch ( IllegalArgumentException e ) {
            response.status = 400
            render( template:'form', model:[ equipoInstance:equipo,
                edit:edit ] )
            return
        }
        flash.formMessage = message(
            code:"default.${edit?'updated':'created'}.message",
            args:[ message( code:'equipo.label',
            default:'Equipo' ), equipo.id])
        redirect( action:'edit', id:equipo.id )

    }

    private void notifyCrack() {

        crackingService.notify( request, params )
        redirect( controller:'logout' )

    }

    def formCargarEquipos() {
        def ligas = Liga.list([sort: "name", order: "asc"])         
        render template: "formCargarEquipos", model: [ligas: ligas]
    }

    def cargarEquipos() {
        def key = "c443b85924f49874e88abb9aa116747a"
        def objResultado
        def ligaIdentificador = params.ligaId
        def liga = Liga.findByIdentificador(ligaIdentificador)
        try { 
            
            withHttp(uri: "http://www.resultados-futbol.com") {
                objResultado = get(path : '/scripts/api/api.php', query : [key: key, format: 'json', req: 'matchs', league: liga.identificador, round:"1"]) 
            }  
        }catch(Exception e) {
            objResultado = "Hay problemas con la conexión a Internet"
        }
        if(objResultado == "Hay problemas con la conexión a Internet") {
            render objResultado
        } else {
            def numEquiposRegistrados = 0
            def equipo
            def partidos = objResultado["match"]

            partidos.each{ partido ->
                equipo = new Equipo(nombre: partido["local"], logo: partido["local_shield"], identificador: partido["team1"], liga: liga)
                equipo.save()
                equipo = new Equipo(nombre: partido["visitor"], logo: partido["visitor_shield"], identificador: partido["team2"], liga: liga)
                equipo.save()
                numEquiposRegistrados += 2
            }
            render template: "totalEquipos", model: [numEquiposCargados: numEquiposRegistrados]
        }
    }


}